/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import java.awt.Toolkit;
import java.awt.Dimension;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import programasps.backend.koneksiData;

/**
 *
 * @author dnrahmath
 */
public class AaLoginRegisterPanel extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //background color
    Color colorBackground = new Color(255, 255, 204, 255);
    Color colorBackgroundForm = new Color(255, 210, 185, 255);
        
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now(); 
    
        
    String CBperanRole[] = {"SISWA","GURU"};
    String CBJK[] = {"LAKI-LAKI","PEREMPUAN"}; 
    
    Color SelectColor = new Color(153,255,204);
    Color unSelectColor = new Color(255,255,255);
    
    
    String[][] DataLogin;
    
    public AaLoginRegisterPanel(int mode,Color colorBackgroundIn, Color colorBackgroundFormIn) {
        initComponents();
        this.setExtendedState(AaLoginRegisterPanel.MAXIMIZED_BOTH);
        
        colorBackground = colorBackgroundIn;
        colorBackgroundForm = colorBackgroundFormIn;
        
        panelJudul.setBackground(colorBackgroundForm);
        panelIsi.setBackground(colorBackgroundForm);
        panelBtn.setBackground(colorBackgroundForm);
        
        panelJudul2.setBackground(colorBackgroundForm);
        panelIsi2.setBackground(colorBackgroundForm);
        panelBtn2.setBackground(colorBackgroundForm);
        
        ShowPasswordLogin.setBackground(colorBackgroundForm);
        ShowPasswordRegister.setBackground(colorBackgroundForm);
        
        JCBJKelamin.setBackground(new Color(255, 255, 255, 255));
        JCBPeran.setBackground(new Color(255, 255, 255, 255));
                
        //[panelBelakang]
        panelLogin.setBackground(colorBackground);
        
        
        for (int i = 0; i < CBperanRole.length; i++) {
            JCBPeran.addItem(CBperanRole[i]);
        }
        
        for (int i = 0; i < CBJK.length; i++) {
            JCBJKelamin.addItem(CBJK[i]);
        }
        
        //focus
        if (mode == 1) {
            //Login
            loginPanelFunc();
        }else if (mode == 2) {
            //register
            registerPanelFunc();
        }else{}
        
        //ubah warna ketika diselect
        btnLoginForm.setBackground(SelectColor);
        btnRegisterForm.setBackground(unSelectColor);
        
    }
    
    void loginPanelFunc(){
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //addpanel
        mainPanel.add(panelLogin);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //ubah warna ketika diselect
        btnLoginForm.setBackground(SelectColor);
        btnRegisterForm.setBackground(unSelectColor);
    };
    
    void registerPanelFunc(){
        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //addpanel
        mainPanel.add(panelRegister);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //ubah warna ketika diselect
        btnLoginForm.setBackground(unSelectColor);
        btnRegisterForm.setBackground(SelectColor);
    };
    
    void loginFunc(){
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
            null,
            null,
            txtmaillogin.getText(),
            txtpasslogin.getText(),
            null,
            null,
            null,
            null,
            null,
            null,
            null
        };
        
        
        if(!"".equals(listColmnRow[2]) && !"".equals(listColmnRow[5])){
            koneksiData connLogin = new koneksiData();
            DataLogin = connLogin.cSelectOneLogin("tbl_users",listColmn,100,listColmn[2],listColmnRow[2],listColmnRow[3]);
        
            if("err".equals(DataLogin[0][0]) ){  //String "err" tidak equals dengan jawaban DataLogin[0][0] = LOGIN 
                JOptionPane.showMessageDialog(
                        null,
                        "Username atau Password Salah",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                
                System.out.println("Gagal Login");
                System.out.println("data : "+DataLogin[0][0]);
                
            }else{
                JOptionPane.showMessageDialog(
                        null,
                        "Login Berhasil",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("test"+DataLogin[0][0]);
                DataLogin[0][6] = dtf.format(now);
                //---------------------------------------------------------------------
                
                CbMenuUtama mUtm = new CbMenuUtama(colorBackground,colorBackgroundForm);
                //-------------------------------------------------
                //Toolkit tk=Toolkit.getDefaultToolkit(); 
                //Dimension screenSize = tk.getScreenSize(); 
                //mUtm.setSize(960,screenSize.height);
                mUtm.setExtendedState(mUtm.MAXIMIZED_BOTH);
                //-------------------------------------------------
                mUtm.setDefaultCloseOperation(mUtm.DISPOSE_ON_CLOSE);
                mUtm.dataIn(DataLogin);
                mUtm.setValue();
                mUtm.setLocationRelativeTo(null);
           
                mUtm.setVisible(true);
                
                //menghilangkan layar login/register
                this.dispose();
            }
        }else{
            System.out.println("Tidak Boleh Kosong");
            JOptionPane.showMessageDialog(
                        null,
                        "Tidak Boleh Kosong",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        txtmaillogin.requestFocusInWindow();
        txtmaillogin.setText("");
        txtpasslogin.setText("");
    }
    
    void registerFunc(){
        int optionPeranIndex = JCBPeran.getSelectedIndex();
        String optionPeran = CBperanRole[optionPeranIndex];

        int optionJKIndex = JCBJKelamin.getSelectedIndex();
        String optionJK = CBJK[optionJKIndex];

        String listColmn[]= {
            "id",
            "nama",
            "email",
            "noid",
            "peran",
            "password",
            "terakhir_login",
            "jenis_kelamin",
            "no_tlp",
            "agama",
            "alamat"
        };

        String listColmnRow[]= {
            "0",
            txtnm.getText(),
            txtmail.getText(),
            txtnoid.getText(),
            optionPeran,
            txtpass.getText(),
            dtf.format(now),
            optionJK,
            "",
            "",
            ""
        };

        if(!"".equals(listColmnRow[1]) && !"".equals(listColmnRow[2]) && !"".equals(listColmnRow[3]) && !"".equals(listColmnRow[5])){
            koneksiData connInsert = new koneksiData();
            DataLogin = connInsert.cInsert("tbl_users",listColmn,listColmnRow);

            //--------------------------------------

            //if(!"".equals(listColmnRow[2]) && !"".equals(listColmnRow[6])){
                koneksiData connLogin = new koneksiData();
                DataLogin = connLogin.cSelectOneLogin("tbl_users",listColmn,100,listColmn[2],listColmnRow[2],listColmnRow[5]);

                if("err".equals(DataLogin[0][0]) ){  //String "err" tidak equals dengan jawaban DataLogin[0][0] = LOGIN
                    JOptionPane.showMessageDialog(
                        null,
                        "Username atau Password Salah",
                        "Message", JOptionPane.INFORMATION_MESSAGE);

                    System.out.println("Gagal Login");
                    System.out.println("data : "+DataLogin[0][0]);

                }else{
                    JOptionPane.showMessageDialog(
                        null,
                        "Login Berhasil",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("test"+DataLogin[0][0]);

                    //---------------------------------------------------------------------

                    //this.setVisible(false);//menghilangkan form menu register

                    CbMenuUtama mUtm = new CbMenuUtama(colorBackground,colorBackgroundForm);
                    //-------------------------------------------------
                    //Toolkit tk=Toolkit.getDefaultToolkit();
                    //Dimension screenSize = tk.getScreenSize();
                    //mUtm.setSize(960,screenSize.height);
                    mUtm.setExtendedState(mUtm.MAXIMIZED_BOTH); //MAXIMIZED_BOTH | MAXIMIZED_VERT | MAXIMIZED_HORIZ
                    //-------------------------------------------------
                    mUtm.setDefaultCloseOperation(mUtm.DISPOSE_ON_CLOSE);
                    mUtm.dataIn(DataLogin);
                    mUtm.setValue();
                    mUtm.setLocationRelativeTo(null);

                    mUtm.setVisible(true);
                
                    //menghilangkan layar login/register
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "Silahkan isi data terlebih dahulu.",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
                txtnm.setText("");
                txtmail.setText("");
                txtnoid.setText("");
                txtpass.setText("");
            }
    }
    
    void exceptionSubmitRegister(){
        JOptionPane widgetQuestion = new JOptionPane();
        int jawab = widgetQuestion.showOptionDialog(this, 
                "Apakah Kamu yakin?", 
                "Submit", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        switch(jawab){
            case JOptionPane.YES_OPTION: 
                registerFunc();
                break;
            case JOptionPane.NO_OPTION:
                txtnm.setText("");
                txtmail.setText("");
                txtnoid.setText("");
                JCBJKelamin.setSelectedIndex(0);
                JCBPeran.setSelectedIndex(0);
                txtpass.setText("");
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

        bodyPanel = new javax.swing.JPanel();
        btnRegisterForm = new javax.swing.JButton();
        btnLoginForm = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        panelIsi = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtmaillogin = new javax.swing.JTextField();
        txtpasslogin = new javax.swing.JPasswordField();
        ShowPasswordLogin = new javax.swing.JCheckBox();
        panelBtn = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnLoginCancle = new javax.swing.JButton();
        panelJudul = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        panelJudul2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panelIsi2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLnoid = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        txtnoid = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        JCBPeran = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        JCBJKelamin = new javax.swing.JComboBox<>();
        ShowPasswordRegister = new javax.swing.JCheckBox();
        txtpass = new javax.swing.JPasswordField();
        panelBtn2 = new javax.swing.JPanel();
        btnRegis = new javax.swing.JButton();
        btnRegisCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(204, 204, 255));

        btnRegisterForm.setBackground(new java.awt.Color(255, 255, 255));
        btnRegisterForm.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        btnRegisterForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-32/add-user.png"))); // NOI18N
        btnRegisterForm.setText("REGISTER");
        btnRegisterForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegisterForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterFormActionPerformed(evt);
            }
        });

        btnLoginForm.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginForm.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        btnLoginForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-32/user-interface.png"))); // NOI18N
        btnLoginForm.setText("   LOGIN");
        btnLoginForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLoginForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginFormActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/logo-Kharismawita.png"))); // NOI18N

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoginForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegisterForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(89, 89, 89))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnLoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnRegisterForm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 204, 153));
        mainPanel.setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelIsi.setBackground(new java.awt.Color(153, 255, 153));
        panelIsi.setPreferredSize(new java.awt.Dimension(880, 190));

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel12.setText(" :");

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel14.setText("Password");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel15.setText("Email");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel16.setText(" :");

        txtmaillogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmailloginKeyPressed(evt);
            }
        });

        txtpasslogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassloginKeyPressed(evt);
            }
        });

        ShowPasswordLogin.setBackground(new java.awt.Color(255, 255, 255));
        ShowPasswordLogin.setText("Lihat Password");
        ShowPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel16))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ShowPasswordLogin)
                    .addComponent(txtmaillogin, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(txtpasslogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmaillogin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpasslogin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPasswordLogin)
                .addGap(16, 16, 16))
        );

        panelBtn.setBackground(new java.awt.Color(153, 255, 153));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/user-interface.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLoginCancle.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginCancle.setText("Cancle");
        btnLoginCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btnLoginCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoginCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelJudul.setBackground(new java.awt.Color(153, 255, 153));
        panelJudul.setPreferredSize(new java.awt.Dimension(880, 100));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel10.setText("FORM LOGIN");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(319, 319, 319))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudulLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(230, 230, 230))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        mainPanel.add(panelLogin, "card2");

        panelRegister.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul2.setBackground(new java.awt.Color(153, 255, 153));
        panelJudul2.setPreferredSize(new java.awt.Dimension(880, 100));

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel13.setText("FORM REGISTER");

        javax.swing.GroupLayout panelJudul2Layout = new javax.swing.GroupLayout(panelJudul2);
        panelJudul2.setLayout(panelJudul2Layout);
        panelJudul2Layout.setHorizontalGroup(
            panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(286, 286, 286))
        );
        panelJudul2Layout.setVerticalGroup(
            panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelIsi2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel24.setText("Nama");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setText(" :");

        txtnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmKeyPressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel26.setText("Email");

        jLnoid.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLnoid.setText("No.Kartu Pelajar");

        jLabel27.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel27.setText(" :");

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel28.setText(" :");

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

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel29.setText("Peran");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel30.setText("Password");

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel31.setText(" :");

        jLabel32.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel32.setText(" :");

        JCBPeran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBPeranActionPerformed(evt);
            }
        });
        JCBPeran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCBPeranKeyPressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel33.setText("Jenis kelamin");

        jLabel34.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel34.setText(" :");

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

        ShowPasswordRegister.setBackground(new java.awt.Color(255, 255, 255));
        ShowPasswordRegister.setText("Lihat Password");
        ShowPasswordRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordRegisterActionPerformed(evt);
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
                .addGap(42, 42, 42)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLnoid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(JCBPeran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(25, 25, 25)
                                .addComponent(txtmail))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(25, 25, 25)
                                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelIsi2Layout.createSequentialGroup()
                                        .addComponent(ShowPasswordRegister)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtpass)))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(25, 25, 25)
                                .addComponent(txtnoid))))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel34)
                        .addGap(25, 25, 25)
                        .addComponent(JCBJKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(142, 142, 142)
                        .addComponent(txtnm)))
                .addGap(76, 76, 76))
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLnoid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnoid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33)
                    .addComponent(JCBJKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCBPeran, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ShowPasswordRegister)
                .addGap(38, 38, 38))
        );

        panelBtn2.setBackground(new java.awt.Color(153, 255, 153));

        btnRegis.setBackground(new java.awt.Color(255, 255, 255));
        btnRegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/add-user.png"))); // NOI18N
        btnRegis.setText("REGISTER");
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });

        btnRegisCancle.setBackground(new java.awt.Color(255, 255, 255));
        btnRegisCancle.setText("CANCLE");
        btnRegisCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn2Layout = new javax.swing.GroupLayout(panelBtn2);
        panelBtn2.setLayout(panelBtn2Layout);
        panelBtn2Layout.setHorizontalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(btnRegisCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        panelBtn2Layout.setVerticalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRegisterLayout = new javax.swing.GroupLayout(panelRegister);
        panelRegister.setLayout(panelRegisterLayout);
        panelRegisterLayout.setHorizontalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJudul2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        panelRegisterLayout.setVerticalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(panelJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        panelJudul2.getAccessibleContext().setAccessibleName("");

        mainPanel.add(panelRegister, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 1427, 891);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterFormActionPerformed
        // TODO add your handling code here:
        registerPanelFunc();
    }//GEN-LAST:event_btnRegisterFormActionPerformed

    private void btnLoginFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginFormActionPerformed
        // TODO add your handling code here:
        loginPanelFunc();
    }//GEN-LAST:event_btnLoginFormActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        loginFunc();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void ShowPasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordLoginActionPerformed
        // TODO add your handling code here:
        if(ShowPasswordLogin.isSelected()){
            txtpasslogin.setEchoChar((char)0);
        }else{
            txtpasslogin.setEchoChar('*');
        };
        txtpasslogin.requestFocusInWindow();
    }//GEN-LAST:event_ShowPasswordLoginActionPerformed

    private void txtmailloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailloginKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpasslogin.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtmailloginKeyPressed

    private void txtpassloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassloginKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            loginFunc();
        }
    }//GEN-LAST:event_txtpassloginKeyPressed

    private void btnLoginCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginCancleActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnLoginCancleActionPerformed

    private void JCBPeranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBPeranActionPerformed
        // TODO add your handling code here:
    
        int optionPeranIndex = JCBPeran.getSelectedIndex();
        String optionPeran = CBperanRole[optionPeranIndex];

        if (optionPeran == "SISWA"){
            jLnoid.setText("No.Kartu Pelajar");
            panelJudul2.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn2.setBackground(colorBackgroundForm);
        }else{
            jLnoid.setText("No.KTP");
            panelJudul2.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn2.setBackground(colorBackgroundForm);
        }
    }//GEN-LAST:event_JCBPeranActionPerformed

    private void JCBJKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBJKelaminActionPerformed
        // TODO add your handling code here:
        
        int optionPeranIndex = JCBJKelamin.getSelectedIndex();
        String optionJK = CBJK[optionPeranIndex];

        if (optionJK == "LAKI-LAKI"){
            panelJudul2.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn2.setBackground(colorBackgroundForm);
        }else{
            panelJudul2.setBackground(colorBackgroundForm);
            panelIsi2.setBackground(colorBackgroundForm);
            panelBtn2.setBackground(colorBackgroundForm);
        }
    }//GEN-LAST:event_JCBJKelaminActionPerformed

    private void ShowPasswordRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordRegisterActionPerformed
        // TODO add your handling code here:
        if(ShowPasswordRegister.isSelected()){
            txtpass.setEchoChar((char)0);
        }else{
            txtpass.setEchoChar('*');
        };
    }//GEN-LAST:event_ShowPasswordRegisterActionPerformed

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        // TODO add your handling code here: 
        exceptionSubmitRegister();
    }//GEN-LAST:event_btnRegisActionPerformed

    private void btnRegisCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisCancleActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegisCancleActionPerformed

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
            JCBPeran.showPopup();
            JCBPeran.requestFocusInWindow();
        }
    }//GEN-LAST:event_JCBJKelaminKeyPressed

    private void JCBPeranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCBPeranKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpass.requestFocusInWindow();
        }
    }//GEN-LAST:event_JCBPeranKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            exceptionSubmitRegister();
        }
    }//GEN-LAST:event_txtpassKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],int mode,Color colorBackgroundIn, Color colorBackgroundFormIn) {
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
            java.util.logging.Logger.getLogger(AaLoginRegisterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AaLoginRegisterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AaLoginRegisterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AaLoginRegisterPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AaLoginRegisterPanel(mode,colorBackgroundIn,colorBackgroundFormIn).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBJKelamin;
    private javax.swing.JComboBox<String> JCBPeran;
    private javax.swing.JCheckBox ShowPasswordLogin;
    private javax.swing.JCheckBox ShowPasswordRegister;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginCancle;
    private javax.swing.JButton btnLoginForm;
    private javax.swing.JButton btnRegis;
    private javax.swing.JButton btnRegisCancle;
    private javax.swing.JButton btnRegisterForm;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLnoid;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelBtn2;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JPanel panelJudul2;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmaillogin;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnoid;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpasslogin;
    // End of variables declaration//GEN-END:variables


}
