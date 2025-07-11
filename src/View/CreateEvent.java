/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Color;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author prajeetajoshi
 */
public class CreateEvent extends javax.swing.JFrame {

    private AbstractButton jRadioButton2;
    private String privacy;

    /**
     * Creates new form CreateEvent
     * @param controller
     */
    public CreateEvent(CreateEvent controller) {
        initComponents();
    }

    CreateEvent() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        jLabel13 = new javax.swing.JLabel();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Return = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        EventText = new javax.swing.JTextField();
        TypeText = new javax.swing.JTextField();
        DescriptionText = new javax.swing.JTextField();
        GuestText = new javax.swing.JTextField();
        BudgetText = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        javax.swing.JRadioButton jRadioButton1 = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jRadioButton3.setText("jRadioButton3");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/create.png"))); // NOI18N
        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2025-05-22 at 20.45.48.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("Create Events");

        Return.setBackground(new java.awt.Color(37, 78, 201));
        Return.setForeground(new java.awt.Color(255, 255, 255));
        Return.setText("Return to Homepage");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233)
                .addComponent(Return)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 919, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Event Title:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 130, 96, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Event Type:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 188, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Time:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Description:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 292, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("Number of Guests:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 389, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setText("Budget:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 461, -1, -1));

        EventText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EventTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EventTextFocusLost(evt);
            }
        });
        EventText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventTextActionPerformed(evt);
            }
        });
        getContentPane().add(EventText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 124, 569, 40));

        TypeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TypeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TypeTextFocusLost(evt);
            }
        });
        TypeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeTextActionPerformed(evt);
            }
        });
        getContentPane().add(TypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 182, 242, 40));
        getContentPane().add(DescriptionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 292, 569, 59));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 383, 246, 40));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 455, 246, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t•\tSolti Grand Party Palace, Kalanki", "\t•\tRudra Banquet & Events, Banasthali", "\t•\tUtsav Banquet, Tripureshwor", "\t•\tRoyal Empire Party Palace, Baneshwor", "\t•\tDurbar Banquet, Lazimpat", "\t•\tSubha Griha Banquet, Chabahil", "\t•\tGolden Palace Banquet, Gwarko", "\t•\tParadise Party Venue, Koteshwor", "\t•\tEverest Party Palace, Gongabu", "\t•\tDream Garden Banquet, Bhaktapur" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 383, 245, 40));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel9.setText("Date:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 182, -1, -1));

        jLabel10.setText("Venue:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 395, -1, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel11.setText("Event Privacy: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 457, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Public");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 455, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Private");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 455, -1, -1));

        jButton1.setBackground(new java.awt.Color(38, 78, 201));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 553, 100, 40));

        jButton2.setBackground(new java.awt.Color(38, 78, 201));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 553, 100, 40));

        jButton3.setBackground(new java.awt.Color(38, 78, 201));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 554, 100, 40));

        jLabel12.setText("_");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 252, 21, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 182, 246, 40));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 242, 40));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel15.setText("Set  Ticket Price: ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 240, 246, 40));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 115, 42));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/create.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 890, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         // Open the CustomerDashboard
    Customerdashboard dashboard = new Customerdashboard();
    dashboard.setVisible(true);

    // Close this current frame
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
                 // Open the CustomerDashboard
    Customerdashboard dashboard = new Customerdashboard();
    dashboard.setVisible(true);

    // Close this current frame
    this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            // Navigate to CustomerEditEvent
    CustomerEditEvent customerEditEvent = new CustomerEditEvent();
    customerEditEvent.setVisible(true);
    customerEditEvent.setLocationRelativeTo(null); // Optional: center the window
    this.dispose(); // Optional: close the current window
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    String title = EventText.getText();
    String type = TypeText.getText();
    java.util.Date date = jDateChooser1.getDate();
    String description = DescriptionText.getText();
    String guestStr = jTextField4.getText();
    String budgetStr = jTextField5.getText();
    
    String venue = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "";

    // Validate privacy choice


    try {
        int guests = Integer.parseInt(guestStr);
        double budget = Double.parseDouble(budgetStr);
        String time = "10:00 AM"; // Set a default time or add a time field in your UI

        boolean success = Controller.EventController.createEvent(
            title, type, time, date, description, guests, budget, venue, privacy
        );

        if (success) {
            JOptionPane.showMessageDialog(this, "Event created successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create event.");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for guests and budget.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TypeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeTextActionPerformed

    private void EventTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EventTextFocusGained
        // TODO add your handling code here:
         if (EventText.getText().equals("Provide name for the event (e.g. Happy Halloween)")){
            EventText.setText("");
            EventText.setForeground(Color.BLACK); 
    }
    }//GEN-LAST:event_EventTextFocusGained

    private void EventTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EventTextFocusLost
        // TODO add your handling code here:
         if(EventText.getText().isEmpty()){
            EventText.setText("Provide name for the event (e.g. Happy Halloween)");
            EventText.setForeground(new java.awt.Color(216,216,216));
    }
    }//GEN-LAST:event_EventTextFocusLost

    private void EventTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EventTextActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
           String selectedTime = (String) jComboBox4.getSelectedItem();
    if (selectedTime != null) {
        JOptionPane.showMessageDialog(this, "Selected time: " + selectedTime);
        
        // Or use it programmatically:
        System.out.println("User selected: " + selectedTime);
        
        // You can store it or pass it to a model
        // event.setTime(selectedTime);
    }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       JComboBox comboBox = (JComboBox) evt.getSource();
    String selectedItem = (String) comboBox.getSelectedItem();

    // Default party palace
    String eventPlace = "";

    eventPlace = switch (selectedItem) {
            case "Wedding Ceremony" -> "Solti Grand Party Palace, Kalanki";
            case "Birthday Bash" -> "Rudra Banquet & Events, Banasthali";
            case "Corporate Meetup" -> "Utsav Banquet, Tripureshwor";
            case "Engagement Party" -> "Royal Empire Party Palace, Baneshwor";
            case "Farewell Program" -> "Durbar Banquet, Lazimpat";
            case "Anniversary Celebration" -> "Subha Griha Banquet, Chabahil";
            case "Graduation Party" -> "Golden Palace Banquet, Gwarko";
            case "Baby Shower" -> "Paradise Party Venue, Koteshwor";
            case "Reception" -> "Everest Party Palace, Gongabu";
            case "Cultural Program" -> "Dream Garden Banquet, Bhaktapur";
            default -> "Venue to be announced";
        };

    System.out.println("Selected Event: " + selectedItem);
    System.out.println("Event Place: " + eventPlace);

    JOptionPane.showMessageDialog(null, "You selected: " + selectedItem +
                                          "\nEvent Place: " + eventPlace);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
          // Get the selected time from the combo box
    JComboBox comboBox = (JComboBox) evt.getSource();
    String selectedTime = (String) comboBox.getSelectedItem();

    // Display the selected time with AM/PM
    System.out.println("Selected Time: " + selectedTime);

    // Optional: show it in a dialog box
    JOptionPane.showMessageDialog(null, "You selected time: " + selectedTime);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void TypeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TypeTextFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_TypeTextFocusGained

    private void TypeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TypeTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeTextFocusLost

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        privacy = "Public";
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
       // hide when Private
       privacy = "Private";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_ReturnActionPerformed

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
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            CreateEvent controller = null;
            new CreateEvent(controller).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BudgetText;
    private javax.swing.JTextField DescriptionText;
    private javax.swing.JTextField EventText;
    private javax.swing.JTextField GuestText;
    private javax.swing.JButton Return;
    private javax.swing.JButton SetPriceButton;
    private javax.swing.JComboBox<String> TimeText;
    private javax.swing.JTextField TypeText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
    /*
    private static class TimeText {*/
        

        private Object selectedItem; // Add this field if not already present

public Object getSelectedItem() {
    return selectedItem;
}

public void setSelectedItem(Object item) {
    this.selectedItem = item;
}

    private static class jRadioButton2 {


        public jRadioButton2() {
        }
    }

public class TimeComboBoxModel extends DefaultComboBoxModel<String> {
    public TimeComboBoxModel() {
        super(new String[] { "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", 
                             "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM" });
        
        
    }
    
}

        
    }
    

