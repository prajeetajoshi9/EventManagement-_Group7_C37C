/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author sumitshah
 */


import Model.Event;
import Dao.EventDAO;
import View.CustomerEditEvent;

import javax.swing.*;

public class CustomerEditEventController {
    private CustomerEditEvent view;
    private EventDAO eventDAO;

    public CustomerEditEventController(CustomerEditEvent view) {
        this.view = view;
        this.eventDAO = new EventDAO();
    }

    public void updateEvent(int eventId) {
        try {
            Event event = new Event();
            event.setId(eventId);
            event.setTitle(view.EventText.getText());
            event.setType(view.TypeText.getText());
            event.setDate(view.jComboBox2.getSelectedItem().toString());
            event.setStartTime(view.TimeText.getSelectedItem().toString());
            event.setEndTime(view.jComboBox3.getSelectedItem().toString());
            event.setDescription(view.DescriptionText.getText());
            event.setGuests(Integer.parseInt(view.GuestText.getText()));
            event.setVenue(view.jComboBox1.getSelectedItem().toString());
            event.setBudget(Double.parseDouble(view.BudgetText.getText()));
            event.setPrivacy(view.jRadioButton1.isSelected() ? "Public" : "Private");
            event.setTicketPrice(Double.parseDouble(view.SetPriceButton.getText().replace("NRs.", "").trim()));

            boolean success = eventDAO.updateEvent(event);
            if (success) {
                JOptionPane.showMessageDialog(view, "Event updated successfully.");
            } else {
                JOptionPane.showMessageDialog(view, "Failed to update event.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }

    public void updateEvent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}