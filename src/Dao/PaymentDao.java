/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import Model.PaymentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDao {

    public static boolean savePaymentInfo(PaymentInfo payment) {
        Connection conn = new MySqlConnection().openConnection();

        try {
            String query = "INSERT INTO payment (paymentMethod, accountNumber, consent, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, payment.getPaymentMethod());
            stmt.setString(2, payment.getAccountNumber());
            stmt.setBoolean(3, payment.isConsent());
            stmt.setInt(4, payment.getAmount());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
