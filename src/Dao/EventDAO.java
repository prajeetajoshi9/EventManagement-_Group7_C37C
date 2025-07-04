package Dao;

import Model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Database.DbConnection;

public class EventDAO {

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

                // Convert SQL date to java.util.Date
                java.sql.Date sqlDate = rs.getDate("date");
                event.setDate(new java.util.Date(sqlDate.getTime()));

                event.setTime(rs.getString("time"));
                event.setBudget(rs.getDouble("budget"));
                event.setGuests(rs.getInt("guests"));
                event.setPrivacy(rs.getString("privacy"));
                event.setStatus(rs.getString("status"));
                event.setDescription(rs.getString("description")); // ✅ Description support

                events.add(event);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return events;
    }

    public boolean updateStatus(int eventId, String newStatus) {
        String query = "UPDATE events SET status = ? WHERE event_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, newStatus);
            ps.setInt(2, eventId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("SQL Error (updateStatus): " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Event getEventById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Checks if an event exists by name in the database
     * @param eventName The name of the event to check
     * @return true if event exists, false otherwise
     */
    public boolean eventExists(String eventName) {
        String query = "SELECT COUNT(*) FROM events WHERE title = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, eventName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("SQL Error (eventExists): " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
}