/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.AdminDashboard;
import View.AdminPersonalInfo;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author prajeetajoshi
 */
public class AdminDashController { 
    
    public void openPersonalInfo(AdminDashboard dashboard) {
        new AdminPersonalInfo().setVisible(true);
        dashboard.dispose();
    }

    public void handleSignOut(JFrame frame) {
        int response = JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to sign out?",
            "Confirm Sign Out",
            JOptionPane.YES_NO_OPTION
        );
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}


