/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import Model.CreateEventModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;

/**
 * DAO class for handling event creation and database interaction.
 */
public class EventDAO {

    MySqlConnection mysql = new MySqlConnection();

    public boolean saveEvent(CreateEventModel event) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO events (title, type, event_date, event_time, description, guest_count, budget, venue, privacy, ticket_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event.getTitle());
            pstmt.setString(2, event.getType());
            pstmt.setString(3, event.getDate());
            pstmt.setString(4, event.getTime());
//String inputTime = model.getTime();
//SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
//SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
//Date date = inputFormat.parse(inputTime);
//String formatttedTime = outputFormat.format(date);
//preparedStatement.setString(4, formattedTime);

            pstmt.setString(5, event.getDescription());
            pstmt.setInt(6, event.getGuestCount());
            pstmt.setDouble(7, event.getBudget());
            pstmt.setString(8, event.getVenue());
            pstmt.setString(9, event.getPrivacy());
            pstmt.setDouble(10, event.getTicketPrice());

            int result = pstmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            mysql.closeConnection(conn);
        }

        
    }
    
//    public boolean insertEvent(CreateEventModel event){
//        Connection conn = mysql.openConnection();
//        String sql = "INSERT INTO events (event_name, event_date, event_location) VALUES (?, ?, ?)";
//
//        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, event.getTitle());
//            pstmt.setString(2, event.getType());
//            pstmt.setString(3, event.getDate());
//            pstmt.setString(4, event.getTime());
//            pstmt.setString(5, event.getVenue());
//            pstmt.setString(6, event.getDescription());
//            pstmt.setInt(7, event.getGuestCount());
//            pstmt.setDouble(8, event.getBudget());
//            pstmt.setString(9, event.getPrivacy());
//            pstmt.setDouble(10, event.getTicketPrice());
//            
//
//            pstmt.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            mysql.closeConnection(conn);
//        }
//    }

public boolean eventExists(String eventName) {
    String query = "SELECT * FROM events WHERE title = ?";
    try (Connection conn = mysql.openConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, eventName);
        ResultSet rs = stmt.executeQuery();
        return rs.next();  // Returns true if an event exists
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    }
