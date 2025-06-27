package View;

import Dao.AdminEventDAO;
import Model.Event;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class AdminViewEventDetails extends JFrame {

    public AdminViewEventDetails(int eventId) {
        setTitle("Event Details - ID: " + eventId);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea details = new JTextArea();
        details.setEditable(false);
        details.setFont(new Font("Monospaced", Font.PLAIN, 14));
        details.setMargin(new Insets(10, 10, 10, 10));

        // Load data
        Event event = loadEventDetails(eventId);

        if (event != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = event.getDate() != null ? dateFormat.format(event.getDate()) : "Not set";
            
            details.setText(
                "═══════════════════════════════════════════════════════════════\n" +
                "                        EVENT DETAILS                          \n" +
                "═══════════════════════════════════════════════════════════════\n\n" +
                "Event ID:          " + event.getEventId() + "\n" +
                "Title:             " + event.getTitle() + "\n" +
                "Type:              " + event.getType() + "\n" +
                "Date:              " + formattedDate + "\n" +
                "Time:              " + (event.getTime() != null ? event.getTime() : "Not set") + "\n" +
                "Venue:             " + (event.getVenue() != null ? event.getVenue() : "Not set") + "\n" +
                "Description:       " + (event.getDescription() != null ? event.getDescription() : "No description") + "\n" +
                "Number of Guests:  " + event.getGuests() + "\n" +
                "Budget:            NRs. " + String.format("%.2f", event.getBudget()) + "\n" +
                "Ticket Price:      NRs. " + String.format("%.2f", event.getTicketPrice()) + "\n" +
                "Privacy:           " + (event.getPrivacy() != null ? event.getPrivacy() : "Not set") + "\n" +
                "Status:            " + (event.getStatus() != null ? event.getStatus() : "Pending") + "\n\n" +
                "═══════════════════════════════════════════════════════════════\n"
            );
        } else {
            details.setText(
                "═══════════════════════════════════════════════════════════════\n" +
                "                        ERROR                                  \n" +
                "═══════════════════════════════════════════════════════════════\n\n" +
                "Event with ID " + eventId + " was not found in the database.\n\n" +
                "Please check the Event ID and try again.\n" +
                "═══════════════════════════════════════════════════════════════\n"
            );
        }

        JScrollPane scrollPane = new JScrollPane(details);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(scrollPane, BorderLayout.CENTER);
        
        // Add a close button at the bottom
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private Event loadEventDetails(int id) {
        try {
            AdminEventDAO dao = new AdminEventDAO();
            return dao.getEventById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading event details: " + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
}