/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import programasps.backend.koneksiData;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;;
import javax.swing.JOptionPane;

/**
 *
 * @author dnrahmath
 */
public class GaMenuDataUser extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();   
    
    String CBperanRole[] = {"SISWA","GURU","ADMIN"};
    String CBJK[] = {"LAKI-LAKI","PEREMPUAN"};
    
    String ModeData; //table_nama
    String ModeExec; //mode eksekusi
    
    String[][] DataLogin;
    String listColmn[];
    String listColmnRow[];
    
    
    Color SelectColor =  new Color(153,255,204);
    Color unSelectColor = new Color(255, 255, 255); 
    Color arrColor[] = {SelectColor,unSelectColor,unSelectColor,unSelectColor,unSelectColor,unSelectColor};
    
    public GaMenuDataUser() {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        panelJudul1.setBackground(new Color(100, 0, 0, 0));
        panelIsi1.setBackground(new Color(100, 0, 0, 0));
        panelIsi2.setBackground(new Color(100, 0, 0, 0));
        panelBtn1.setBackground(new Color(100, 0, 0, 0));
        
        JCBJKelamin.setBackground(new Color(255, 255, 255, 255));
        JCBPeran.setBackground(new Color(255, 255, 255, 255));
        
        
        for (int i = 0; i < CBJK.length; i++) {
            JCBJKelamin.addItem(CBJK[i]);
        }
        for (int i = 0; i < CBperanRole.length; i++) {
            JCBPeran.addItem(CBperanRole[i]);
        }
        
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
            txtid.setText(listColmnRow[0]);
            txtnm.setText(listColmnRow[1]);
            txtmail.setText(listColmnRow[2]);
            txtpass.setText(listColmnRow[3]);
            txtnoid.setText(listColmnRow[4]);
            JCBPeran.setSelectedItem(DataLogin[0][5]);
            txtterakhirlogin.setText(listColmnRow[6]);
            JCBJKelamin.setSelectedItem(listColmnRow[7]);
            txtnotlp.setText(listColmnRow[8]);
            txtagm.setText(listColmnRow[9]);
            txtalmt.setText(listColmnRow[10]);
        }else{
            //.setText("");
        }
    }
    
    void submitDataFunc(){
        int optionPeranIndex = JCBPeran.getSelectedIndex();
        String optionPeran = CBperanRole[optionPeranIndex];
        
        int optionJKIndex = JCBJKelamin.getSelectedIndex();
        String optionJK = CBJK[optionJKIndex];
        
        //DISESUAIKAN SETIAP FORM
        String listColmnRowBaru[]= { 
            txtid.getText(),
            txtnm.getText(),
            txtmail.getText(),
            txtpass.getText(),
            txtnoid.getText(),
            optionPeran,  //peran dari login
            dtf.format(now),
            optionJK,
            txtnotlp.getText(),
            txtagm.getText(),
            txtalmt.getText(),
            txtid.getText()
        };
        
        
        // ditambah opsi JIKA KOSONG -> tidak jadi
        if("INSERT".equals(ModeExec)){
            listColmnRowBaru[0] = "0";  //pakai AUTO_INCREMENT
            koneksiData conn = new koneksiData();
            conn.cInsert(ModeData,listColmn,listColmnRowBaru);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataUser();
            MA.dataIn(DataLogin);
            MA.setColor(arrColor);
            //MA.getTable();
            MA.setLocationRelativeTo(null);
            MA.setVisible(true);
            
        }else{
            koneksiData conn = new koneksiData();
            conn.cUpdate(ModeData,listColmn,listColmnRowBaru,listColmn[0],listColmnRowBaru[0]);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataUser();
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
                submitDataFunc();
                break;
            case JOptionPane.NO_OPTION:
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
        jLabel1 = new javax.swing.JLabel();
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
        btnExec = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        panelIsi2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtterakhirlogin = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalmt = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtagm = new javax.swing.JTextField();
        JCBPeran = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("DATA USER");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/user (1).png"))); // NOI18N

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
        txtid.setText("-");

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
                .addGap(12, 12, 12)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLnoid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtnoid, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel16))
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnm)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addComponent(JCBJKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnoid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnoid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(JCBJKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnotlp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnExec.setBackground(new java.awt.Color(255, 255, 255));
        btnExec.setText("SUBMIT");
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

        panelIsi2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel22.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel22.setText("Terakhir Login");

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel33.setText(" :");

        txtterakhirlogin.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtterakhirlogin.setText("-");

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel29.setText("Password");

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel31.setText(" :");

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout panelIsi2Layout = new javax.swing.GroupLayout(panelIsi2);
        panelIsi2.setLayout(panelIsi2Layout);
        panelIsi2Layout.setHorizontalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel29)
                                .addGap(57, 57, 57)))
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelIsi2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(JCBPeran, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelIsi2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33)
                        .addGap(21, 21, 21)
                        .addComponent(txtterakhirlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi2Layout.createSequentialGroup()
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26))
                        .addGap(81, 81, 81)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtagm))))
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
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JCBPeran, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtterakhirlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1151, 684);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        // TODO add your handling code here:
        exceptionSubmit();
    }//GEN-LAST:event_btnExecActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        //-------------
        //-------------
        this.dispose();
        FaAdmin MA = new FaAdmin();
        MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
        MA.getDataUser();
        MA.dataIn(DataLogin);
        MA.setColor(arrColor);
        //MA.getTable();
        MA.setLocationRelativeTo(null);
        MA.setVisible(true);
    }//GEN-LAST:event_btnCancleActionPerformed

    private void JCBPeranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBPeranActionPerformed
        // TODO add your handling code here:
        int optionPeranIndex = JCBPeran.getSelectedIndex();
        String optionPeran = CBperanRole[optionPeranIndex];

        if(optionPeran == "SISWA"){
            jLnoid.setText("No.Kartu Pelajar");
        }else{
            jLnoid.setText("No.KTP");
        }
    }//GEN-LAST:event_JCBPeranActionPerformed

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
            JCBPeran.showPopup();
            JCBPeran.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtalmtKeyPressed

    private void JCBPeranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCBPeranKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpass.requestFocusInWindow();
        }
    }//GEN-LAST:event_JCBPeranKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            exceptionSubmit();
        }
    }//GEN-LAST:event_txtpassKeyPressed

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
            java.util.logging.Logger.getLogger(GaMenuDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GaMenuDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GaMenuDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GaMenuDataUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                GaMenuDataUser fRegis = new GaMenuDataUser();
                //fRegis.setLocationRelativeTo(null);  //ditaruh saat class dipanggil
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBJKelamin;
    private javax.swing.JComboBox<String> JCBPeran;
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
    private javax.swing.JTextField txtpass;
    private javax.swing.JLabel txtterakhirlogin;
    // End of variables declaration//GEN-END:variables

    void setColor(Color[] arrColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
