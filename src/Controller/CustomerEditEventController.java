package Controller;

import Dao.CustomerEditEventControllerDAO;
import Model.Event;
import View.CustomerEditEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CustomerEditEventController {

    private CustomerEditEvent view;
    private CustomerEditEventControllerDAO dao;

    public CustomerEditEventController(CustomerEditEvent view) {
        this.view = view;
        this.dao = new CustomerEditEventControllerDAO();

    ((JButton) this.view.getUpdateButton()).addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        updateEvent();
    }
});
    }

    private void updateEvent() {
        try {
            // Validate form data first
            if (!view.validateForm()) {
                return; // Stop if validation fails
            }
            
            Event event = new Event();

            // Extract values from the view and set them to the Event object
            event.setEventId(view.getEventId());
            event.setTitle(view.getTitleText());
            event.setType(view.getTypeSelection());
            event.setVenue(view.getVenueSelection());
            event.setDate(view.getSelectedDate());
            event.setTime(view.getSelectedTime());
            event.setBudget(Double.parseDouble(view.getBudgetText()));
            event.setGuests(Integer.parseInt(view.getGuestsText()));
            event.setPrivacy(view.getPrivacySelection());
            event.setStatus(view.getStatusSelection()); // Optional: or default to "Pending"
            event.setDescription(view.getDescriptionText());
            event.setTicketPrice(Double.parseDouble(view.getTicketPriceText()));

            boolean success = dao.updateEvent(event);

            if (success) {
                view.showMessage("Event updated successfully!");
                // Optionally return to dashboard or clear form
                int choice = JOptionPane.showConfirmDialog(view, 
                    "Event updated successfully! Would you like to return to the dashboard?", 
                    "Success", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    view.dispose();
                    new View.Customerdashboard().setVisible(true);
                }
            } else {
                view.showMessage("Failed to update event. Please try again.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            view.showMessage("Error: " + ex.getMessage());
        }
    }
}