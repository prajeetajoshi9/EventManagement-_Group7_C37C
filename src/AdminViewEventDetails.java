/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Event;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sumitshah
 */
public class AdminViewEventDetails extends JFrame {

    public AdminViewEventDetails(int eventId) {
        setTitle("Event Details");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Example UI
        JTextArea details = new JTextArea();
        details.setEditable(false);

        // Load data (replace with your method)
        Event event = loadEventDetails(eventId);

        details.setText(event.getVenue() + "\n" + event.getName() + "ID: " + event.getId() + "\n" +
                "Name: " +
                "Date: " + event.getDate() + "\n" +
                        "Venue: "
        );

        add(new JScrollPane(details));
    }

    private Event loadEventDetails(int id) {
        // Your method to get event details from DB or list
        return EventDatabase.getEventById(id); // example placeholder
    }

    private static class EventDatabase {

        private static Event getEventById() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static Event getEventById(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public EventDatabase() {
        }
    }
}