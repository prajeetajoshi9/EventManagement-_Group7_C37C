/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.User;
import model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.UserData;
import Model.UserModel;
import View.Customer_Login;
import View.Registration_form;
import model.Login;


/**
 *
 * @author digitech
 */
public class logincontroller {

    private final User userdao = new User();
    private final Customer_Login userView;

    public logincontroller(Customer_Login userView) {
        this.userView = userView;
        userView.addLoginUserListener(new AddLoginUserListener());
        userView.addAddUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddLoginUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                Login user = new Login(email,password);
                
                UserModel loginUser = userdao.signIn(user);
                
                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                } else {
                    // success
                    JOptionPane.showMessageDialog(userView, "Login Successful");
//                    Dashboard dashboard = new Dashboard();
//                    dashboard.setVisible(true);
//                    close();
                }
            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
    class AddUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Registration_form register = new Registration_form();
            register.setVisible(true);
            SignupController controller = new SignupController(register);
            controller.open();
            
        }
        
    }
}
