/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MySqlConnection;
import Model.TicketBooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus Zenbook
 */
public class BookingData {
    MySqlConnection mysql = new MySqlConnection();

    public void saveBookingData(TicketBooking bill) {
        Connection conn = mysql.openConnection();
//        String sql = "INSERT INTO ticket_booking (item, quantity, rate, amount, discount, tax, total, customername) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, bill.getItem());
//            pstmt.setInt(2, bill.getQuantity());
//            pstmt.setDouble(3, bill.getRate());
//            pstmt.setDouble(4, bill.getAmount());
//            pstmt.setDouble(5, bill.getDiscount());
//            pstmt.setDouble(6, bill.getTax());
//            pstmt.setDouble(7, bill.getTotal());
//            pstmt.setString(8, bill.getCustomerName()); 
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    }
    public List<TicketBooking> getDataByBookings(String CustomerName) {
    List<TicketBooking> bookList = new ArrayList<>();
    Connection conn = mysql.openConnection();

    String sql = "SELECT * FROM ticket_booking WHERE booker_name = ?";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, CustomerName);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            TicketBooking book = new TicketBooking(
                rs.getInt("id"),
                rs.getString("event_name"),
                rs.getString("booker_name"),
                rs.getString("booker_id_number"),
                rs.getInt("number_of_tickets"),
                rs.getString("ticket_type"),
                rs.getDouble("total_price"),
                rs.getString("payment_service"),
                rs.getBoolean("confirm_ticket"),
                rs.getDate("booking_date")
            );
            bookList.add(book);
        }
    
    }   catch (java.sql.SQLException ex) {
            Logger.getLogger(BookingData.class.getName()).log(Level.SEVERE, null, ex);
        }
    return bookList;
    }
}
