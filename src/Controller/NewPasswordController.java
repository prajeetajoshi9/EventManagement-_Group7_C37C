/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Dao.UserDao;

import Model.User;
import View.NewPassword;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Rashmi Jha
 */
public class NewPasswordController {
    
    private final NewPassword newPasswordView;
    private final UserDao userDao;
    private final String email;

    public NewPasswordController(NewPassword newPasswordView, UserDao userDao, String email) {
        this.newPasswordView = newPasswordView;
        this.userDao = userDao;
        this.email = email;

        newPasswordView.addUserListener(new ResetPasswordListener());
    }

    public void open() {
        newPasswordView.setVisible(true);
    }

    public void close() {
        newPasswordView.dispose();
    }

    class ResetPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pass = newPasswordView.gettxtPassword().getText();
            String confirmPass = newPasswordView.gettxtReEnterPassword().getText();

            if (pass.isEmpty() || confirmPass.isEmpty() ||
                pass.equals("Enter your new Password") ||
                confirmPass.equals("Re-enter your new password")) {
                JOptionPane.showMessageDialog(newPasswordView, "Please fill in all password fields.");
                return;
            }

            if (!pass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(newPasswordView, "Passwords do not match.");
                return;
            }

            User user = new User(email, pass);

            boolean resetPassword = userDao.resetPassword(user);

            if (resetPassword) {
                JOptionPane.showMessageDialog(newPasswordView, "Password reset successful! You can now log in.");
                close();
            } else {
                JOptionPane.showMessageDialog(newPasswordView, "Failed to reset password. Please try again.");
            }
        }
    }
}

