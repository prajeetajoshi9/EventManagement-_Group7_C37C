package Dao;

import Database.DbConnection;
import Model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminEventDAO {

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events ORDER BY event_id";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("event_id"));
                event.setTitle(rs.getString("title"));
                event.setType(rs.getString("type"));
                event.setVenue(rs.getString("venue"));
                event.setDate(rs.getDate("date"));
                event.setTime(rs.getString("time"));
                event.setBudget(rs.getDouble("budget"));
                event.setGuests(rs.getInt("guests"));
                event.setPrivacy(rs.getString("privacy"));
                event.setStatus(rs.getString("status"));
                event.setDescription(rs.getString("description"));
                
                // Handle missing ticket_price column gracefully
                try {
                    event.setTicketPrice(rs.getDouble("ticket_price"));
                } catch (SQLException e) {
                    // If ticket_price column doesn't exist, set default value
                    event.setTicketPrice(0.0);
                }

                events.add(event);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error (getAllEvents): " + e.getMessage());
            e.printStackTrace();
        }

        return events;
    }
    
    public Event getEventById(int eventId) {
        String sql = "SELECT * FROM events WHERE event_id = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("event_id"));
                event.setTitle(rs.getString("title"));
                event.setType(rs.getString("type"));
                event.setVenue(rs.getString("venue"));
                event.setDate(rs.getDate("date"));
                event.setTime(rs.getString("time"));
                event.setBudget(rs.getDouble("budget"));
                event.setGuests(rs.getInt("guests"));
                event.setPrivacy(rs.getString("privacy"));
                event.setStatus(rs.getString("status"));
                event.setDescription(rs.getString("description"));
                
                // Handle missing ticket_price column gracefully
                try {
                    event.setTicketPrice(rs.getDouble("ticket_price"));
                } catch (SQLException e) {
                    // If ticket_price column doesn't exist, set default value
                    event.setTicketPrice(0.0);
                }
                
                return event;
            }
            
        } catch (SQLException e) {
            System.err.println("SQL Error (getEventById): " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean updateEventStatus(int eventId, String status) {
        String sql = "UPDATE events SET status = ? WHERE event_id = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            ps.setInt(2, eventId);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Error (updateEventStatus): " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}