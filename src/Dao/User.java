/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.UserModel;
import Model.Login;
import Model.UserData;


/**
 *
 * @author Asus Zenbook
 */
public class User {

    public static boolean signUp(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   

    MySqlConnection mysql = new MySqlConnection();

    // SIGNUP method returns boolean now
    public boolean signUp(UserModel user) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO users (first_name,last_name,phone_no,email,password,confrim_password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getPhoneNo());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getConfirmPassword());

            pstmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
        
    }

    // LOGIN/VALIDATION method
        public boolean Logincredentials(String username, String password) {
            Connection conn = mysql.openConnection();
            try {
                String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                return rs.next(); // returns true if a record is found
            } catch (Exception e) {
                System.out.println("Sign in error: " + e);
                return false;
            } finally {
                mysql.closeConnection(conn);
            }
        }
        

    // Check if email already exists
    public boolean isEmailExists(String email) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT 1 FROM users WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet result = pstmt.executeQuery();
            return result.next();  // returns true if email is found
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    
    public UserModel signIn(Login login){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where email = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login.getemail());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserModel user= new UserModel(
                    result.getString("first_name"),
                    result.getString("last_name"),    
                    result.getString("phone_no"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("confirm_password")
                );
                user.setId(result.getInt("id"));
                
                return user;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
//    public User signIn(SigninRequest signIn){
//        Connection conn = mysql.openConnection();
//        String sql = "SELECT * FROM users where email = ? and password = ?";
//        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, signIn.getEmail());
//            pstmt.setString(2, signIn.getPassword());
//            ResultSet result = pstmt.executeQuery();
//            if(result.next()){
//                SigninRequest user  = new SigninRequest(
//                    result.getString("email"),
//                    result.getString("password")
//                );
//            
////                user.setId(result.getInt("id"));
//                
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        } finally {
//            mysql.closeConnection(conn);
//        }
//        return null;
//    public static boolean signUp(UserModel user){
//      return true;  
//    }
   


//    private void setId(int aInt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    

    }
}
