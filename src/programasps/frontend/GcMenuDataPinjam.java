/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import programasps.backend.koneksiData;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author dnrahmath
 */
public class GcMenuDataPinjam extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();   
    
    
    String ModeData; //table_nama
    String ModeExec; //mode eksekusi
    
    String[][] DataLogin;
    String listColmn[];
    String listColmnRow[];
    
    
    Color SelectColor =  new Color(153,255,204);
    Color unSelectColor = new Color(255, 255, 255); 
    Color arrColor[] = {unSelectColor,unSelectColor,SelectColor,unSelectColor,unSelectColor,unSelectColor};
    
    public GcMenuDataPinjam() {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        panelJudul1.setBackground(new Color(100, 0, 0, 0));
        panelIsi1.setBackground(new Color(100, 0, 0, 0));
        panelBtn1.setBackground(new Color(100, 0, 0, 0));
        //DefaultButtonModel btnEditVar = (DefaultButtonModel)btnEdit.getModel();
        //String btnMode = "INSERT";
        
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
    }
    
    public String dataTable(String[] dataCatch,String[] dataCatchRow,String tblNama,String jenisEksekus){
        listColmn = dataCatch;
        listColmnRow = dataCatchRow;
        
        ModeData = tblNama; //table_nama
        ModeExec = jenisEksekus; //mode eksekusi
        
        return "1";
    }
    
    public void setValue(){
        
        if("UPDATE".equals(ModeExec)){
            btnExec.setText("UPDATE");
        }else{
            btnExec.setText("INSERT");
        }
        
        if("UPDATE".equals(ModeExec)){
            //DISESUAIKAN SETIAP FORM
            txtidpinjam.setText(listColmnRow[0]);
            txtsortid.setText(listColmnRow[1]);
            txtjudulbuku.setText(listColmnRow[2]);
            txtstatusbuku.setText(listColmnRow[3]);
            txttglpinjam.setText(listColmnRow[4]);
            txttglkembali.setText(listColmnRow[5]);
            txtuserpinjam.setText(listColmnRow[6]);
        }else{
            //.setText("");
        }
    }
    
    void submitDataFunc(){
        //
        String listColmnBuku[]={ 
            "id_buku", 
            "judul_buku", 
            "penulis_buku", 
            "penerbit_oleh", 
            "tahun_buku", 
            "sort_id",
            "nama_petugas_input"
        };

        //DISESUAIKAN SETIAP FORM
        String listColmnRowBaru[]= {
            txtidpinjam.getText(),
            txtsortid.getText(),
            txtjudulbuku.getText(),
            txtstatusbuku.getText(),
            txttglpinjam.getText(),
            txttglkembali.getText(),
            txtuserpinjam.getText(),
            txtidpinjam.getText()
        };
        
        
        
        
        // ditambah opsi JIKA KOSONG -> tidak jadi
        if("INSERT".equals(ModeExec)){
            koneksiData conn = new koneksiData();
            String[][] bukuJudul = conn.cSelectOne("tbl_buku",listColmnBuku,100,listColmnBuku[5],txtsortid.getText());
            
            listColmnRowBaru[0] = "0";  //pakai AUTO_INCREMENT
            //[1]
            listColmnRowBaru[2] = bukuJudul[0][1];
            listColmnRowBaru[3] = "DIPINJAM"; 
            listColmnRowBaru[4] = dtf.format(now);  
            listColmnRowBaru[5] = "0";  
            //[6]
            
            conn.cInsert(ModeData,listColmn,listColmnRowBaru);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataPinjam();
            MA.dataIn(DataLogin);
            MA.setColor(arrColor);
            //MA.getTable();
            MA.setLocationRelativeTo(null);
            MA.setVisible(true);
            
        }else{
            koneksiData conn = new koneksiData();
            String[][] bukuJudul = conn.cSelectOne("tbl_buku",listColmnBuku,100,listColmnBuku[5],txtsortid.getText());
            listColmnRowBaru[2] = bukuJudul[0][1];
            listColmnRowBaru[4] = dtf.format(now); 
            conn.cUpdate(ModeData,listColmn,listColmnRowBaru,listColmn[0],listColmnRowBaru[0]);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataPinjam();
            MA.dataIn(DataLogin);
            MA.setColor(arrColor);
            //MA.getTable();
            MA.setLocationRelativeTo(null);
            MA.setVisible(true);
        }
        
        JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil di "+ModeExec+".",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
    };
    

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
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtidpinjam = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtuserpinjam = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtsortid = new javax.swing.JTextField();
        txtstatusbuku = new javax.swing.JLabel();
        txttglpinjam = new javax.swing.JLabel();
        txttglkembali = new javax.swing.JLabel();
        txtjudulbuku = new javax.swing.JLabel();
        panelBtn1 = new javax.swing.JPanel();
        btnExec = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("DATA PINJAM");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/book (1).png"))); // NOI18N

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel11)
                .addGap(133, 133, 133))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        panelIsi1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel14.setText("Judul Buku");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel12.setText(" :");

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel17.setText("Status Buku");

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel19.setText(" :");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel15.setText("Id Pinjam");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel16.setText(" :");

        txtidpinjam.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtidpinjam.setText("-");

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel18.setText("Id User Peminjam");

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel23.setText(" :");

        txtuserpinjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuserpinjamKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel20.setText("Tanggal Peminjaman");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel30.setText(" :");

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel28.setText("Tanggal Pengembalian");

        jLabel34.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel34.setText(" :");

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel21.setText("Sort Id   (Buku yang dipinjam)");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel13.setText(" :");

        txtsortid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsortidKeyPressed(evt);
            }
        });

        txtstatusbuku.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtstatusbuku.setText("-");

        txttglpinjam.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txttglpinjam.setText("-");

        txttglkembali.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txttglkembali.setText("-");

        txtjudulbuku.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtjudulbuku.setText("-");

        javax.swing.GroupLayout panelIsi1Layout = new javax.swing.GroupLayout(panelIsi1);
        panelIsi1.setLayout(panelIsi1Layout);
        panelIsi1Layout.setHorizontalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel28))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel34))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtidpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtjudulbuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtsortid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtstatusbuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttglpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttglkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtuserpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtidpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsortid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtjudulbuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtstatusbuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttglpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttglkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuserpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnExec.setBackground(new java.awt.Color(255, 255, 255));
        btnExec.setText("PINJAM");
        btnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecActionPerformed(evt);
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
                .addGap(55, 55, 55)
                .addComponent(btnExec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(btnCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        panelBtn1Layout.setVerticalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExec, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(548, 548, 548))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(panelIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 684, 683);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        // TODO add your handling code here:
        int idbuku,userpinjam;
        try{
            idbuku = Integer.parseInt(txtsortid.getText());
            userpinjam = Integer.parseInt(txtuserpinjam.getText());
            submitDataFunc();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(
                        null,
                        "Data Harus Berupa Angka",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        };
    }//GEN-LAST:event_btnExecActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        //-------------
        this.dispose();
        FaAdmin MA = new FaAdmin();
        MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
        MA.getDataPinjam();
        MA.dataIn(DataLogin);
        MA.setColor(arrColor);
        //MA.getTable();
        MA.setLocationRelativeTo(null);
        MA.setVisible(true);
    }//GEN-LAST:event_btnCancleActionPerformed

    private void txtsortidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsortidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtuserpinjam.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtsortidKeyPressed

    private void txtuserpinjamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserpinjamKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            submitDataFunc();
        }
    }//GEN-LAST:event_txtuserpinjamKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GcMenuDataPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GcMenuDataPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GcMenuDataPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GcMenuDataPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                GcMenuDataPinjam fRegis = new GcMenuDataPinjam();
                //fRegis.setLocationRelativeTo(null);  //ditaruh saat class dipanggil
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnExec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JLabel txtidpinjam;
    private javax.swing.JLabel txtjudulbuku;
    private javax.swing.JTextField txtsortid;
    private javax.swing.JLabel txtstatusbuku;
    private javax.swing.JLabel txttglkembali;
    private javax.swing.JLabel txttglpinjam;
    private javax.swing.JTextField txtuserpinjam;
    // End of variables declaration//GEN-END:variables
}
