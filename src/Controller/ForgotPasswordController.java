/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Dao.UserDao;
import Model.OTP;
import View.ResetPassword;
import View.OTPEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Rashmi Jha
 */
public class ForgotPasswordController {
  
     private final UserDao userDao = new UserDao();
    private final ResetPassword resetView;

    public ForgotPasswordController(ResetPassword resetView) {
        this.resetView = resetView;
        resetView.addUserListener(new SendCodeListener());
    }

    public void open() {
        resetView.setVisible(true);
    }

    public void close() {
        resetView.dispose();
    }

    class SendCodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Send button clicked"); // Debug print
            String email = resetView.gettextEmail().getText();
            System.out.println("Email entered: " + email); // Debug print

            if (email.isEmpty() || email.equals("Enter your email")) {
                JOptionPane.showMessageDialog(resetView, "Please enter your email.");
                return;
            }

            String otpCode = String.format("%06d", new Random().nextInt(999999));
            System.out.println("Generated OTP: " + otpCode); // Debug print
            OTP otp = new OTP(email, otpCode);

            boolean generateOTP = userDao.generateOTP(otp);
            System.out.println("OTP generation result: " + generateOTP); // Debug print

            if (generateOTP) {
                boolean emailSent = EmailUtil.sendOTPEmail(email, otpCode);
                System.out.println("Email sending result: " + emailSent); // Debug print

                if (emailSent) {
                    close();
                    OTPEntry otpEntryView = new OTPEntry();
                    OTPEntryController otpEntryController = new OTPEntryController(otpEntryView, userDao, email);
                    otpEntryController.open();
                } else {
                    JOptionPane.showMessageDialog(resetView, "Failed to send OTP email. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(resetView, "Failed to generate OTP. Please try again.");
            }
        }
    }
}

