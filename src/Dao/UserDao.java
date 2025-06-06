package Dao;

import Model.OTP;
import Model.User;
import Database.MySqlConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

    MySqlConnection mysql = new MySqlConnection();

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
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
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
}
