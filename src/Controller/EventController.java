package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Model.Event;
import java.util.Date;

public class EventController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Event management";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "12345678";

    public static boolean createEvent(Event event) {
        String sql = "INSERT INTO events (title, type, time, date, description, guests, budget, venue, privacy, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Ensure date is not null
            Date eventDate = event.getDate();
            if (eventDate == null) {
                JOptionPane.showMessageDialog(null, "Event date is missing.");
                return false;
            }

            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(eventDate);

            pst.setString(1, event.getTitle());
            pst.setString(2, event.getType());
            pst.setString(3, event.getTime());
            pst.setString(4, formattedDate);
            pst.setString(5, event.getDescription());
            pst.setInt(6, event.getGuests());
            pst.setDouble(7, event.getBudget());
            pst.setString(8, event.getVenue());
            pst.setString(9, event.getPrivacy());
            pst.setString(10, event.getStatus()); // Save status like "Pending"

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving event: " + e.getMessage());
            return false;
        }
    }

    public static boolean createEvent(String title, String type, String time, Date date, String description, int guests, double budget, String venue, String privacy) {
        if (date == null) {
            JOptionPane.showMessageDialog(null, "Please select a valid date.");
            return false;
        }

        Event event = new Event();
        event.setTitle(title);
        event.setType(type);
        event.setTime(time);
        event.setDate(date); // Store as java.util.Date in Event
        event.setDescription(description);
        event.setGuests(guests);
        event.setBudget(budget);
        event.setVenue(venue);
        event.setPrivacy(privacy);
        event.setStatus("Pending"); // Default

        return createEvent(event);
    }
}