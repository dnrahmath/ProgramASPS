/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;






//import com.sun.istack.internal.logging.Logger;
import java.awt.Color;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import programasps.backend.koneksiData;
import static programasps.frontend.DcMenuKembalikanBuku.hitungDendaString;
//import sun.util.logging.PlatformLogger;
import java.time.LocalDate;
import javax.swing.JTable;

/**
 *
 * @author dnrahmath
 */
public class FaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    
    //background color
    Color colorBackground = new Color(255, 255, 204, 255);
    Color colorBackgroundForm = new Color(255, 210, 185, 255); //jika mau liat batas panelnya
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    
    String[][] DataTable;
    String[][] DataLogin;
    
    String ModeData;
    String ModeExec;
    String listColmn[];
    String CustomListColmn[];
    String listColmnRow[];
    
    Color defaultColor[];
    Color SelectColor =  new Color(153,255,204);
    Color unSelectColor = new Color(255, 255, 255); 
    
    
    public FaAdmin() {
        initComponents();
        this.setExtendedState(FaAdmin.MAXIMIZED_BOTH);
        
        jPanel1.setBackground(colorBackground);
        panelJudul.setBackground(colorBackgroundForm);
        JLTable.setBackground(colorBackgroundForm);
        panelSearch.setBackground(colorBackgroundForm);
        panelBtn.setBackground(colorBackgroundForm);
        panelBtn2.setBackground(colorBackgroundForm);
        panelBtn2.setVisible(false);
        
        JComboBox1.setBackground(new Color(255, 255, 255, 255)); 
        
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
    }
    
    public void setColor(Color[] colorsIn){
        defaultColor = colorsIn;
        
        btnDataUser.setBackground(defaultColor[0]);
        btnDataBuku.setBackground(defaultColor[1]);
        btnDataPinjam.setBackground(defaultColor[2]);
        btnDataKotakSaran.setBackground(defaultColor[3]);
        btnDataTamu.setBackground(defaultColor[4]);
        btnExit.setBackground(defaultColor[5]);
    }
    
    public void setTableColumn(){
        if("tbl_users".equals(ModeData)){
            listColmn = new String[11];
            listColmn[0] = "id";
            listColmn[1] = "nama";
            listColmn[2] = "email";
            listColmn[3] = "password";
            listColmn[4] = "noid";
            listColmn[5] = "peran";
            listColmn[6] = "terakhir_login";
            listColmn[7] = "jenis_kelamin";
            listColmn[8] = "no_tlp";
            listColmn[9] = "agama";
            listColmn[10] = "alamat";
        }else if("tbl_buku".equals(ModeData)){ 
            listColmn = new String[9];
            listColmn[0] = "id_buku";
            listColmn[1] = "judul_buku";
            listColmn[2] = "penulis_buku";
            listColmn[3] = "penerbit_oleh";
            listColmn[4] = "tahun_buku";
            listColmn[5] = "buku_kelas";
            listColmn[6] = "status_buku";
            listColmn[7] = "nama_petugas_input";
            listColmn[8] = "system_id";
        }else if("tbl_pinjam".equals(ModeData)){ 
            listColmn = new String[9];
            listColmn[0] = "id_pinjam";
            listColmn[1] = "id_buku";
            listColmn[2] = "judul_buku";
            listColmn[3] = "status_buku";
            listColmn[4] = "tgl_peminjaman";
            listColmn[5] = "tgl_pengembalian";
            listColmn[6] = "id_user_peminjam"; 
            listColmn[7] = "denda";
            listColmn[8] = "waktu_pinjam";
        }else if("tbl_kotakSaran".equals(ModeData)){
            listColmn = new String[4];
            listColmn[0] = "id";
            listColmn[1] = "nama";
            listColmn[2] = "saran";
            listColmn[3] = "tanggal";
            //
        }else if("tbl_tamu".equals(ModeData)){
            listColmn = new String[5];
            listColmn[0] = "id";
            listColmn[1] = "nama";
            listColmn[2] = "asal";
            listColmn[3] = "catatan";
            listColmn[4] = "tanggal";
        }else{
        }
    }
    
    public void UkuranTable(){
        if("tbl_users".equals(ModeData)){
            tblUtama.getColumnModel().getColumn(0).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(0).setMaxWidth(30);
            tblUtama.getColumnModel().getColumn(5).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(5).setMaxWidth(50);
        }else if("tbl_buku".equals(ModeData)){ 
            tblUtama.getColumnModel().getColumn(0).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(0).setMaxWidth(70);
            tblUtama.getColumnModel().getColumn(4).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(4).setMaxWidth(40);
            tblUtama.getColumnModel().getColumn(5).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(5).setMaxWidth(40);
            tblUtama.getColumnModel().getColumn(6).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(6).setMaxWidth(100);
            tblUtama.getColumnModel().getColumn(7).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(7).setMaxWidth(40);
            tblUtama.getColumnModel().getColumn(8).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(8).setMaxWidth(40);
        }else if("tbl_pinjam".equals(ModeData)){  
            tblUtama.getColumnModel().getColumn(0).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(0).setMaxWidth(70);
            tblUtama.getColumnModel().getColumn(1).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(1).setMaxWidth(60);
            tblUtama.getColumnModel().getColumn(3).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(3).setMaxWidth(100);
            tblUtama.getColumnModel().getColumn(4).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(4).setMaxWidth(140);
            tblUtama.getColumnModel().getColumn(5).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(5).setMaxWidth(140);
            tblUtama.getColumnModel().getColumn(6).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(6).setMaxWidth(40);
            tblUtama.getColumnModel().getColumn(7).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(7).setMaxWidth(60);
            tblUtama.getColumnModel().getColumn(8).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(8).setMaxWidth(60);
            tblUtama.getColumnModel().getColumn(9).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(9).setMaxWidth(60);
        }else if("tbl_kotakSaran".equals(ModeData)){
            tblUtama.getColumnModel().getColumn(0).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(0).setMaxWidth(30);
            tblUtama.getColumnModel().getColumn(3).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(3).setMaxWidth(140);
        }else if("tbl_tamu".equals(ModeData)){
            tblUtama.getColumnModel().getColumn(0).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(0).setMaxWidth(30);
            tblUtama.getColumnModel().getColumn(4).setMinWidth(10);
            tblUtama.getColumnModel().getColumn(4).setMaxWidth(140);
        }else{
            //
        }
    }
    
    public void redirectMenu(){
        if("tbl_users".equals(ModeData)){//nanti dibuat JFrame setiap DATA -> lalu TextField diganti di setValue()
            this.dispose();
            GaMenuDataUser mDataUser = new GaMenuDataUser();
            mDataUser.setDefaultCloseOperation(mDataUser.DISPOSE_ON_CLOSE);
            mDataUser.dataIn(DataLogin);
            mDataUser.dataTable(listColmn,listColmnRow,ModeData,ModeExec);  //targetColumn, isiColmnRow, namaTable, jenisEksekusi
            mDataUser.setValue();
            mDataUser.setLocationRelativeTo(null);
            mDataUser.setVisible(true);
        }else if("tbl_buku".equals(ModeData)){ 
            this.dispose();
            GbMenuDataBuku mDataBuku = new GbMenuDataBuku();
            mDataBuku.setDefaultCloseOperation(mDataBuku.DISPOSE_ON_CLOSE);
            mDataBuku.dataIn(DataLogin);
            mDataBuku.dataTable(listColmn,listColmnRow,ModeData,ModeExec);  //targetColumn, isiColmnRow, namaTable, jenisEksekusi
            mDataBuku.setValue();
            mDataBuku.setLocationRelativeTo(null);
            mDataBuku.setVisible(true);
        }else if("tbl_pinjam".equals(ModeData)){ 
            this.dispose();
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
        }else if("tbl_kotakSaran".equals(ModeData)){
            this.dispose();
            GdMenuDataKotakSaran mDataKotakSaran = new GdMenuDataKotakSaran();
            mDataKotakSaran.setDefaultCloseOperation(mDataKotakSaran.DISPOSE_ON_CLOSE);
            mDataKotakSaran.dataIn(DataLogin);
            mDataKotakSaran.dataTable(listColmn,listColmnRow,ModeData,ModeExec);  //targetColumn, isiColmnRow, namaTable, jenisEksekusi
            mDataKotakSaran.setValue();
            mDataKotakSaran.setLocationRelativeTo(null);
            mDataKotakSaran.setVisible(true);
        }else if("tbl_tamu".equals(ModeData)){
            this.dispose();
            GeMenuDataTamu mDataTamu = new GeMenuDataTamu();
            mDataTamu.setDefaultCloseOperation(mDataTamu.DISPOSE_ON_CLOSE);
            mDataTamu.dataIn(DataLogin);
            mDataTamu.dataTable(listColmn,listColmnRow,ModeData,ModeExec);  //targetColumn, isiColmnRow, namaTable, jenisEksekusi
            mDataTamu.setValue();
            mDataTamu.setLocationRelativeTo(null);
            mDataTamu.setVisible(true);
            //
        }else{
            //
        }
    }
    
    public void getDataUser(){
        btnInsert.setText("INSERT");
        btnUpdate.setText("UPDATE");
        btnUpdate.setVisible(true);
        //ComboBox Pilihan  -------
        CustomListColmn = new String[11];
        CustomListColmn[0] = "Id";
        CustomListColmn[1] = "Nama";
        CustomListColmn[2] = "Email";
        CustomListColmn[3] = "Password";
        CustomListColmn[4] = "NoId";
        CustomListColmn[5] = "Peran";
        CustomListColmn[6] = "Terakhir Login";
        CustomListColmn[7] = "Jenis Kelamin";
        CustomListColmn[8] = "No Tlp";
        CustomListColmn[9] = "Agama";
        CustomListColmn[10] = "Alamat";
           
        JComboBox1.removeAllItems();
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
            
        //Table get----------------
        listColmn = new String[11];
        listColmn[0] = "id";
        listColmn[1] = "nama";
        listColmn[2] = "email";
        listColmn[3] = "password";
        listColmn[4] = "noid";
        listColmn[5] = "peran";
        listColmn[6] = "terakhir_login";
        listColmn[7] = "jenis_kelamin";
        listColmn[8] = "no_tlp";
        listColmn[9] = "agama";
        listColmn[10] = "alamat";
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_users",listColmn);
        System.out.println(Arrays.toString(DataTable[0]));
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        
        //-------------------------
        
        ModeData = "tbl_users";
        UkuranTable();
        
        //-------------------------
    };
    
    public void getDataBuku(){
        btnInsert.setText("INSERT");
        btnUpdate.setText("UPDATE");
        btnUpdate.setVisible(true);
        //ComboBox Pilihan  -------
        CustomListColmn = new String[9];
        CustomListColmn[0] = "Id";
        CustomListColmn[1] = "Judul Buku";
        CustomListColmn[2] = "Penulis Buku";
        CustomListColmn[3] = "Penerbit Oleh";
        CustomListColmn[4] = "Tahun Buku";
        CustomListColmn[5] = "Kelas";
        CustomListColmn[6] = "Status Buku";
        CustomListColmn[7] = "Nama Petugas Input";
        CustomListColmn[8] = "System Id";
           
        JComboBox1.removeAllItems();
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
        
        //Table get----------------
        listColmn = new String[9];
        listColmn[0] = "id_buku";
        listColmn[1] = "judul_buku";
        listColmn[2] = "penulis_buku";
        listColmn[3] = "penerbit_oleh";
        listColmn[4] = "tahun_buku";
        listColmn[5] = "buku_kelas";
        listColmn[6] = "status_buku";
        listColmn[7] = "nama_petugas_input";
        listColmn[8] = "system_id";
        
        
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_buku",listColmn);
        System.out.println(Arrays.toString(DataTable[0]));
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        //-------------------------
        
        ModeData = "tbl_buku";
        UkuranTable();
        //-------------------------
        
    }
    
    public void getDataPinjam(){
        btnInsert.setText("OPERATOR PEMINJAMAN DAN PENGEMBALIAN BUKU");
        btnUpdate.setVisible(false);
        //ComboBox Pilihan  -------
        CustomListColmn = new String[10];
        CustomListColmn[0] = "Id Pinjam";
        CustomListColmn[1] = "Id Buku";
        CustomListColmn[2] = "Judul Buku";
        CustomListColmn[3] = "Status Buku";
        CustomListColmn[4] = "Tgl Peminjaman";
        CustomListColmn[5] = "Tgl Pengembalian";
        CustomListColmn[6] = "Usr";
        CustomListColmn[7] = "Denda";
        CustomListColmn[8] = "Waktu Pinjam (hari)";
        CustomListColmn[9] = "System Id";
           
        JComboBox1.removeAllItems();
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
            
        
        //Table get----------------
        listColmn = new String[10];
        listColmn[0] = "id_pinjam";
        listColmn[1] = "id_buku";
        listColmn[2] = "judul_buku";
        listColmn[3] = "status_buku";
        listColmn[4] = "tgl_peminjaman";
        listColmn[5] = "tgl_pengembalian";
        listColmn[6] = "id_user_peminjam";
        listColmn[7] = "denda";
        listColmn[8] = "waktu_pinjam";
        listColmn[9] = "system_id";
        
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_pinjam",listColmn);
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
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        //-------------------------
        
        ModeData = "tbl_pinjam";
        UkuranTable();
        //-------------------------
    }
    
    public void getDataKotakSaran(){
        btnInsert.setText("INSERT");
        btnUpdate.setText("UPDATE");
        btnUpdate.setVisible(true);
        //ComboBox Pilihan  -------
        CustomListColmn = new String[4];
        CustomListColmn[0] = "Id";
        CustomListColmn[1] = "Nama";
        CustomListColmn[2] = "Saran";
        CustomListColmn[3] = "Tanggal";
           
        JComboBox1.removeAllItems();
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
            
        
        //Table get----------------
        listColmn = new String[4];
        listColmn[0] = "id";
        listColmn[1] = "nama";
        listColmn[2] = "saran";
        listColmn[3] = "tanggal";
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_kotakSaran",listColmn);
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        //-------------------------
        
        ModeData = "tbl_kotakSaran";
        UkuranTable();
        //-------------------------
    }
    
    public void getDataTamu(){
        btnInsert.setText("INSERT");
        btnUpdate.setText("UPDATE");
        btnUpdate.setVisible(true);
        //ComboBox Pilihan  -------
        CustomListColmn = new String[5];
        CustomListColmn[0] = "Id";
        CustomListColmn[1] = "Nama";
        CustomListColmn[2] = "Asal";
        CustomListColmn[3] = "Catatan";
        CustomListColmn[4] = "Tanggal";
           
        JComboBox1.removeAllItems();
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
            
        
        //Table get----------------
        listColmn = new String[5];
        listColmn[0] = "id";
        listColmn[1] = "nama";
        listColmn[2] = "asal";
        listColmn[3] = "catatan";
        listColmn[4] = "tanggal";
        
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_tamu",listColmn);
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        
        
        ModeData = "tbl_tamu";
        UkuranTable();
        //-------------------------
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        btnDataUser = new javax.swing.JButton();
        btnDataBuku = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnDataPinjam = new javax.swing.JButton();
        btnDataKotakSaran = new javax.swing.JButton();
        btnDataTamu = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelJudul = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        panelBtn = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        panelSearch = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        JComboBox1 = new javax.swing.JComboBox<>();
        JLTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtama = new javax.swing.JTable();
        panelBtn2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(204, 204, 255));

        btnDataUser.setBackground(new java.awt.Color(255, 255, 255));
        btnDataUser.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDataUser.setText("DATA USER");
        btnDataUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDataUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataUserActionPerformed(evt);
            }
        });

        btnDataBuku.setBackground(new java.awt.Color(255, 255, 255));
        btnDataBuku.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDataBuku.setText("DATA BUKU");
        btnDataBuku.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataBukuActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 26)); // NOI18N
        jLabel12.setText("SELAMAT DATANG");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 26)); // NOI18N
        jLabel13.setText("ADMIN");

        btnDataPinjam.setBackground(new java.awt.Color(255, 255, 255));
        btnDataPinjam.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDataPinjam.setText("DATA PINJAM");
        btnDataPinjam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDataPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPinjamActionPerformed(evt);
            }
        });

        btnDataKotakSaran.setBackground(new java.awt.Color(255, 255, 255));
        btnDataKotakSaran.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDataKotakSaran.setText("DATA KOTAK SARAN");
        btnDataKotakSaran.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDataKotakSaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKotakSaranActionPerformed(evt);
            }
        });

        btnDataTamu.setBackground(new java.awt.Color(255, 255, 255));
        btnDataTamu.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDataTamu.setText("DATA TAMU");
        btnDataTamu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDataTamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTamuActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDataBuku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataKotakSaran, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataTamu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(134, 134, 134))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(34, 34, 34)
                .addComponent(btnDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(btnDataBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(btnDataPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(btnDataKotakSaran, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(btnDataTamu, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("MENU ADMIN REPORT");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel11)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelBtn.setBackground(new java.awt.Color(153, 255, 153));

        btnInsert.setBackground(new java.awt.Color(255, 255, 255));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/add-user.png"))); // NOI18N
        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/refresh.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/delete.png"))); // NOI18N
        btnDel.setText("DELETE");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-16/export.png"))); // NOI18N
        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelSearch.setBackground(new java.awt.Color(153, 255, 153));

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel17.setText("Cari");

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel18.setText(" :");

        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel24.setText("Berdasarkan");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setText(" :");

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch1))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JComboBox1)))
                .addContainerGap())
        );

        JLTable.setBackground(new java.awt.Color(153, 255, 153));

        tblUtama.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUtama);

        javax.swing.GroupLayout JLTableLayout = new javax.swing.GroupLayout(JLTable);
        JLTable.setLayout(JLTableLayout);
        JLTableLayout.setHorizontalGroup(
            JLTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JLTableLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1)
                .addGap(26, 26, 26))
        );
        JLTableLayout.setVerticalGroup(
            JLTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JLTableLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelBtn2.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout panelBtn2Layout = new javax.swing.GroupLayout(panelBtn2);
        panelBtn2.setLayout(panelBtn2Layout);
        panelBtn2Layout.setHorizontalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 885, Short.MAX_VALUE)
        );
        panelBtn2Layout.setVerticalGroup(
            panelBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(JLTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1379, 959);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataUserActionPerformed
        // TODO add your handling code here:
        getDataUser();
        btnDataUser.setBackground(SelectColor);
        btnDataBuku.setBackground(unSelectColor);
        btnDataPinjam.setBackground(unSelectColor);
        btnDataKotakSaran.setBackground(unSelectColor);
        btnDataTamu.setBackground(unSelectColor);
        btnExit.setBackground(unSelectColor);
    }//GEN-LAST:event_btnDataUserActionPerformed

    private void btnDataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBukuActionPerformed
        getDataBuku();
        btnDataUser.setBackground(unSelectColor);
        btnDataBuku.setBackground(SelectColor);
        btnDataPinjam.setBackground(unSelectColor);
        btnDataKotakSaran.setBackground(unSelectColor);
        btnDataTamu.setBackground(unSelectColor);
        btnExit.setBackground(unSelectColor);
    }//GEN-LAST:event_btnDataBukuActionPerformed

    private void btnDataPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPinjamActionPerformed
        // TODO add your handling code here
        getDataPinjam();
        btnDataUser.setBackground(unSelectColor);
        btnDataBuku.setBackground(unSelectColor);
        btnDataPinjam.setBackground(SelectColor);
        btnDataKotakSaran.setBackground(unSelectColor);
        btnDataTamu.setBackground(unSelectColor);
        btnExit.setBackground(unSelectColor);
    }//GEN-LAST:event_btnDataPinjamActionPerformed

    private void btnDataKotakSaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKotakSaranActionPerformed
        // TODO add your handling code here:
        getDataKotakSaran();
        btnDataUser.setBackground(unSelectColor);
        btnDataBuku.setBackground(unSelectColor);
        btnDataPinjam.setBackground(unSelectColor);
        btnDataKotakSaran.setBackground(SelectColor);
        btnDataTamu.setBackground(unSelectColor);
        btnExit.setBackground(unSelectColor);
    }//GEN-LAST:event_btnDataKotakSaranActionPerformed

    private void btnDataTamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTamuActionPerformed
        // TODO add your handling code here:
        getDataTamu();
        btnDataUser.setBackground(unSelectColor);
        btnDataBuku.setBackground(unSelectColor);
        btnDataPinjam.setBackground(unSelectColor);
        btnDataKotakSaran.setBackground(unSelectColor);
        btnDataTamu.setBackground(SelectColor);
        btnExit.setBackground(unSelectColor);
    }//GEN-LAST:event_btnDataTamuActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:

        //---
        int optionIndex = JComboBox1.getSelectedIndex();
        String[] option = {listColmn[optionIndex]};

        JTextField txtSearchF = (JTextField) evt.getSource();
        String[] search = {txtSearchF.getText()};

        //nama tabel diambil dari variabel ModeData
        DataTable = koneksiData.cSelectOneDef(ModeData,listColmn,1000,option,search);
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        //---
        
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
        
        
        UkuranTable();

    }//GEN-LAST:event_txtSearch1KeyReleased

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        btnDataUser.setBackground(unSelectColor);
        btnDataBuku.setBackground(unSelectColor);
        btnDataPinjam.setBackground(unSelectColor);
        btnDataKotakSaran.setBackground(unSelectColor);
        btnDataTamu.setBackground(unSelectColor);
        btnExit.setBackground(SelectColor);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        ModeExec = "INSERT";
        setTableColumn(); 
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        int selectedRowIndex = tblUtama.getSelectedRow();
        
        redirectMenu(); 
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        ModeExec = "UPDATE";
        setTableColumn(); //[+] FILL Target Column
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        int selectedRowIndex = tblUtama.getSelectedRow();
        
            if(-1 != selectedRowIndex){
            
                listColmnRow = new String[listColmn.length];
                for (int i = 0; i < listColmn.length; i++) {
                    listColmnRow[i]= model.getValueAt(selectedRowIndex, i).toString();   //[+] FILL Isi Column
                }
                
                redirectMenu(); 
            }else{
                JOptionPane.showMessageDialog(
                            null,
                            "Pilihlah table terlebih dahulu !!",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        
        ModeExec = "DELETE";
        setTableColumn(); //[+] FILL Target Column
        
        DefaultTableModel model = (DefaultTableModel)tblUtama.getModel();
        int selectedRowIndex = tblUtama.getSelectedRow();
        
        if(-1 != selectedRowIndex){    
            listColmnRow = new String[listColmn.length];
            for (int i = 0; i < listColmn.length; i++) {
                listColmnRow[i]= model.getValueAt(selectedRowIndex, i).toString();   //[+] FILL Isi Column
            }  
            
            koneksiData conn = new koneksiData();
            if("tbl_buku".equals(ModeData)){ 
                conn.cDeleteOne(ModeData,listColmn[6],listColmnRow[6]);
            }else{
                conn.cDeleteOne(ModeData,listColmn[0],listColmnRow[0]);
            };
            
            
            JOptionPane.showMessageDialog(
                        null,
                        "Data berhasil dihapus !!",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        
            //-----
            this.dispose();
        
            Color arrColor[] = new Color[6];
            arrColor[0] = unSelectColor;
            arrColor[1] = unSelectColor;
            arrColor[2] = unSelectColor;
            arrColor[3] = unSelectColor;
            arrColor[4] = unSelectColor;
            arrColor[5] = unSelectColor;
            
            FaAdmin MA = new FaAdmin();
            MA.setDefaultCloseOperation(MA.DISPOSE_ON_CLOSE);
            if("tbl_users".equals(ModeData)){
                MA.getDataUser();
                arrColor[0] = SelectColor;
                MA.setColor(arrColor);
            }else if("tbl_buku".equals(ModeData)){ 
                arrColor[1] = SelectColor;
                MA.setColor(arrColor);
                MA.getDataBuku();
            }else if("tbl_pinjam".equals(ModeData)){
                arrColor[2] = SelectColor;
                MA.setColor(arrColor);
                MA.getDataPinjam(); 
            }else if("tbl_kotakSaran".equals(ModeData)){
                arrColor[3] = SelectColor;
                MA.setColor(arrColor);
                MA.getDataKotakSaran();
            }else if("tbl_tamu".equals(ModeData)){
                arrColor[4] = SelectColor;
                MA.setColor(arrColor);
                MA.getDataTamu();
            }else{}
            MA.dataIn(DataLogin);
            //MA.getTable();
            MA.setLocationRelativeTo(null);
            MA.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(
                        null,
                        "Pilihlah table terlebih dahulu !!",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDelActionPerformed

    //---------------------------------------------------------------------------------------
    public void exportJesper(){
    // TODO add your handling code here: 
        String USER = "root";
        String PASS = "";
        String DB_NAME = "perpustakaan";
        String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        
        //File reportFile = new File(".");
        //String dirr = ".";
        
        
        String nmFile = ".";
        String nmSql = ".";
        if("tbl_users".equals(ModeData)){
            nmFile = "jr_tbl_users.jrxml";
            nmSql = "SELECT * FROM perpustakaan.tbl_users";
        }else if("tbl_buku".equals(ModeData)){
            nmFile = "jr_tbl_buku.jrxml";
            nmSql = "SELECT * FROM perpustakaan.tbl_buku";
        }else if("tbl_pinjam".equals(ModeData)){
            nmFile = "jr_tbl_pinjam.jrxml";
            nmSql = "SELECT * FROM perpustakaan.tbl_pinjam";
        }else if("tbl_kotakSaran".equals(ModeData)){
            nmFile = "jr_tbl_kotakSaran.jrxml";
            nmSql = "SELECT * FROM perpustakaan.tbl_kotaksaran";
        }else if("tbl_tamu".equals(ModeData)){
            nmFile = "jr_tbl_tamu.jrxml";
            nmSql = "SELECT * FROM perpustakaan.tbl_tamu";
        }else{}
            
        
        try{
            Class.forName(JDBC_DRIVER);
            Connection conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            Statement st = conn.createStatement();
            String sql = nmSql;
            //String dirr = new File(".").getCanonicalPath()+"/src/programasps/backend/"; //untuk didalam Netbeans 8.2
            //--masih ada problem jika menggunakan new File(), maka membuat baru di lokasi baru 
            String dirr = new File("../src/programasps/backend/").getCanonicalPath()+"/"; //untuk ketika build
            
            
            System.out.println(dirr);
            
            JasperDesign jasperDesign = JRXmlLoader.load(dirr+nmFile);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            ResultSet rs = st.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs); 
            
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), rsDataSource);
            JasperViewer.viewReport(print, false);
            
                    
        } catch (ClassNotFoundException | SQLException | JRException | IOException ex) {
            //Logger.getLogger(MainFrame.class.getName().log(Level.SEVERE, null, ex));
            JOptionPane.showMessageDialog(
                        null,
                        "GAGAl Mencetak : "+ex ,
                        "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //---------------------------------------------------------------------------------------
    public void exportJTable(){
        LocalDate datenow = LocalDate.now();
       
        MessageFormat header=new MessageFormat("Report : "+datenow.toString());
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            tblUtama.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            e.getMessage();
        } 
    }
    
    //---------------------------------------------------------------------------------------
    
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        exportJesper();
        //exportJTable();
    }//GEN-LAST:event_btnExportActionPerformed

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
            java.util.logging.Logger.getLogger(FaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox1;
    private javax.swing.JPanel JLTable;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnDataBuku;
    private javax.swing.JButton btnDataKotakSaran;
    private javax.swing.JButton btnDataPinjam;
    private javax.swing.JButton btnDataTamu;
    private javax.swing.JButton btnDataUser;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelBtn2;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JTable tblUtama;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
