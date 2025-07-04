package Dao;

import Model.Event;
import Database.DbConnection;
import java.sql.*;

public class CustomerViewEventDAO {

    public Event getEventById(int eventId) {
        Event event = null;
        String query = "SELECT * FROM events WHERE event_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                event = new Event();
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }
    
    public java.util.List<Event> getAllEvents() {
        java.util.List<Event> events = new java.util.ArrayList<>();
        String query = "SELECT * FROM events ORDER BY event_id";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

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
            e.printStackTrace();
        }

        return events;
    }
    //public void setVisible(boolean visible) {
    //throw new UnsupportedOperationException("Not supported yet.");
//}
    

}