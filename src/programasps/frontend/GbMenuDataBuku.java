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
public class GbMenuDataBuku extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();   
    
    String CBstatusBuku[] = {"TIDAK DIPINJAM","DIPINJAM"};
    
    String ModeData; //table_nama
    String ModeExec; //mode eksekusi
    
    String[][] DataLogin;
    String listColmn[];
    String listColmnRow[];
    
    
    Color SelectColor =  new Color(153,255,204);
    Color unSelectColor = new Color(255, 255, 255); 
    Color arrColor[] = {unSelectColor,SelectColor,unSelectColor,unSelectColor,unSelectColor,unSelectColor};
    
    public GbMenuDataBuku() {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        panelJudul1.setBackground(new Color(100, 0, 0, 0));
        panelIsi1.setBackground(new Color(100, 0, 0, 0));
        panelBtn1.setBackground(new Color(100, 0, 0, 0));
        
        JCBstatusbuku.addItem("TIDAK DIPINJAM");
        JCBstatusbuku.addItem("DIPINJAM");
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
            txtidbuku.setEditable(false);
            txtnmpetugasinput.setText(DataLogin[0][1]);
            txtnmpetugasinput.setEditable(false);
        }else{
            btnExec.setText("INSERT");
            JCBstatusbuku.setEnabled(false);
            txtnmpetugasinput.setText(DataLogin[0][1]);
            txtnmpetugasinput.setEditable(false);
        }
        
        if("UPDATE".equals(ModeExec)){
            //DISESUAIKAN SETIAP FORM
            txtidbuku.setText(listColmnRow[0]);
            txtjudulbuku.setText(listColmnRow[1]);
            txtpenulisbuku.setText(listColmnRow[2]);
            txtpenerbitoleh.setText(listColmnRow[3]);
            txttahunbuku.setText(listColmnRow[4]);
            txtbukukelas.setText(listColmnRow[5]);
            JCBstatusbuku.setSelectedItem(listColmnRow[6]);
            txtnmpetugasinput.setText(listColmnRow[7]);
            txtshortid.setText(listColmnRow[8]);
        }else{
            //.setText("");
        }
    }
    
    void submitDataFunc(){
        //DISESUAIKAN SETIAP FORM
        String listColmnRowBaru[]= {
            txtidbuku.getText(),
            txtjudulbuku.getText(),
            txtpenulisbuku.getText(),
            txtpenerbitoleh.getText(),
            txttahunbuku.getText(),
            txtbukukelas.getText(),
            CBstatusBuku[JCBstatusbuku.getSelectedIndex()],
            txtnmpetugasinput.getText(),
            txtshortid.getText(),
        };
        
        
        
        
        // ditambah opsi JIKA KOSONG -> tidak jadi
        if("INSERT".equals(ModeExec)){
            //listColmnRowBaru[0] = "0";  //pakai AUTO_INCREMENT
            listColmnRowBaru[6] = "TIDAK DIPINJAM";  //status_buku
            listColmnRowBaru[8] = "0";  //short_id  baru
            koneksiData conn = new koneksiData();
            conn.cInsert(ModeData,listColmn,listColmnRowBaru);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataBuku();
            MA.dataIn(DataLogin);
            MA.setColor(arrColor);
            //MA.getTable();
            MA.setLocationRelativeTo(null);
            MA.setVisible(true);
            
        }else{
            koneksiData conn = new koneksiData();
            conn.cUpdate(ModeData,listColmn,listColmnRowBaru,listColmn[8],listColmnRowBaru[8]);
            //-------------
            this.dispose();
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            MA.getDataBuku();
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
        txtjudulbuku = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtpenulisbuku = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtnmpetugasinput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtpenerbitoleh = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txttahunbuku = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtidbuku = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtshortid = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtbukukelas = new javax.swing.JTextField();
        JCBstatusbuku = new javax.swing.JComboBox<>();
        panelBtn1 = new javax.swing.JPanel();
        btnExec = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("DATA BUKU");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/buku (2).png"))); // NOI18N

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJudul1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelJudul1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );

        panelIsi1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel14.setText("Judul Buku");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel12.setText(" :");

        txtjudulbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtjudulbukuKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel17.setText("Penulis Buku");

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel19.setText(" :");

        txtpenulisbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpenulisbukuKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel18.setText("Nama petugas Input");

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel23.setText(" :");

        txtnmpetugasinput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmpetugasinputKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel20.setText("Penerbit Oleh");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel30.setText(" :");

        txtpenerbitoleh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpenerbitolehKeyPressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel28.setText("Tahun Buku");

        jLabel34.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel34.setText(" :");

        txttahunbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttahunbukuKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel21.setText("Id Buku");

        jLabel22.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel22.setText(" :");

        txtidbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidbukuKeyPressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel24.setText("Short ID");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setText(" :");

        txtshortid.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        txtshortid.setText("-");

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel26.setText("Status Buku");

        jLabel27.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel27.setText(" :");

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel29.setText("Buku Kelas");

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel31.setText(" :");

        txtbukukelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbukukelasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelIsi1Layout = new javax.swing.GroupLayout(panelIsi1);
        panelIsi1.setLayout(panelIsi1Layout);
        panelIsi1Layout.setHorizontalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbukukelas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttahunbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(txtpenerbitoleh)))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtpenulisbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(12, 12, 12)
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCBstatusbuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnmpetugasinput)))))
                    .addGroup(panelIsi1Layout.createSequentialGroup()
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(74, 74, 74))
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55)))
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtjudulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(txtidbuku))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                        .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(txtshortid))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelIsi1Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtjudulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpenulisbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpenerbitoleh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(txttahunbuku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtbukukelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JCBstatusbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnmpetugasinput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtshortid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
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
                .addGap(533, 533, 533))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 645, 767);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        // TODO add your handling code here:
        submitDataFunc();
    }//GEN-LAST:event_btnExecActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        //-------------
        this.dispose();
        FaAdmin MA = new FaAdmin();
        MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
        MA.getDataBuku();
        MA.dataIn(DataLogin);
        MA.setColor(arrColor);
        //MA.getTable();
        MA.setLocationRelativeTo(null);
        MA.setVisible(true);
    }//GEN-LAST:event_btnCancleActionPerformed

    private void txtjudulbukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjudulbukuKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpenulisbuku.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtjudulbukuKeyPressed

    private void txtpenulisbukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpenulisbukuKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtpenerbitoleh.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtpenulisbukuKeyPressed

    private void txtpenerbitolehKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpenerbitolehKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txttahunbuku.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtpenerbitolehKeyPressed

    private void txttahunbukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunbukuKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtbukukelas.requestFocusInWindow();
        }
    }//GEN-LAST:event_txttahunbukuKeyPressed

    private void txtnmpetugasinputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmpetugasinputKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            submitDataFunc();
        }
    }//GEN-LAST:event_txtnmpetugasinputKeyPressed

    private void txtidbukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidbukuKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            txtjudulbuku.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtidbukuKeyPressed

    private void txtbukukelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbukukelasKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER){
            JCBstatusbuku.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtbukukelasKeyPressed

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
            java.util.logging.Logger.getLogger(GbMenuDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GbMenuDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GbMenuDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GbMenuDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                GbMenuDataBuku fRegis = new GbMenuDataBuku();
                //fRegis.setLocationRelativeTo(null);  //ditaruh saat class dipanggil
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBstatusbuku;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnExec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtbukukelas;
    private javax.swing.JTextField txtidbuku;
    private javax.swing.JTextField txtjudulbuku;
    private javax.swing.JTextField txtnmpetugasinput;
    private javax.swing.JTextField txtpenerbitoleh;
    private javax.swing.JTextField txtpenulisbuku;
    private javax.swing.JLabel txtshortid;
    private javax.swing.JTextField txttahunbuku;
    // End of variables declaration//GEN-END:variables
}
