/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.EventDAO;
import Model.CreateEventModel;
import View.CreateEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CreateEventController {
    private CreateEvent view;
    private EventDAO dao;

    public CreateEventController(CreateEvent view) {
        this.view = view;
        this.dao = new EventDAO();

        view.getConfirmButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEvent();
            }
        });
    }
    public void open() {
    System.out.println("Controller opened and initialized.");

    // 1. Populate Time ComboBox
//    view.JTextField().time();
//    String[] times = { "09:00:00 AM", "12:00:00 PM", "03:00:00 PM", "06:00:00 PM", "09:00:00 PM" };
//    for (String time : times) {
//        view.getTimeCombo().addItem(time);
//    }
//
//    // 2. Populate Venue ComboBox
//    view.getVenueCombo().removeAllItems();
//    String[] venues = { "Bhrikutimandap", "Hotel Annapurna", "Baneshwor Banquet", "Online Zoom" };
//    for (String venue : venues) {
//        view.getVenueCombo().addItem(venue);
//    }
//
//    // 3. Populate Date ComboBox (You can break it into day/month/year if needed)
//    view.getDateCombo().removeAllItems();
//    String[] dates = { "2025-06-21", "2025-06-22", "2025-06-23", "2025-06-24" };
//    for (String date : dates) {
//        view.getDateCombo().addItem(date);
//    }

    // 4. Set default radio selection (Public)
    view.getPublicRadio().setSelected(true);

    // 5. Set default ticket price text (Optional)
    view.getTicketPriceButton().setText("0.0");
}

    private void createEvent() {
        
        try {
            String title = view.getEventText().getText();
            String type = view.getTypeText().getText();
            String date = view.getDateCombo().getSelectedItem().toString();
            String time = view.getTimeText().getText();
//String inputTime = view.getTimeCombo().getSelectedIndex().
//        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
//SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
//String time = outputFormat.format(inputFormat.parse(inputTime));
//Date date = inputFormat.parse(inputTime);
            String description = view.getDescriptionText().getText();
            int guests = Integer.parseInt(view.getGuestText().getText());
            double budget = Double.parseDouble(view.getBudgetText().getText());
            String venue = view.getVenueCombo().getSelectedItem().toString();
            String privacy = view.getPublicRadio().isSelected() ? "Public" : "Private";
            double price = Double.parseDouble(view.getTicketPriceButton().getText());

            CreateEventModel event = new CreateEventModel(title, type, date, time, description, guests, budget, venue, privacy, price);

            boolean success = dao.saveEvent(event);
            if (success) {
                JOptionPane.showMessageDialog(view, "Event created successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Error saving event.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Invalid input! Please check all fields.");
        }
    }
}