/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sumitshah
 */


import Model.CustomerEdit;
import Database.DBConnectionCustomerEdit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerEditDAO {

    public boolean updateEvent(CustomerEdit event) {
        String sql = "UPDATE events SET title=?, type=?, date=?, start_time=?, end_time=?, description=?, guests=?, venue=?, budget=?, privacy=?, ticket_price=? WHERE id=?";
        try (Connection conn = DBConnectionCustomerEdit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getTitle());
            stmt.setString(2, event.getType());
            stmt.setString(3, event.getDate());
            stmt.setString(4, CustomerEdit.getStartTime());
            stmt.setString(5, event.getEndTime());
            stmt.setString(6, event.getDescription());
            stmt.setInt(7, event.getGuests());
            stmt.setString(8, event.getVenue());
            stmt.setDouble(9, event.getBudget());
            stmt.setString(10, event.getPrivacy());
            stmt.setDouble(11, event.getTicketPrice());
            stmt.setInt(12, event.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public CustomerEdit getEventById(int eventId) {
        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection conn = DBConnectionCustomerEdit.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new CustomerEdit(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("type"),
                    rs.getString("date"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getString("description"),
                    rs.getInt("guests"),
                    rs.getString("venue"),
                    rs.getDouble("budget"),
                    rs.getString("privacy"),
                    rs.getDouble("ticket_price")
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
}