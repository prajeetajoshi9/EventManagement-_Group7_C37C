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

    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET first_name=?, last_name=?, contact_number=?, id_number=?, address=? WHERE email=?";

        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getContactNumber());
            stmt.setString(4, customer.getIdNumber());
            stmt.setString(5, customer.getAddress());
            stmt.setString(6, customer.getEmail());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer getCustomerByEmail(String email) {
        String sql = "SELECT * FROM customer WHERE email = ?";

        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("contact_number"),
                    rs.getString("id_number"),
                    rs.getString("email"),
                    rs.getString("address")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
