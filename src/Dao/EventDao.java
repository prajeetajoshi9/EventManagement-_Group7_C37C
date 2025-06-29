/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rashmi Jha
 */
public class EventDao {

    MySqlConnection mysql = new MySqlConnection();
    
   

    public boolean deleteEvent(int eventId,String Reason, String Feedback) {
        Connection conn = mysql.openConnection();
     
        System.out.println(eventId);
         String sql = "UPDATE events SET reason_for_deletion = ?, feedback = ?, deleted_at = ? WHERE id= ?";
         

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,Reason);
            ps.setString(2,Feedback);
           
            LocalDateTime now =LocalDateTime.now();
            ps.setObject(3, now);
            ps.setInt(4, eventId);
           

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Model.User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

}
