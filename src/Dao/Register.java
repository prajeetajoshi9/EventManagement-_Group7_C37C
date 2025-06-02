/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;



import java.sql.*;

public class Register {
    public boolean registerAdmin(Admin admin) {
        String sql = "INSERT INTO admins (admin_id, username, first_name, last_name, email, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, admin.getAdminId());
            stmt.setString(2, admin.getUsername());
            stmt.setString(3, admin.getFirstName());
            stmt.setString(4, admin.getLastName());
            stmt.setString(5, admin.getEmail());
            stmt.setString(6, admin.getPhone());
            stmt.setString(7, admin.getPassword());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Registration Error: " + e.getMessage());
            return false;
        }
    }
}

/**
 *
 * @author prasmshachapagain
 */
