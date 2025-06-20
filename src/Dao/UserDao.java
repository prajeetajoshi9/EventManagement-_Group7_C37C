package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Database.MySqlConnection;


public class UserDao {
    private final MySqlConnection db = new MySqlConnection();
    

    public boolean isEmailExists(String email) {
        Connection conn = db.openConnection();
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            db.closeConnection(conn);
        }
    }

    public boolean registerUser(String f_name, String s_name, String email, String admin_username, String phone_number, String admin_id, String admin_address, String id_number) {
        Connection conn = db.openConnection();
        try {
            String sql = "INSERT INTO admin_details(first_name, last_name, email, admin_username, phone_number, admin_id,  id_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, f_name);
            ps.setString(2, s_name);
            ps.setString(3, email);
            ps.setString(4, admin_username);
            ps.setString(5, phone_number);
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
    public boolean UpdateUser(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Connection conn = db.openConnection();
        try {
            String sql = "UPDATE admin_details SET first_name=?, last_name=?, admin_username=?, contact_number=?, admin_id=?, admin_address=?, id_number=? WHERE email =?";
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
}