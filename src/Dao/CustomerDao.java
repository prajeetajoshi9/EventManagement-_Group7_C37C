/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.DbConnection;  // ✅ use your existing DB class

public class CustomerDao {
    public boolean saveCustomer(Customer customer) {
        String sql = "INSERT INTO customer (first_name, last_name, contact_number, id_number, email, address) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getContactNumber());
            stmt.setString(4, customer.getIdNumber());
            stmt.setString(5, customer.getEmail());
            stmt.setString(6, customer.getAddress());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
