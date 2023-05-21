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
public class DaMenuProfile extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //colors background
    Color colorBackground;
    Color colorBackgroundForm;
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    
    String CBJK[] = {"LAKI-LAKI","PEREMPUAN"};
    
    String[][] DataLogin;
    
    public DaMenuProfile(Color colorRGBA,Color colorRGBAForm) {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        colorBackground = colorRGBA;
        colorBackgroundForm = colorRGBAForm;
        
        panelJudul1.setBackground(colorBackgroundForm);
        panelIsi1.setBackground(colorBackgroundForm);
        panelIsi2.setBackground(colorBackgroundForm);
        panelBtn1.setBackground(colorBackgroundForm);
        ShowPassword.setBackground(colorBackgroundForm);
        //[panelBelakang]
        panelLogin.setBackground(colorBackground);
    
        JCBJKelamin.setBackground(new Color(255, 255, 255, 255));
        
        for (int i = 0; i < CBJK.length; i++) {
            JCBJKelamin.addItem(CBJK[i]);
        }
        
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
    }
    
    public void setValue(){
        txtid.setText(DataLogin[0][0]);
        txtnm.setText(DataLogin[0][1]);
        txtmail.setText(DataLogin[0][2]);
        txtpass.setText(DataLogin[0][3]);
        txtnoid.setText(DataLogin[0][4]);
        txtperan.setText(DataLogin[0][5]);
        txtterakhirlogin.setText(DataLogin[0][6]);
        JCBJKelamin.setSelectedItem(DataLogin[0][7]);
        txtnotlp.setText(DataLogin[0][8]);
        txtagm.setText(DataLogin[0][9]);
        txtalmt.setText(DataLogin[0][10]);
    }
    
    void editFunc(){
        int optionJKIndex = JCBJKelamin.getSelectedIndex();
        String optionJK = CBJK[optionJKIndex];
        
        String listColmn[]= { 
            "id",
            "nama",
            "email",
            "password",
            "noid",
            "peran",
            "terakhir_login",
            "jenis_kelamin",
            "no_tlp",
            "agama",
            "alamat"
        };

        String listColmnRow[]= { 
            txtid.getText(),
            txtnm.getText(),
            txtmail.getText(),
            txtpass.getText(),
            txtnoid.getText(),
            DataLogin[0][5],  //peran dari login
            dtf.format(now),
            optionJK,
            txtnotlp.getText(),
            txtagm.getText(),
            txtalmt.getText()
        };
        
        
        
        
        if(!"".equals(listColmnRow[1]) && !"".equals(listColmnRow[2]) && !"".equals(listColmnRow[3]) && !"".equals(listColmnRow[4]) ){
            koneksiData conn = new koneksiData();
            conn.cUpdate("tbl_users",listColmn,listColmnRow,listColmn[0],listColmnRow[0]);
        
            DataLogin = conn.cSelectOne("tbl_users",listColmn,100,listColmn[0],listColmnRow[0]);
            
            this.dispose();
                
            CbMenuUtama mUtm = new CbMenuUtama(colorBackground,colorBackgroundForm);
            mUtm.setDefaultCloseOperation(mUtm.DISPOSE_ON_CLOSE);
            mUtm.dataIn(DataLogin);
            mUtm.setValue();
            mUtm.setLocationRelativeTo(null);
            mUtm.setVisible(true);
            
            JOptionPane.showMessageDialog(
                        null,
                        "Data berhasil di Edit.",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
            
        
        //--------------------------------------
        
        }else{
                JOptionPane.showMessageDialog(
                        null,
                        "Silahkan isi data terlebih dahulu.",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                
                txtid.setText(DataLogin[0][1]);
                txtnm.setText(DataLogin[0][1]);
                txtmail.setText(DataLogin[0][2]);
                txtpass.setText(DataLogin[0][3]);
                txtnoid.setText(DataLogin[0][4]);
                txtperan.setText(DataLogin[0][5]);
                txtterakhirlogin.setText(DataLogin[0][6]);
                JCBJKelamin.setSelectedItem(DataLogin[0][7]);
                txtnotlp.setText(DataLogin[0][8]);
                txtagm.setText(DataLogin[0][9]);
                txtalmt.setText(DataLogin[0][10]); 
        }
    }
    
    void exceptionSubmit(){
        JOptionPane widgetQuestion = new JOptionPane();
        int jawab = widgetQuestion.showOptionDialog(this, 
                "Apakah Kamu yakin?", 
                "Submit", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        switch(jawab){
            case JOptionPane.YES_OPTION: 
                editFunc();
                break;
            case JOptionPane.NO_OPTION:
                txtnm.requestFocusInWindow();
                break;
        }
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
        panelIsi1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLnoid = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        txtnoid = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        JCBJKelamin = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtnotlp = new javax.swing.JTextField();
        panelBtn1 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        panelIsi2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtterakhirlogin = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtperan = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalmt = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtagm = new javax.swing.JTextField();
        ShowPassword = new javax.swing.JCheckBox();
        txtpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/user (1).png"))); // NOI18N
        jLabel11.setText("PROFILE");

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(542, 542, 542)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        panelIsi1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel14.setText("Nama");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel12.setText(" :");

        txtnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel17.setText("Email");

        jLnoid.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLnoid.setText("No.Kartu Pelajar");

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel19.setText(" :");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel13.setText(" :");

        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmailKeyPressed(evt);
            }
        });

        txtnoid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnoidKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel21.setText("Jenis kelamin");

        jLabel32.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel32.setText(" :");

        JCBJKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBJKelaminActionPerformed(evt);
            }
        });
        JCBJKelamin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCBJKelaminKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel15.setText("Id");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel16.setText(" :");

        txtid.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtid.setText("txtid");

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel18.setText("No.Tlp");

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel23.setText(" :");

        txtnotlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnotlpKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelIsi1Layout = new javax.swing.GroupLayout(panelIsi1);
        panelIsi1.setLayout(panelIsi1Layout);
        panelIsi1Layout.setHorizontalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel16))
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel14))
                                .addGap(84, 84, 84)
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel19))))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnm)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmail)))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtnotlp))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(JCBJKelamin, 0, 422, Short.MAX_VALUE))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLnoid)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtnoid)))
                .addGap(30, 30, 30))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnoid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnoid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(JCBJKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnotlp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/export.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancle.setBackground(new java.awt.Color(255, 255, 255));
        btnCancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/enter.png"))); // NOI18N
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
                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(btnCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        panelBtn1Layout.setVerticalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelIsi2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel22.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel22.setText("Terakhir Login");

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel33.setText(" :");

        txtterakhirlogin.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtterakhirlogin.setText("txtterakhirlogin");

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel29.setText("Password");

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel31.setText(" :");

        txtperan.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtperan.setText("txtperan");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel30.setText(" :");

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel20.setText("Peran");

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel26.setText("Alamat");

        jLabel27.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel27.setText(" :");

        txtalmt.setColumns(20);
        txtalmt.setRows(5);
        txtalmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtalmtKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtalmt);

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel24.setText("Agama");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setText(" :");

        txtagm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtagmKeyPressed(evt);
            }
        });

        ShowPassword.setText("Lihat Password");
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel24)
                        .addComponent(jLabel26))
                    .addComponent(jLabel20)
                    .addComponent(jLabel29)
                    .addComponent(jLabel22))
                .addGap(35, 35, 35)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                            .addComponent(txtagm)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel33))
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtterakhirlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtperan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addComponent(ShowPassword)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtpass)))))
                .addGap(33, 33, 33))
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtagm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel26))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtperan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPassword)
                .addGap(33, 33, 33)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtterakhirlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(panelIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
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

        setBounds(0, 0, 1475, 731);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        exceptionSubmit();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        this.dispose();
            
        CbMenuUtama mUtm = new CbMenuUtama(colorBackground,colorBackgroundForm);
        mUtm.setDefaultCloseOperation(mUtm.DISPOSE_ON_CLOSE);
        mUtm.dataIn(DataLogin);
        mUtm.setValue();
        mUtm.setLocationRelativeTo(null);
        mUtm.setVisible(true);
        
    }//GEN-LAST:event_btnCancleActionPerformed

    private void JCBJKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBJKelaminActionPerformed
        // TODO add your handling code here:
        int optionPeranIndex = JCBJKelamin.getSelectedIndex();
        String optionJK = CBJK[optionPeranIndex];

        if (optionJK == "LAKI-LAKI"){
            panelJudul1.setBackground(colorBackgroundForm);
            panelIsi1.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn1.setBackground(colorBackgroundForm);
        }else{
            panelJudul1.setBackground(colorBackgroundForm);
            panelIsi1.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn1.setBackground(colorBackgroundForm);
        }
    }//GEN-LAST:event_JCBJKelaminActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        // TODO add your handling code here:
        if(ShowPassword.isSelected()){
            txtpass.setEchoChar((char)0);
        }else{
            txtpass.setEchoChar('*');
        };
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void txtnmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtmail.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtnmKeyPressed

    private void txtmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtnoid.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtmailKeyPressed

    private void txtnoidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            JCBJKelamin.showPopup();
            JCBJKelamin.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtnoidKeyPressed

    private void JCBJKelaminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCBJKelaminKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtnotlp.requestFocusInWindow();
        }
    }//GEN-LAST:event_JCBJKelaminKeyPressed

    private void txtnotlpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnotlpKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtagm.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtnotlpKeyPressed

    private void txtagmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtagmKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtalmt.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtagmKeyPressed

    private void txtalmtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalmtKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpass.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtalmtKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            exceptionSubmit();
        }
    }//GEN-LAST:event_txtpassKeyPressed

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
            java.util.logging.Logger.getLogger(DaMenuProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaMenuProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaMenuProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaMenuProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                DaMenuProfile fRegis = new DaMenuProfile(colorRGBA,colorRGBAForm);
                //fRegis.setLocationRelativeTo(null);  //ditaruh saat class dipanggil
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBJKelamin;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnEdit;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLnoid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtagm;
    private javax.swing.JTextArea txtalmt;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnoid;
    private javax.swing.JTextField txtnotlp;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JLabel txtperan;
    private javax.swing.JLabel txtterakhirlogin;
    // End of variables declaration//GEN-END:variables
}
