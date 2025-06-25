/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author sumitshah
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection1 {

    // Replace these with your actual database details
    private static final String URL = "jdbc:mysql://localhost:3306/eventdb"; // your database name
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = "12345678"; // your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}