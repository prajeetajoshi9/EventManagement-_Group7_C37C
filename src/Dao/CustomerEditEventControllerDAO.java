package Dao;

import Model.Event;
import Database.DbConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerEditEventControllerDAO {

    public boolean updateEvent(Event event) {
        // First check if ticket_price column exists
        boolean hasTicketPriceColumn = checkIfColumnExists("ticket_price");
        
        String sql;
        if (hasTicketPriceColumn) {
            sql = "UPDATE events SET title=?, type=?, venue=?, date=?, time=?, budget=?, guests=?, privacy=?, status=?, description=?, ticket_price=? WHERE event_id=?";
        } else {
            sql = "UPDATE events SET title=?, type=?, venue=?, date=?, time=?, budget=?, guests=?, privacy=?, status=?, description=? WHERE event_id=?";
        }

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, event.getTitle());
            ps.setString(2, event.getType());
            ps.setString(3, event.getVenue());

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(event.getDate().getTime());
            ps.setDate(4, sqlDate);

            ps.setString(5, event.getTime());
            ps.setDouble(6, event.getBudget());
            ps.setInt(7, event.getGuests());
            ps.setString(8, event.getPrivacy());
            ps.setString(9, event.getStatus() != null ? event.getStatus() : "Pending");
            ps.setString(10, event.getDescription());
            
            if (hasTicketPriceColumn) {
                ps.setDouble(11, event.getTicketPrice());
                ps.setInt(12, event.getEventId());
            } else {
                ps.setInt(11, event.getEventId());
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("SQL Error (updateEvent): " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
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
        }

        return events;
    }

    public Event getEventById(int eventId) {
        String query = "SELECT * FROM events WHERE event_id = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
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

    // Helper method to check if a column exists in the events table
    private boolean checkIfColumnExists(String columnName) {
        String query = "SHOW COLUMNS FROM events LIKE ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, columnName);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // Returns true if column exists
            
        } catch (SQLException e) {
            System.err.println("Error checking column existence: " + e.getMessage());
            return false;
        }
    }
}