/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sumitshah
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/event_db", "root", "12345678");
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}