/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author prasmshachapagain
 */
package Controller;

import Dao.StripePaymentDao;
import Dao.PaymentDao;
import Model.PaymentInfo;
import View.Payment;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentController {
    private Payment view;

    public PaymentController(Payment view) {
        this.view = view;
        
        this.view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePaymentDetails();
            }
            
        });
        view.getEditButton().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        enableEditing();
    }

            private void enableEditing() {
               view.getPaymentMethodCombo().setEnabled(true);
               view.getAccountNumberField().setEditable(true);
               view.yes().setEnabled(true);
               view.getNoButton().setEnabled(true);
            }
        });

    }

    public void savePaymentDetails() {
        try {
            String method = (String) view.getPaymentMethodCombo().getSelectedItem();
            String accountNumber = view.getAccountNumberField().getText();
            boolean consent = view.yes().isSelected();

            if (accountNumber == null || accountNumber.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter your account number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // You can assign a dummy fixed amount or retrieve from input if dynamic
            int amount = 1050000; // e.g., amount in cents

            // Create payment info object
            PaymentInfo info = new PaymentInfo();
            info.setPaymentMethod(method);
            info.setAccountNumber(accountNumber);
            info.setConsent(consent);
            info.setAmount(amount);

            // 1. Save to database
            PaymentDao dao = new PaymentDao();
            boolean saved = dao.savePaymentInfo(info);

            // 2. Trigger Stripe payment
            StripePaymentDao stripe = new StripePaymentDao();
            stripe.createPaymentIntent(amount, "usd");

            if (saved) {
                JOptionPane.showMessageDialog(view, "Payment processed successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Failed to save payment.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
