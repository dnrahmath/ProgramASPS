/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import programasps.backend.koneksiData;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import programasps.backend.config;

/**
 *
 * @author dnrahmath
 */
public class DcMenuKembalikanBuku extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //colors background
    Color colorBackground;
    Color colorBackgroundForm;
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    
    String[][] DataLogin;
    String[][] DataTable;
    
    String[] CustomListColmnBuku = { 
            "Id", 
            "Judul Buku", 
            "Penulis Buku", 
            "Penerbit Oleh", 
            "Tahun Buku",
            "Kelas",
//          "Status Buku",
            "System Id"
            //"Nama petugas input"  //menghilangkan colum nama_petugas_input
        };;
    
    String[] listColmnBuku= { 
            "id_buku", 
            "judul_buku", 
            "penulis_buku", 
            "penerbit_oleh", 
            "tahun_buku", 
            "buku_kelas",
//          "status_buku",
            "system_id",
            "nama_petugas_input"
        };
    
    public DcMenuKembalikanBuku(Color colorRGBA,Color colorRGBAForm) {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        colorBackground = colorRGBA;
        colorBackgroundForm = colorRGBAForm;
        
        panelJudul1.setBackground(colorBackgroundForm);
        panelIsi1.setBackground(colorBackgroundForm);
        panelIsi2.setBackground(colorBackgroundForm);
        panelBtn1.setBackground(colorBackgroundForm);
        //[panelBelakang]
        panelLogin.setBackground(colorBackground);
        
        
        JComboBox1.setBackground(new Color(255, 255, 255, 255));
                
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
    }
    
    public void getTable(){
        //ComboBox Pilihan  -------
        String CustomListColmn[]= { 
            "id pinjam", 
            "id buku", 
            "judul buku", 
            "status buku", 
            "tgl peminjaman", 
            "tgl pengembalian", 
            "id user peminjam",
            "denda",
            "waktu pinjam (hari)",
            "system id"
        };
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
        
        String listColmn[]= { 
            "id_pinjam", 
            "id_buku", 
            "judul_buku", 
            "status_buku", 
            "tgl_peminjaman", 
            "tgl_pengembalian", 
            "id_user_peminjam",
            "denda",
            "waktu_pinjam",
            "system_id"
        };
        
        
        
        //koneksiData conn = new koneksiData();
        String[] option = {"id_user_peminjam"};
        String[] search = {DataLogin[0][0]};
        DataTable = koneksiData.cSelectOneDef("tbl_pinjam",listColmn,1000,option,search);
        
        
        //-------------------------------------------------------------------------------
        String nominalDendaRp = "0";
        for (int i = 0; i < DataTable.length ; i++) {
            if(DataTable[i][4] != null){
                String thn1 = DataTable[i][4].substring(0,4);
                String bln1 = DataTable[i][4].substring(5,7);
                String hri1 = DataTable[i][4].substring(8,10);
                int intThn1 = Integer.parseInt(thn1);
                int intBln1 = Integer.parseInt(bln1);
                int intHri1 = Integer.parseInt(hri1);
                int waktuPinjam = Integer.parseInt(DataTable[i][8]);
                nominalDendaRp = hitungDendaString(waktuPinjam,intThn1,intBln1,intHri1);
                DataTable[i][7] = nominalDendaRp;
                koneksiData.cUpdate("tbl_pinjam",listColmn,DataTable[i],"id_pinjam",DataTable[i][0]);
            }
        }
        //-------------------------------------------------------------------------------
        
        
        DefaultTableModel model = (DefaultTableModel)tblPinjam.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        
        
        tblPinjam.getColumnModel().getColumn(0).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(0).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(2).getPreferredWidth();
        tblPinjam.getColumnModel().getColumn(3).setMinWidth(100);
        tblPinjam.getColumnModel().getColumn(3).setMaxWidth(100);
        tblPinjam.getColumnModel().getColumn(4).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(4).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(6).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(6).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(7).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(7).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(8).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(8).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(9).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(9).setMaxWidth(40);
    
    }
    
    public static String hitungDendaString(int waktuPinjam, int intThn1Pinjam,int intBln1Pinjam, int intHri1Pinjam){
        //----------------------------------------------------------------
        LocalDate tglPinjam = LocalDate.of(intThn1Pinjam, intBln1Pinjam, intHri1Pinjam);
        LocalDate tglKembali = LocalDate.now();
        Period rentang = Period.between(tglPinjam, tglKembali);
        int rentangHri = rentang.getDays();
        int rentangBln = rentang.getMonths()*30;
        int rentangThn = (rentang.getYears()*12)*30;
          
//        int tidakDenda = 1;
        int nominalDenda = 0;
          
        int jmlhTelatHri = 0;
        int totalHri = rentangHri+rentangBln+rentangThn;  //waktu lama dipinjam dalam hari
        System.out.println("jumlah rentang hari : "+totalHri);
        if(totalHri > waktuPinjam){ //jika lehih dari 7 hari
//            tidakDenda = 0; //disetting kenaDenda
            jmlhTelatHri = totalHri - waktuPinjam;
            nominalDenda = config.nominalDendaOneDay*jmlhTelatHri;  //kena denda 500/hari semenjak telat
        }else{
//            tidakDenda = 1; //disetting tidak kenaDenda
            nominalDenda = 0;
        }
            
        //DecimalFormat DF = new DecimalFormat("#,###,###,###");
        DecimalFormat DF = new DecimalFormat("##########");
        String nominalDendaRp = DF.format(nominalDenda);
        
        
        /*
        System.out.println("jumlah hari : "+rentangHri);
        System.out.println("jumlah bulan : "+rentangBln);
        System.out.println("jumlah tahun : "+rentangThn);
          
        System.out.println("jumlah telat hari : "+jmlhTelatHri);
        System.out.println("nominal Denda : "+nominalDendaRp);
        */
        return nominalDendaRp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        panelJudul1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelIsi1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        JComboBox1 = new javax.swing.JComboBox<>();
        panelBtn1 = new javax.swing.JPanel();
        btnKembalikanBuku = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        panelIsi2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPinjam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("KEMBALIKAN BUKU");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/buku (2).png"))); // NOI18N

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelIsi1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel15.setText("Cari");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel16.setText(" :");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel24.setText("Berdasarkan");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setText(" :");

        javax.swing.GroupLayout panelIsi1Layout = new javax.swing.GroupLayout(panelIsi1);
        panelIsi1.setLayout(panelIsi1Layout);
        panelIsi1Layout.setHorizontalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JComboBox1)
                .addContainerGap())
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnKembalikanBuku.setBackground(new java.awt.Color(255, 255, 255));
        btnKembalikanBuku.setText("KEMBALIKAN BUKU");
        btnKembalikanBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanBukuActionPerformed(evt);
            }
        });

        btnCancle.setBackground(new java.awt.Color(255, 255, 255));
        btnCancle.setText("CANCLE");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn1Layout = new javax.swing.GroupLayout(panelBtn1);
        panelBtn1.setLayout(panelBtn1Layout);
        panelBtn1Layout.setHorizontalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnKembalikanBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelBtn1Layout.setVerticalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKembalikanBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelIsi2.setBackground(new java.awt.Color(153, 255, 153));

        tblPinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPinjam);

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1415, 767);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembalikanBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanBukuActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)tblPinjam.getModel();
        int selectedRowIndex = tblPinjam.getSelectedRow();
          

        String listColmn[]= { 
            "id_pinjam", 
            "id_buku", 
            "judul_buku", 
            "status_buku", 
            "tgl_peminjaman", 
            "tgl_pengembalian", 
            "id_user_peminjam",
            "denda",
            "waktu_pinjam",
            "system_id"
        };
        
        
        if(-1 != selectedRowIndex){
            String listColmnRow[]= { model.getValueAt(selectedRowIndex, 0).toString(),
                                     model.getValueAt(selectedRowIndex, 1).toString(),
                                     model.getValueAt(selectedRowIndex, 2).toString(),
                                     "DIKEMBALIKAN",
                                     model.getValueAt(selectedRowIndex, 4).toString(),
                                     dtf.format(now),
                                     DataLogin[0][0],
                                     "0",
                                     "0",
                                     DataTable[0][8]+"",
                                     model.getValueAt(selectedRowIndex, 9).toString(),
                                    };
            
            //-------------------------------------------------------------------------------
            String nominalDendaRp = "0";
            for (int i = 0; i < DataTable.length ; i++) {
                if(DataTable[i][4] != null){
                    String thn1 = DataTable[i][4].substring(0,4);
                    String bln1 = DataTable[i][4].substring(5,7);
                    String hri1 = DataTable[i][4].substring(8,10);
                    int intThn1 = Integer.parseInt(thn1);
                    int intBln1 = Integer.parseInt(bln1);
                    int intHri1 = Integer.parseInt(hri1);
                    int waktuPinjam = Integer.parseInt(DataTable[i][8]);
                    nominalDendaRp = hitungDendaString(waktuPinjam,intThn1,intBln1,intHri1);
                    DataTable[i][7] = nominalDendaRp;
                    koneksiData.cUpdate("tbl_pinjam",listColmn,DataTable[i],"id_pinjam",DataTable[i][0]);
                }
            }
            //-------------------------------------------------------------------------------
            
            koneksiData conn = new koneksiData();
            if(nominalDendaRp.equals("0")){ 
                
                //mngupdate 1 colm pada tbl_buku
                String[] ColmToUpdate = {"status_buku"};
                String[] ColmValueToUpdate = {"TIDAK DIPINJAM"};
                String[] optionBuku = {"system_id"};
                String[] searchBuku = {model.getValueAt(selectedRowIndex, 9).toString()};
                koneksiData.cUpdate("tbl_buku",ColmToUpdate,ColmValueToUpdate,optionBuku[0],searchBuku[0]);
                
                conn.cUpdate("tbl_pinjam",listColmn,listColmnRow,listColmn[0],listColmnRow[0]);
                JOptionPane.showMessageDialog(
                        null,
                        "Buku "+listColmnRow[2]+" berhasil DIKEMBALIKAN.",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                
        
                EbKotakSaran KS = new EbKotakSaran(colorBackground,colorBackgroundForm);
                KS.setDefaultCloseOperation(KS.DISPOSE_ON_CLOSE);
                KS.dataIn(DataLogin);
                KS.setLocationRelativeTo(null);
                KS.setVisible(true);
                
            }else{
                EaDenda fDenda;
                try {
                        fDenda = new EaDenda(colorBackground,colorBackgroundForm);
                        //-------------------------------------------------
                        Toolkit tk=Toolkit.getDefaultToolkit(); 
                        Dimension screenSize = tk.getScreenSize(); 
                        fDenda.setSize(1080,screenSize.height);
                        //fDenda.setExtendedState(fDenda.MAXIMIZED_BOTH);
                        //-------------------------------------------------
                        fDenda.setDefaultCloseOperation(fDenda.DISPOSE_ON_CLOSE);
                        fDenda.dataIn(DataLogin);
                        fDenda.isiValue(listColmn,listColmnRow,nominalDendaRp);
                        fDenda.setVal();
                        fDenda.setLocationRelativeTo(null);
                        fDenda.setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DcMenuKembalikanBuku.class.getName()).log(Level.SEVERE, null, ex);
                }
                //kirim datacolom
                this.dispose();
            }
            
        }else{
            JOptionPane.showMessageDialog(
                        null,
                        "Pilihlah buku terlebih dahulu !!",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        txtSearch.setText("");
        getTable();
        
        
        tblPinjam.getColumnModel().getColumn(0).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(0).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(2).getPreferredWidth();
        tblPinjam.getColumnModel().getColumn(3).setMinWidth(100);
        tblPinjam.getColumnModel().getColumn(3).setMaxWidth(100);
        tblPinjam.getColumnModel().getColumn(4).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(4).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(6).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(6).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(8).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(8).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(9).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(9).setMaxWidth(40);
        
    }//GEN-LAST:event_btnKembalikanBukuActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String CustomListColmn[]= { 
            "id pinjam", 
            "id buku", 
            "judul buku", 
            "status buku", 
            "tgl peminjaman", 
            "tgl pengembalian", 
            "id user peminjam",
            "denda",
            "waktu pinjam (hari)"
        };
        //-------------------------------------------
        
        String listColmn[]= { 
            "id_pinjam", 
            "id_buku", 
            "judul_buku", 
            "status_buku", 
            "tgl_peminjaman", 
            "tgl_pengembalian", 
            "id_user_peminjam",
            "denda",
            "waktu_pinjam"
        };
        
        JTextField txtSearchF = (JTextField) evt.getSource();
        
        
        int optionIndex = JComboBox1.getSelectedIndex();
        
        String[] option = {listColmn[optionIndex]};
        String[] search = {txtSearchF.getText()};
        
        DataTable = koneksiData.cSelectOneDef("tbl_pinjam",listColmn,1000,option,search);
        //-------------------------------------------------------------------------------
        for (int i = 0; i < DataTable.length ; i++) {
            if(DataTable[i][4] != null){
                String thn1 = DataTable[i][4].substring(0,4);
                String bln1 = DataTable[i][4].substring(5,7);
                String hri1 = DataTable[i][4].substring(8,10);
                int intThn1 = Integer.parseInt(thn1);
                int intBln1 = Integer.parseInt(bln1);
                int intHri1 = Integer.parseInt(hri1);
                int waktuPinjam = Integer.parseInt(DataTable[i][8]);
                String nominalDendaRp = hitungDendaString(waktuPinjam,intThn1,intBln1,intHri1);
                DataTable[i][7] = nominalDendaRp;
                koneksiData.cUpdate("tbl_pinjam",listColmn,DataTable[i],"id_pinjam",DataTable[i][0]);
            }
        }
        //-------------------------------------------------------------------------------
        DefaultTableModel model = (DefaultTableModel)tblPinjam.getModel();
        
        
        String dataKosong[][]= {{}};
        if(!"".equals(txtSearchF.getText())){
            if("err".equals(DataTable[0][0]) ){
                model.setDataVector(dataKosong, CustomListColmn);
            }else{
                model.setDataVector(DataTable, CustomListColmn);
            }
        }else{
            model.setDataVector(dataKosong, CustomListColmn);
        }
        
        tblPinjam.getColumnModel().getColumn(0).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(0).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(1).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(2).getPreferredWidth();
        tblPinjam.getColumnModel().getColumn(3).setMinWidth(100);
        tblPinjam.getColumnModel().getColumn(3).setMaxWidth(100);
        tblPinjam.getColumnModel().getColumn(4).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(4).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMinWidth(140);
        tblPinjam.getColumnModel().getColumn(5).setMaxWidth(140);
        tblPinjam.getColumnModel().getColumn(6).setMinWidth(70);
        tblPinjam.getColumnModel().getColumn(6).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(8).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(8).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(9).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(9).setMaxWidth(40);
        
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        //-------------
        this.dispose();
    }//GEN-LAST:event_btnCancleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],Color colorRGBA,Color colorRGBAForm) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DcMenuKembalikanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DcMenuKembalikanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DcMenuKembalikanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DcMenuKembalikanBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                DcMenuKembalikanBuku fRegis = new DcMenuKembalikanBuku(colorRGBA,colorRGBAForm);
                fRegis.setLocationRelativeTo(null);
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox1;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnKembalikanBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTable tblPinjam;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
