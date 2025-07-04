
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Login;

import Database.MySqlConnection;
import java.sql.SQLException;


public class User {

    public Login AdminLogin(String username, String password) {
        MySqlConnection mysql = new MySqlConnection();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                Login user = new Login();
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Login failed: " + e);
        } finally {
            mysql.closeConnection(conn);
        }

        return null;
    }
}
    