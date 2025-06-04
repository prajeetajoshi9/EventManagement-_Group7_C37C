///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Controller;
//
//
//import Dao.UserDao;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
//import Model.UserModel;
//import View.Registration_form;
//
//public class SignupController {
//    private final UserDao userDao = new UserDao();
//    private final Registration_form userView;
//
//    public SignupController(Registration_form userView) {
//        this.userView = userView;
//        userView.addAddUserListener(new AddUserListener());
//    }
//
//    public void open() {
//        this.userView.setVisible(true);
//    }
//
//    public void close() {
//        this.userView.dispose();
//    }
//
//    class AddUserListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                String first_name = userView.getFirstNameField().getText();
//                 String last_name = userView.getLastNameField().getText();
//                  String phone_no = userView.getPhoneNoField().getText();
//                String email = userView.getEmailField().getText();
//                String password = userView.getPasswordField().getText();
//                String confirm_password =userView.getConfirmPasswordField().getText();
//
//                // Call the separate signUp method
//                signUp(first_name,last_name,phone_no,email, password, confirm_password);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
//            }
//        }
//
//        public boolean signUp(String first_name,String last_name,String phone_no, String email, String password, String confirm_password) {
//            if (!"7-11".equals(first_name)) {
//                JOptionPane.showMessageDialog(null, "Company name must be exactly '7-11'.");
//                return false;
//            }
//
//            if (email == null || email.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Email cannot be empty.");
//                return false;
//            }
//
//            if (password == null || password.trim().isEmpty() || password.equals("Set Password")) {
//                JOptionPane.showMessageDialog(null, "Please enter a valid password.");
//                return false;
//            }
//
//            if (!password.equals(confirm_password)) {
//                JOptionPane.showMessageDialog(null, "Confirm password didn't match!");
//                return false;
//            }
//
//            if (userDao.isEmailExists(email)) {
//                JOptionPane.showMessageDialog(null, "Email already in use!");
//                return false;
//            }
//
//            UserModel user = new UserModel(first_name ,last_name,phone_no, email,password,  confirm_password);
//            boolean success = userDao.signUp(user);
//
//            if (success) {
//                JOptionPane.showMessageDialog(null, "User signed up successfully!");
//             // ✅ Dispose current view and open a new one
//                          } else {
//                JOptionPane.showMessageDialog(null, "Signup failed!");
//            }
//
//            return success;
//        }
//
//        private void signUp(String first_name, String last_name, String phone_no, String email, String password, String confirm_password) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//    }
//}
//
//


package Controller;

import Dao.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.UserModel;
import View.Registration_form;

public class SignupController {
    private final User userdao = new User();
    private final Registration_form userView;

    public SignupController(Registration_form userView) {
        this.userView = userView;
        userView.addAddUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String first_name = userView.getFirstNameField().getText();
                String last_name = userView.getLastNameField().getText();
                String phone_no = userView.getPhoneNoField().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                String confirm_password = userView.getConfirmPasswordField().getText();

                // Call the signUp method
                signUp(first_name, last_name, phone_no, email, password, confirm_password);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        }

        public boolean signUp(String first_name, String last_name, String phone_no, String email, String password, String confirm_password) {
            if (!"7-11".equals(first_name)) {
                JOptionPane.showMessageDialog(null, "Company name must be exactly '7-11'.");
                return false;
            }

            if (email == null || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email cannot be empty.");
                return false;
            }

            if (password == null || password.trim().isEmpty() || password.equals("Set Password")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid password.");
                return false;
            }

            if (!password.equals(confirm_password)) {
                JOptionPane.showMessageDialog(null, "Confirm password didn't match!");
                return false;
            }
         
            if (userdao.isEmailExists(email)){
                JOptionPane.showMessageDialog(null, "Email already in use!");
                return false;
            }

            UserModel user = new UserModel(first_name, last_name, phone_no, email, password, confirm_password);
            boolean success = userdao.signUp(user);

            if (success) {
                JOptionPane.showMessageDialog(null, "User signed up successfully!");
                // You can open a new view or redirect here if needed
            } else {
                JOptionPane.showMessageDialog(null, "Signup failed!");
            }

            return success;
        }
    }
}
