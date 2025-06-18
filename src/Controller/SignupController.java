/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Dao.Login;
import Model.Adminregister;
import View.AdminSignup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SignupController {

    private final AdminSignup view;

    public SignupController(AdminSignup view) {
        this.view = view;

        // Attach event listener to Sign Up button
        this.view.getSignupButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAdmin();    
            }
        });
        
    }

    private void registerAdmin() {
        String adminId = view.jadmin.getText();
        String username = view.jusername.getText();
        String firstName = view.jname.getText();
        String lastName = view.jlast.getText();
        String email = view.jemail.getText();
        String phone = view.jphone.getText();
        String password = String.valueOf(view.jPassword.getPassword());
        String confirmPassword = String.valueOf(view.jconfirm.getPassword());
        
        
        if (adminId.isEmpty() || username.isEmpty() || firstName.isEmpty() || lastName.isEmpty()
            || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Please fill in all the fields.");
        return;
    }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(view, "Passwords do not match!");
            return;
        }

        Adminregister user = new Adminregister();
        user.setAdminId(adminId);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        boolean success = Login.registerUser(user);
        if (success) {
            JOptionPane.showMessageDialog(view, "Signup successful!");
        } else {
            JOptionPane.showMessageDialog(view, "Signup failed. Try again.");
        }
    }
}
