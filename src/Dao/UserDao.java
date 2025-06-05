package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.MySqlConnection;
import java.sql.SQLException;


public class UserDao {
    private final MySqlConnection db = new MySqlConnection();
    

    public boolean isEmailExists(String email) {
        Connection conn = db.openConnection();
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // email found
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            db.closeConnection(conn);
        }
    }

    public boolean registerUser(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Connection conn = db.openConnection();
        try {
            String sql = "INSERT INTO admin_details(first_name, last_name, email, admin_username, contact_number, admin_id, admin_address, id_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, f_name);
            ps.setString(2, s_name);
            ps.setString(3, email);
            ps.setString(4, admin_username);
            ps.setString(5, contact_number);
            ps.setString(6, admin_id);
            ps.setString(7, admin_address); 
            ps.setString(8, id_number);
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            db.closeConnection(conn);
        }
    }
    
    // Checks if admin ID exists
public boolean isAdminIdExists(String adminId) {
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE admin_id = ?")) {
        stmt.setString(1, adminId);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
// Update admin information
public boolean updateUser(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
    String sql = "UPDATE admin SET first_name = ?, last_name = ?, email = ?, admin_username = ?, contact_number = ?, address = ?, id_number = ? WHERE admin_id = ?";
    
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, f_name);
        stmt.setString(2, s_name);
        stmt.setString(3, email);
        stmt.setString(4, admin_username);
        stmt.setString(5, contact_number);
        stmt.setString(6, admin_address);
        stmt.setString(7, id_number);
        stmt.setString(8, admin_id);  // WHERE condition
        
        int affectedRows = stmt.executeUpdate();
        return affectedRows > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


} 