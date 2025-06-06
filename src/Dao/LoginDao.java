/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;

/**
 *
 * @author Asus Zenbook
 */
public class LoginDao {
    MySqlConnection mysql = new MySqlConnection();
    public boolean validateUser(Login userLogin){
       Connection conn = mysql.openConnection();
       String sql = "SELECT * FROM users where email=? and password=?";
       try(PreparedStatement pstmt = conn.prepareStatement(sql)){
           
           System.out.println("Login email"+ userLogin.getemail());
           System.out.println("Login Password"+ userLogin.getPassword());
           
            pstmt.setString(1,userLogin.getemail());
            pstmt.setString(2,userLogin.getPassword());
            
            ResultSet result = pstmt.executeQuery();
            return result.next();
        }catch(Exception e){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    }

