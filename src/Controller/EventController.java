package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Model.Event;
import java.util.Date;

public class EventController {
    private final SearchEvent view;
    private final EventDao dao;

    public EventController(SearchEvent view) {
        this.view = view;
        this.dao = new EventDao();

        loadDropdowns();

        

        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByKeyword();
            }
        });
    }

    private void loadDropdowns() {
        for (String type : dao.getAllEventTypes()) {
            view.getEventTypeCombo().addItem(type);
        }

        for (String venue : dao.getAllVenues()) {
            view.getVenueCombo().addItem(venue);
        }
    }

    private void filterEvents() {
        String type = (String) view.getEventTypeCombo().getSelectedItem();
        String venue = (String) view.getVenueCombo().getSelectedItem();

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(view.getDateChooser().getDate());

        List<EventModel> results = dao.filterEvents(type, venue, date);

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(view, "No matching events found.");
        } else {
            String[][] tableData = new String[results.size()][3];
            for (int i = 0; i < results.size(); i++) {
                EventModel e = results.get(i);
                tableData[i][0] = e.getEventType();
                tableData[i][1] = e.getVenue();
                tableData[i][2] = e.getDate();
            }

            String[] columnNames = {"Event Type", "Venue", "Date"};
            view.getEventTable().setModel(new javax.swing.table.DefaultTableModel(tableData, columnNames));
        }
    }

    private void searchByKeyword() {
        String keyword = view.getSearchField().getText().trim().toLowerCase();

        List<EventModel> matches = dao.getAllEvents().stream()
                .filter(e -> (e.getEventType() + " " + e.getVenue() + " " + e.getDate())
                        .toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        JPanel panel = view.getResultPanel();
        panel.removeAll();

        if (matches.isEmpty()) {
            JLabel noMatch = new JLabel("No events found.");
            panel.add(noMatch);
        } else {
            for (EventModel e : matches) {
                JPanel card = new JPanel();
                card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                card.setLayout(new GridLayout(0, 1));
                card.add(new JLabel("Name: " + e.getEventType()));
                card.add(new JLabel("Venue: " + e.getVenue()));
                card.add(new JLabel("Date: " + e.getDate()));

                JButton detailBtn = new JButton("View Details");
                card.add(detailBtn);
                panel.add(card);
            }
        }

        panel.revalidate();
        panel.repaint();
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
