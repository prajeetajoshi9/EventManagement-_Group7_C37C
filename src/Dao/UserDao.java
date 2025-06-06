/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Rashmi Jha
 */

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
    String sql = "UPDATE users SET otp = ?, otp_created_at = NOW() WHERE email = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, otp.getCode());
        ps.setString(2, otp.getEmail());

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated == 0) {
            return false; 
        }
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        mysql.closeConnection(conn);
    }
    return false;
}


    
    public boolean verifyOTP(OTP otp){
        Connection conn = mysql.openConnection();
        String sql = "SELECT otp FROM users WHERE email = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, otp.getEmail());
            ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        return otp.getCode().equals(rs.getString("otp"));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    
    public boolean resetPassword(User user){
       Connection conn = mysql.openConnection();
       String sql = "UPDATE users SET password = ?, otp = NULL WHERE email= ?";
       try(PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, user.getPassword());
           ps.setString(2, user.getEmail());
           ps.executeUpdate();
           return true;
       } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           mysql.closeConnection(conn);
       }
        return false;   
    }
    
    public Timestamp otpCreatedAt(OTP otp){
        Connection conn = mysql.openConnection();
        String sql = "SELECT otp_created_at FROM users WHERE email = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, otp.getEmail());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getTimestamp("otp_created_at");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}

