/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author prajeetajoshi
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        AboutUs = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        ContactUs = new javax.swing.JLabel();
        Events = new javax.swing.JLabel();
        More = new javax.swing.JLabel();
        Signout = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Ourteam = new javax.swing.JLabel();
        Support = new javax.swing.JLabel();
        CustomerReview = new javax.swing.JLabel();
        PrivacyPolicy = new javax.swing.JLabel();
        jButtonPersonalInfo = new javax.swing.JButton();
        jButtonView = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonBook = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2025-05-22 at 20.23.59.png"))); // NOI18N
        jLabel3.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hamro Events  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 411, 46));

        jPanel1.setBackground(new java.awt.Color(248, 245, 221));

        Home.setText("Home");

        AboutUs.setText("About Us");

        Services.setText("Services");

        ContactUs.setText("Contact Us");

        Events.setText("Events");

        More.setText("More");

        Signout.setText("Sign Out");
        Signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignoutMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Screenshot 2025-05-31 182812 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(Home)
                .addGap(52, 52, 52)
                .addComponent(AboutUs)
                .addGap(35, 35, 35)
                .addComponent(Services)
                .addGap(36, 36, 36)
                .addComponent(ContactUs)
                .addGap(44, 44, 44)
                .addComponent(Events)
                .addGap(47, 47, 47)
                .addComponent(More, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Signout))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Signout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Home)
                                .addComponent(AboutUs)
                                .addComponent(Services)
                                .addComponent(ContactUs)
                                .addComponent(Events, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(More))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 827, 100));

        jPanel2.setBackground(new java.awt.Color(248, 245, 221));

        jLabel5.setText("Hamro Events, Nepal's number one event management system.");

        Ourteam.setText("Our Team");

        Support.setText("Support");

        CustomerReview.setText("Customer Review");

        PrivacyPolicy.setText("Privacy Policy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Ourteam)
                    .addComponent(Support))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerReview, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PrivacyPolicy, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Ourteam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Support))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(CustomerReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrivacyPolicy)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 830, -1));

        jButtonPersonalInfo.setText("    Personal Information");
        jButtonPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonalInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 180, 40));

        jButtonView.setText("       View Event Status");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 180, 40));

        jButtonEdit.setText("         Edit Event Status");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 180, 40));

        jButtonBook.setText("Booked Ticket List");
        getContentPane().add(jButtonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 180, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2025-05-22 at 20.23.59.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 830, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonalInfoActionPerformed
        // TODO add your handling code here:
        new AdminPersonalInfo().setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_jButtonPersonalInfoActionPerformed

    private void SignoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignoutMouseClicked
        // TODO add your handling code here:
        int response = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to sign out?", 
            "Confirm Sign Out",
            javax.swing.JOptionPane.YES_NO_OPTION
    );
    if (response == javax.swing.JOptionPane.YES_OPTION) {
        System.exit(0); // This will close the entire application
    }
    
    }//GEN-LAST:event_SignoutMouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
           
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        // TODO add your handling code here:
        new AdminViewEvent().setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_jButtonViewActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AboutUs;
    private javax.swing.JLabel ContactUs;
    private javax.swing.JLabel CustomerReview;
    private javax.swing.JLabel Events;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel More;
    private javax.swing.JLabel Ourteam;
    private javax.swing.JLabel PrivacyPolicy;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Signout;
    private javax.swing.JLabel Support;
    private javax.swing.JButton jButtonBook;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonPersonalInfo;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}