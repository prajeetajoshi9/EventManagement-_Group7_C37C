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
import Model.Event;
import java.util.Date;

public class EventController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Event management";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "12345678";

    public static boolean createEvent(Event event) {
        String sql = "INSERT INTO events (title, type, time, date, description, guests, budget, venue, privacy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(event.getDate());

            pst.setString(1, event.getTitle());
            pst.setString(2, event.getType());
            pst.setString(3, event.getTime());
            pst.setString(4, formattedDate);
            pst.setString(5, event.getDescription());
            pst.setInt(6, event.getGuests());
            pst.setDouble(7, event.getBudget());
            pst.setString(8, event.getVenue());
            pst.setString(9, event.getPrivacy());

            int result = pst.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving event: " + e.getMessage());
            return false;
        }
    }

    public static boolean createEvent(String title, String type, String time, Date date, String description, int guests, double budget, String venue, String privacy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}