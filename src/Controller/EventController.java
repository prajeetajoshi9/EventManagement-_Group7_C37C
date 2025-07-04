/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author sumitshah
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class EventController {

    // Adjust DB credentials as per your setup
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_db_user";
    private static final String DB_PASS = "your_db_password";

    public static boolean createEvent(
        String title,
        String type,
        String time,
        java.util.Date date,
        String description,
        int guests,
        double budget,
        String venue,
        String privacy
    ) {
        String sql = "INSERT INTO events (title, type, time, date, description, guests, budget, venue, privacy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date);

            pst.setString(1, title);
            pst.setString(2, type);
            pst.setString(3, time);
            pst.setString(4, formattedDate);
            pst.setString(5, description);
            pst.setInt(6, guests);
            pst.setDouble(7, budget);
            pst.setString(8, venue);
            pst.setString(9, privacy);

            int result = pst.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving event: " + e.getMessage());
            return false;
        }
    }
}