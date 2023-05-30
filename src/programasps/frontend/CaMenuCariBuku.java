/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programasps.frontend;

import programasps.backend.koneksiData;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author dnrahmath
 */
public class CaMenuCariBuku extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //background color
    Color colorBackground = new Color(255, 255, 204, 255);
    Color colorBackgroundForm = new Color(255, 210, 185, 255); //jika mau liat batas panelnya
    
    String[][] DataTable;
    
    public CaMenuCariBuku(Color colorBackgroundIn,Color colorBackgroundFormIn) {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
    
        //background color
        colorBackground = colorBackgroundIn;
        colorBackgroundForm = colorBackgroundFormIn; //jika mau liat batas panelnya
        
        panelCariBuku.setBackground(colorBackground);
        panelJudul1.setBackground(colorBackgroundForm);
        panelIsi1.setBackground(colorBackgroundForm);
        panelIsi2.setBackground(colorBackgroundForm);
        
        
        //ComboBox Pilihan  -------
        String CustomListColmn[]= { 
            "Id", 
            "Judul Buku", 
            "Penulis Buku", 
            "Penerbit Oleh", 
            "Tahun Buku",
            "Kelas",
            "Status Buku",
            "System Id"
            //"Nama petugas input"  //menghilangkan colum nama_petugas_input
        };
        for (int i = 0; i < CustomListColmn.length; i++) {
            JComboBox1.addItem(CustomListColmn[i]);
        }
        //-------------------------
        
        
        String listColmn[]= { 
            "id_buku", 
            "judul_buku", 
            "penulis_buku", 
            "penerbit_oleh", 
            "tahun_buku", 
            "buku_kelas",
            "status_buku",
            "system_id",
            "nama_petugas_input"
        };
        
        koneksiData conn = new koneksiData();
        DataTable = conn.cSelectAll("tbl_buku",listColmn);
        
        DefaultTableModel model = (DefaultTableModel)tblPinjam.getModel();
        model.setDataVector(DataTable, CustomListColmn);
        tblPinjam.getColumnModel().getColumn(0).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(0).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(4).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(4).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(5).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(5).setMaxWidth(40);
        tblPinjam.getColumnModel().getColumn(7).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(7).setMaxWidth(40);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCariBuku = new javax.swing.JPanel();
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
        panelIsi2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPinjam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCariBuku.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("CARI BUKU");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/programasps/images/icon_asps/iloveimg-resized-64/research (2).png"))); // NOI18N

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGroup(panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJudul1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelJudul1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIsi2Layout.setVerticalGroup(
            panelIsi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCariBukuLayout = new javax.swing.GroupLayout(panelCariBuku);
        panelCariBuku.setLayout(panelCariBukuLayout);
        panelCariBukuLayout.setHorizontalGroup(
            panelCariBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCariBukuLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(panelCariBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panelCariBukuLayout.setVerticalGroup(
            panelCariBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCariBukuLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(panelJudul1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(panelIsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelIsi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(133, 133, 133))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 930, 643);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String CustomListColmn[]= { 
            "Id", 
            "Judul Buku", 
            "Penulis Buku", 
            "Penerbit Oleh", 
            "Tahun Buku",
            "Kelas",
            "Status Buku",
            "System Id"
            //"Nama petugas input"  //menghilangkan colum nama_petugas_input
        };
        //-------------------------------------------
        
        String listColmn[]= { 
            "id_buku", 
            "judul_buku", 
            "penulis_buku", 
            "penerbit_oleh", 
            "tahun_buku", 
            "buku_kelas",
            "status_buku",
            "system_id",
            "nama_petugas_input"
        };
        
        JTextField txtSearchF = (JTextField) evt.getSource();
        
        
        int optionIndex = JComboBox1.getSelectedIndex();
        String[] option = {listColmn[optionIndex]};
        //System.out.println("dipilih : "+option);
        
        String[] search = {txtSearchF.getText()};
        
        
        DataTable = koneksiData.cSelectOneDef("tbl_buku",listColmn,1000,option,search);
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
        tblPinjam.getColumnModel().getColumn(0).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(0).setMaxWidth(70);
        tblPinjam.getColumnModel().getColumn(4).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(4).setMaxWidth(60);
        tblPinjam.getColumnModel().getColumn(5).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(5).setMaxWidth(40);
        tblPinjam.getColumnModel().getColumn(7).setMinWidth(10);
        tblPinjam.getColumnModel().getColumn(7).setMaxWidth(40);
        
        
    }//GEN-LAST:event_txtSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],Color colorBackgroundIn,Color colorBackgroundFormIn) {
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
            java.util.logging.Logger.getLogger(CaMenuCariBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaMenuCariBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaMenuCariBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaMenuCariBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                CaMenuCariBuku CaMenuCari = new CaMenuCariBuku(colorBackgroundIn,colorBackgroundFormIn);
                CaMenuCari.setLocationRelativeTo(null);
                CaMenuCari.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCariBuku;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelIsi2;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JTable tblPinjam;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
