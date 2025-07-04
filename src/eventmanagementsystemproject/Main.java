/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystemproject;

import Controller.LoginController;
import Controller.SignupController;
import View.LoginAdmin;
import View.AdminSignup;

public class Main {
    public static void main(String[] args) {
        // Optional: Set Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to set Nimbus look and feel: " + e);
        }

        // ----- Option 1: Launch Login View -----
        LoginAdmin loginView = new LoginAdmin();
        LoginController loginController = new LoginController(loginView);
        loginView.setVisible(true);

        // ----- Option 2: Launch Signup View -----
        // AdminSignup signupView = new AdminSignup();
        // SignupController signupController = new SignupController(signupView);
        // signupView.setVisible(true);
    }
}
