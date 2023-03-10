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
public class EbKotakSaran extends javax.swing.JFrame {

    /**
     * Creates new form AaGuestPanel
     */
    
    //waktu saat ini
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    
    String CBperanRole[] = {"SISWA","GURU"};
    String CBJK[] = {"LAKI-LAKI","PEREMPUAN"};
    
    String[][] DataLogin;
    
    public EbKotakSaran() {
        initComponents();
        //this.setExtendedState(BaFromRegister.MAXIMIZED_BOTH);
        
        panelJudul1.setBackground(new Color(100, 0, 0, 0));
        panelIsi1.setBackground(new Color(100, 0, 0, 0));
        panelBtn1.setBackground(new Color(100, 0, 0, 0));
        
    }
    
    public String[][] dataIn(String[][] dataLogin){
        DataLogin = dataLogin;
        return dataLogin;
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
        panelIsi1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtkotaksaran = new javax.swing.JTextArea();
        panelBtn1 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelLogin.setBackground(new java.awt.Color(255, 255, 204));

        panelJudul1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel11.setText("KOTAK SARAN");

        javax.swing.GroupLayout panelJudul1Layout = new javax.swing.GroupLayout(panelJudul1);
        panelJudul1.setLayout(panelJudul1Layout);
        panelJudul1Layout.setHorizontalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJudul1Layout.setVerticalGroup(
            panelJudul1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panelIsi1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel14.setText("Masukkan saran kamu untuk perpustakaan ini :");

        txtkotaksaran.setColumns(20);
        txtkotaksaran.setRows(5);
        jScrollPane1.setViewportView(txtkotaksaran);

        javax.swing.GroupLayout panelIsi1Layout = new javax.swing.GroupLayout(panelIsi1);
        panelIsi1.setLayout(panelIsi1Layout);
        panelIsi1Layout.setHorizontalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIsi1Layout.setVerticalGroup(
            panelIsi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsi1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        panelBtn1.setBackground(new java.awt.Color(153, 255, 153));

        btnSend.setText("SEND");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

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
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        panelBtn1Layout.setVerticalGroup(
            panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtn1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelJudul1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelIsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 665, 531);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        
        String listColmn[]= { 
            "id",
            "nama",
            "saran",
            "tanggal"
        };

        String listColmnRow[]= { 
            "0",
            DataLogin[0][1],
            txtkotaksaran.getText(),
            dtf.format(now)
        };
        
        
        if(!"".equals(listColmnRow[2])){
            koneksiData connInsert = new koneksiData();
            DataLogin = connInsert.cInsert("tbl_kotakSaran",listColmn,listColmnRow);
            
            JOptionPane.showMessageDialog(
                    null,
                    "Terimakasih atas sarannya",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "Silahkan isi saran terlebih dahulu.",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
            
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancleActionPerformed

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
            java.util.logging.Logger.getLogger(EbKotakSaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EbKotakSaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EbKotakSaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EbKotakSaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BaFromRegister().setVisible(true);
                
                EbKotakSaran fRegis = new EbKotakSaran();
                //fRegis.setLocationRelativeTo(null);  //ditaruh saat class dipanggil
                fRegis.setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBtn1;
    private javax.swing.JPanel panelIsi1;
    private javax.swing.JPanel panelJudul1;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextArea txtkotaksaran;
    // End of variables declaration//GEN-END:variables
}
