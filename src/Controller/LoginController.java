/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author prasmshachapagain
 */
 package Controller;

import Dao.User;
import Model.Login;
import View.AdminDashboard;
import View.LoginAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {
    private final User userLogindao = new User();
    private final LoginAdmin userView;

    public LoginController(LoginAdmin userView) {
        this.userView = userView;
        userView.addLoginUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String Username = userView.getUsernameField().getText();
                String Password = new String(userView.getPasswordField().getPassword());

                Login loginUser = userLogindao.AdminLogin(Username, Password);
                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                } else {
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                        AdminDashboard dashboard = new AdminDashboard();
                             dashboard.setVisible(true);


userView.dispose();
                   
                }
            } catch (Exception ex) {
                System.out.println("Error during login: " + ex.getMessage());
            }
        }
    }
}
