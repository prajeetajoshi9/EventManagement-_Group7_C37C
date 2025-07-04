package Dao;

import Model.OTP;
import Model.User;
import Database.MySqlConnection;
import Model.UserModel;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

    MySqlConnection mysql = new MySqlConnection();

    public UserDao() {
        
    }

    public boolean generateOTP(OTP otp) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO password_reset (email, code, created_at) VALUES (?, ?, now()) ";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, otp.getEmail());
            ps.setString(2, otp.getCode());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public boolean verifyOTP(OTP otp) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM password_reset WHERE email = ? AND code = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, otp.getEmail().trim());
            ps.setString(2, otp.getCode().trim());

            System.out.println("Verifying OTP for email: " + otp.getEmail() + ", code: " + otp.getCode());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("OTP match found.");
                return true;
            } else {
                System.out.println("No matching OTP found.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public boolean resetPassword(User user) {
        Connection conn = mysql.openConnection();
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        String sql = "UPDATE users SET password = ? WHERE email= ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
            deletePasswordResetOtp(user);
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
     
    /**
     *
     * @param f_name
     * @param s_name
     * @param email
     * @param admin_username
     * @param phone_number
     * @param admin_id
     * @param admin_address
     * @param id_number
     * @return
     */
    public boolean registerUser(String f_name, String s_name, String email, String admin_username, String phone_number, String admin_id, String admin_address, String id_number) {
        Connection conn = mysql.openConnection();
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
            mysql.closeConnection(conn);
        }
       
    }

    public Timestamp otpCreatedAt(OTP otp) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT created_at FROM password_reset WHERE email = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, otp.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("created_at");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public boolean deletePasswordResetOtp(User user) {
        Connection conn = mysql.openConnection();
        String sql = "Delete from password_reset WHERE email = ? ";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public boolean isEmailExists(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean registerAdminUser(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
         MySqlConnection mysql = new MySqlConnection();
        Connection conn = mysql.openConnection();
        
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
            mysql.closeConnection(conn);
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


    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checkUser(UserModel usermodel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UserDao(UserModel usermodel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
} 
