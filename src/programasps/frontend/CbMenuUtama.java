/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import programasps.backend.koneksiData;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import static programasps.frontend.DcMenuKembalikanBuku.hitungDendaString;

/**
 *
 * @author dnrahmath
 */
public class CbMenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //colors background
    Color colorBackground;
    Color colorBackgroundForm;
    
    String[][] DataLogin;
    String[][] DataTable;
    
    public CbMenuUtama(Color colorRGBA,Color colorRGBAForm) {
        initComponents();
        //this.setExtendedState(CaMenuSiswa.MAXIMIZED_BOTH);
        
        colorBackground = colorRGBA;
        colorBackgroundForm = colorRGBAForm;
        
        panelJudul1.setBackground(colorBackgroundForm);
        panelBtn1.setBackground(colorBackgroundForm);
        panelBtn2.setBackground(colorBackgroundForm);
        panelBtn3.setBackground(colorBackgroundForm);
        panelBtn4.setBackground(colorBackgroundForm);
        JLTable1.setBackground(colorBackgroundForm);
        panelIsi1.setBackground(colorBackgroundForm);
        //[panelBelakang]
        panelLogin.setBackground(colorBackground);
        
        panelBtn2.setVisible(false);
        
        //-------------------------------------
        //panelBtn2.setSize(680,440);
        //btnProfile.setSize(57,115);
        //btnPinjam.setSize(242,115);
        //btnKembalikan.setSize(242,115);
        //btnAdmin.setSize(242,115);
        //btnLogout.setSize(242,115);
                        
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
    }
    
    public void setValue(){
        jLJudulSelamatDatang.setText("Selamat datang, "+DataLogin[0][1]); //nama
        if( "ADMIN".equals(DataLogin[0][5]) ){ //peran
            btnAdmin.setVisible(true);
            panelBtn4.setVisible(true);
            panelIsi1.setVisible(false);
            JLTable1.setVisible(false);
        }else{
            btnAdmin.setVisible(false);
            panelBtn4.setVisible(false);
            panelIsi1.setVisible(false);
            JLTable1.setVisible(true);
        }
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
            "waktu pinjam (hari)"
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
            "waktu_pinjam"
        };
        
        koneksiData conn = new koneksiData();
        DataTable = koneksiData.cSelectOneDef("tbl_pinjam",listColmn,1000,"id_user_peminjam",DataLogin[0][0]);
        
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
        
        
        DefaultTableModel model = (DefaultTableModel)tblUtama1.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        
        
        tblUtama1.getColumnModel().getColumn(0).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(0).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(1).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(1).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(2).getPreferredWidth();
        tblUtama1.getColumnModel().getColumn(3).setMinWidth(100);
        tblUtama1.getColumnModel().getColumn(3).setMaxWidth(100);
        tblUtama1.getColumnModel().getColumn(4).setMinWidth(140);
        tblUtama1.getColumnModel().getColumn(4).setMaxWidth(140);
        tblUtama1.getColumnModel().getColumn(5).setMinWidth(140);
        tblUtama1.getColumnModel().getColumn(5).setMaxWidth(140);
        tblUtama1.getColumnModel().getColumn(6).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(6).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(7).setMinWidth(10);
        tblUtama1.getColumnModel().getColumn(7).setMaxWidth(60);
        tblUtama1.getColumnModel().getColumn(8).setMinWidth(10);
        tblUtama1.getColumnModel().getColumn(8).setMaxWidth(60);
    
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
        jLJudulSelamatDatang = new javax.swing.JLabel();
        jLJudul = new javax.swing.JLabel();
        panelBtn2 = new javax.swing.JPanel();
        btnPinjam = new javax.swing.JButton();
        btnKembalikan = new javax.swing.JButton();
        panelBtn1 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        panelBtn3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        panelBtn4 = new javax.swing.JPanel();
        btnOperator = new javax.swing.JButton();
        JLTable1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUtama1 = new javax.swing.JTable();
        panelIsi1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        JComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLJudulSelamatDatang.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLJudulSelamatDatang.setText("Selamat datang, ");

        jLJudul.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        jLJudul.setText("MENU UTAMA");

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLJudulSelamatDatang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(367, 367, 367))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLJudulSelamatDatang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBtn2.setBackground(new java.awt.Color(153, 255, 153));

        btnPinjam.setBackground(new java.awt.Color(255, 255, 255));
        btnPinjam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/book (1).png"))); // NOI18N
        btnPinjam.setText("Pinjam Buku");
        btnPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinjamActionPerformed(evt);
            }
        });

        btnKembalikan.setBackground(new java.awt.Color(255, 255, 255));
        btnKembalikan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnKembalikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/buku (2).png"))); // NOI18N
        btnKembalikan.setText("Kembalikan Buku");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn2Layout = new javax.swing.GroupLayout(panelBtn2);
        panelBtn2.setLayout(panelBtn2Layout);
        panelBtn2Layout.setHorizontalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(439, 439, 439)
                .addComponent(btnKembalikan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        panelBtn2Layout.setVerticalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btnKembalikan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnProfile.setBackground(new java.awt.Color(255, 255, 255));
        btnProfile.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/user (1).png"))); // NOI18N
        btnProfile.setText("Profile");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn1Layout = new javax.swing.GroupLayout(panelBtn1);
        panelBtn1.setLayout(panelBtn1Layout);
        panelBtn1Layout.setHorizontalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtn1Layout.setVerticalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtn1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBtn3.setBackground(new java.awt.Color(153, 255, 153));

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-32/enter.png"))); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnAdmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-32/user-interface.png"))); // NOI18N
        btnAdmin.setText("MENU ADMIN");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn3Layout = new javax.swing.GroupLayout(panelBtn3);
        panelBtn3.setLayout(panelBtn3Layout);
        panelBtn3Layout.setHorizontalGroup(
            panelBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelBtn3Layout.setVerticalGroup(
            panelBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelBtn4.setBackground(new java.awt.Color(153, 255, 153));

        btnOperator.setBackground(new java.awt.Color(255, 255, 255));
        btnOperator.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnOperator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/buku (2).png"))); // NOI18N
        btnOperator.setText("OPERATOR PEMINJAMAN DAN PENGEMBALIAN BUKU");
        btnOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn4Layout = new javax.swing.GroupLayout(panelBtn4);
        panelBtn4.setLayout(panelBtn4Layout);
        panelBtn4Layout.setHorizontalGroup(
            panelBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtn4Layout.setVerticalGroup(
            panelBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JLTable1.setBackground(new java.awt.Color(153, 255, 153));

        tblUtama1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblUtama1);

        javax.swing.GroupLayout JLTable1Layout = new javax.swing.GroupLayout(JLTable1);
        JLTable1.setLayout(JLTable1Layout);
        JLTable1Layout.setHorizontalGroup(
            JLTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JLTable1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2)
                .addGap(25, 25, 25))
        );
        JLTable1Layout.setVerticalGroup(
            JLTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JLTable1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
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
                .addGap(26, 26, 26)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JComboBox1)
                        .addGap(6, 6, 6))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JLTable1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelIsi1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBtn4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelJudul1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(197, 197, 197))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(panelBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1478, 1281);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
                
        this.dispose();
        
        DaMenuProfile mProfile = new DaMenuProfile(colorBackground,colorBackgroundForm);
        //-------------------------------------------------
        //Toolkit tk=Toolkit.getDefaultToolkit(); 
        //Dimension screenSize = tk.getScreenSize(); 
        //mProfile.setSize(screenSize.width,screenSize.height);
        mProfile.setExtendedState(mProfile.MAXIMIZED_BOTH);
        //-------------------------------------------------
        mProfile.setDefaultCloseOperation(mProfile.DISPOSE_ON_CLOSE);
        mProfile.dataIn(DataLogin);
        mProfile.setValue();
        mProfile.setLocationRelativeTo(null);
           
        mProfile.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:    
        
        Color SelectColor =  new Color(153,255,204);
        Color unSelectColor = new Color(255, 255, 255); 
        Color arrColor[] = new Color[6];
        arrColor[0] = SelectColor;
        arrColor[1] = unSelectColor;
        arrColor[2] = unSelectColor;
        arrColor[3] = unSelectColor;
        arrColor[4] = unSelectColor;
        arrColor[5] = unSelectColor;
        
        
        FaAdmin MA = new FaAdmin();
        //-------------------------------------------------
        //Toolkit tk=Toolkit.getDefaultToolkit(); 
        //Dimension screenSize = tk.getScreenSize(); 
        //MA.setSize(960,screenSize.height);
        MA.setExtendedState(MA.MAXIMIZED_BOTH);
        //-------------------------------------------------
        MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
        MA.getDataUser();
        MA.dataIn(DataLogin);
        MA.setColor(arrColor);
        //MA.getTable();
        MA.setLocationRelativeTo(null);
        MA.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
        // TODO add your handling code here:

        DcMenuKembalikanBuku mKB = new DcMenuKembalikanBuku(colorBackground,colorBackgroundForm);
        //-------------------------------------------------
        //Toolkit tk=Toolkit.getDefaultToolkit(); 
        //Dimension screenSize = tk.getScreenSize(); 
        //mKB.setSize(960,screenSize.height);
        mKB.setExtendedState(mKB.MAXIMIZED_BOTH);
        //-------------------------------------------------
        mKB.setDefaultCloseOperation(mKB.DISPOSE_ON_CLOSE);
        mKB.dataIn(DataLogin);
        mKB.getTable();
        mKB.setLocationRelativeTo(null);

        mKB.setVisible(true);
    }//GEN-LAST:event_btnKembalikanActionPerformed

    private void btnPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinjamActionPerformed
        // TODO add your handling code here:

        DbMenuPinjamBuku mPB = new DbMenuPinjamBuku(colorBackground,colorBackgroundForm);
        //-------------------------------------------------
        //Toolkit tk=Toolkit.getDefaultToolkit(); 
        //Dimension screenSize = tk.getScreenSize(); 
        //mPB.setSize(960,screenSize.height);
        mPB.setExtendedState(mPB.MAXIMIZED_BOTH);
        //-------------------------------------------------
        mPB.setDefaultCloseOperation(mPB.DISPOSE_ON_CLOSE);
        mPB.dataIn(DataLogin);
        mPB.getTable();
        mPB.setLocationRelativeTo(null);

        mPB.setVisible(true);
    }//GEN-LAST:event_btnPinjamActionPerformed

    private void btnOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorActionPerformed
        // TODO add your handling code here:
        
        
        FbPilihUser PU = new FbPilihUser(colorBackground,colorBackgroundForm);
        //-------------------------------------------------
        //Toolkit tk=Toolkit.getDefaultToolkit(); 
        //Dimension screenSize = tk.getScreenSize(); 
        //MA.setSize(960,screenSize.height);
        PU.setExtendedState(PU.MAXIMIZED_BOTH);
        //-------------------------------------------------
        PU.setDefaultCloseOperation(PU.DISPOSE_ON_CLOSE);
        PU.getTable();
        PU.dataIn(DataLogin);
        PU.setLocationRelativeTo(null);
        PU.setVisible(true);
    }//GEN-LAST:event_btnOperatorActionPerformed

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
        String option = listColmn[optionIndex];
        //System.out.println("dipilih : "+option);

        String search = txtSearchF.getText();

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
        DefaultTableModel model = (DefaultTableModel)tblUtama1.getModel();
        
        

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
        
        
        tblUtama1.getColumnModel().getColumn(0).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(0).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(1).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(1).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(2).getPreferredWidth();
        tblUtama1.getColumnModel().getColumn(3).setMinWidth(100);
        tblUtama1.getColumnModel().getColumn(3).setMaxWidth(100);
        tblUtama1.getColumnModel().getColumn(4).setMinWidth(140);
        tblUtama1.getColumnModel().getColumn(4).setMaxWidth(140);
        tblUtama1.getColumnModel().getColumn(5).setMinWidth(140);
        tblUtama1.getColumnModel().getColumn(5).setMaxWidth(140);
        tblUtama1.getColumnModel().getColumn(6).setMinWidth(70);
        tblUtama1.getColumnModel().getColumn(6).setMaxWidth(70);
        tblUtama1.getColumnModel().getColumn(7).setMinWidth(10);
        tblUtama1.getColumnModel().getColumn(7).setMaxWidth(60);
        tblUtama1.getColumnModel().getColumn(8).setMinWidth(10);
        tblUtama1.getColumnModel().getColumn(8).setMaxWidth(60);

    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(CbMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CbMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CbMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CbMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CaMenuSiswa().setVisible(true);
                
                CbMenuUtama mSis = new CbMenuUtama(colorRGBA,colorRGBAForm);
                mSis.setLocationRelativeTo(null);
                mSis.setVisible(true) ;
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox1;
    private javax.swing.JPanel JLTable1;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOperator;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel jLJudul;
    private javax.swing.JLabel jLJudulSelamatDatang;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelBtn2;
    private javax.swing.JPanel panelBtn3;
    private javax.swing.JPanel panelBtn4;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTable tblUtama1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
