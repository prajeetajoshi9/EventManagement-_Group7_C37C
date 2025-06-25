/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.TicketBooking;
import com.mysql.cj.xdevapi.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus Zenbook
 */
public class TicketBookingDAO {
    private MySqlConnection db = new MySqlConnection();
  // In your DAO class: TicketBookingDAO.java

 public boolean saveTicket(TicketBooking ticket) {
     String query = "INSERT INTO ticket_booking (event_name, booker_name, booker_id_number, number_of_tickets, ticket_type, total_price, payment_service, confirm_ticket) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
   
     try (Connection conn = db.openConnection(); 
          PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, ticket.getEventName());
         stmt.setString(2, ticket.getBookerName());
         stmt.setString(3, ticket.getBookerIdNumber());
         stmt.setInt(4, ticket.getNumberOfTickets());
         stmt.setString(5, ticket.getTicketType());
         stmt.setDouble(6, ticket.getTotalPrice());
         stmt.setString(7, ticket.getPaymentService());
         stmt.setBoolean(8, ticket.isConfirmTicket());
        int rows = stmt.executeUpdate();
         return rows > 0;
    }   catch (java.sql.SQLException ex) {
             Logger.getLogger(TicketBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;

  
}





//public int saveTicket(TicketBooking ticket) {
//    String query = "INSERT INTO ticket_booking (event_name, booker_name, booker_id_number, number_of_tickets, ticket_type, total_price, payment_service, confirm_ticket) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//    try (Connection conn = db.openConnection(); 
//         PreparedStatement stmt = conn.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)) {
//
//        stmt.setString(1, ticket.getEventName());
//        stmt.setString(2, ticket.getBookerName());
//        stmt.setString(3, ticket.getBookerIdNumber());
//        stmt.setInt(4, ticket.getNumberOfTickets());
//        stmt.setString(5, ticket.getTicketType());
//        stmt.setDouble(6, ticket.getTotalPrice());
//        stmt.setString(7, ticket.getPaymentService());
//        stmt.setBoolean(8, ticket.isConfirmTicket());
//
//        int rows = stmt.executeUpdate();
//
//        if (rows > 0) {
//            try (java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    return generatedKeys.getInt(1); // return generated ID
//                }
//            }
//        }
//
//    } catch (java.sql.SQLException ex) {
//        Logger.getLogger(TicketBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return -1; // indicate failure
//}

}
