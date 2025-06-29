/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: Dao/Login.java
package Dao;

import Database.MySqlConnection;
import Model.Adminregister;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public static boolean registerUser(Adminregister user) {
        Connection conn = new MySqlConnection().openConnection(); 

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return false;
            }

            String checkSql = "SELECT * FROM admin WHERE adminId = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, user.getAdminId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Admin ID already exists!");
                return false;
            }


            String emailCheckSql = "SELECT * FROM admin WHERE email = ?";
            PreparedStatement emailCheckStmt = conn.prepareStatement(emailCheckSql);
            emailCheckStmt.setString(1, user.getEmail());
            ResultSet emailResult = emailCheckStmt.executeQuery();

            if (emailResult.next()) {
                JOptionPane.showMessageDialog(null, "Email already registered!");
                return false;
            }

            String sql = "INSERT INTO admin(adminId, username, firstName, lastName, email, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getAdminId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getPassword());

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Admin registered successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Admin registration failed.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error inserting user: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean loginAdmin(String email, String password) {
        Connection conn = new MySqlConnection().openConnection(); 

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
                return false;
            }

            String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login failed: " + e.getMessage());
            return false;
        }
    }
}
