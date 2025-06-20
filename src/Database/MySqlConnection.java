/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlConnection {

    // ✅ Fixed getConnection method
    public static Connection getConnection() {
        return new MySqlConnection().openConnection();
    }

    public Connection openConnection() {
        try {
            String username = "root";
            String password = "12345678";
            String database = "admin";

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/" + database, username, password
            );

            if (connection == null) {
                System.out.println("Database connection fail");
            } else {
                System.out.println("Database connection success");
            }

            return connection;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (Exception e) {
            System.out.println("Error closing connection: " + e);
        }
    }

    public static ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Query failed: " + e);
            return null;
        }
    }

    public static int executeUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Update failed: " + e);
            return -1;
        }
    }
}
