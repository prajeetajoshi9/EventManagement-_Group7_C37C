/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author sumitshah
 */



import Model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        String query = "SELECT * FROM events";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("event_id"));
                event.setTitle(rs.getString("title"));
                event.setType(rs.getString("type"));
                event.setVenue(rs.getString("venue"));
                event.setDate(rs.getString("date"));
                event.setTime(rs.getString("time"));
                event.setBudget(rs.getDouble("budget"));
                event.setGuests(rs.getInt("guests"));
                event.setPrivacy(rs.getString("privacy"));
                event.setStatus(rs.getString("status"));

                events.add(event);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public boolean updateStatus(int eventId, String newStatus) {
        String query = "UPDATE events SET status = ? WHERE event_id = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, newStatus);
            ps.setInt(2, eventId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}