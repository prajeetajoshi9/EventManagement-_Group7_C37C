/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JFrame;

/**
 *
 * @author sumitshah
 */
import javax.swing.*;
import java.awt.event.*;

public class EventPlaceSelector extends JFrame {

    public EventPlaceSelector() {
        setTitle("Event Selector");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] events = {
            "Wedding Ceremony",
            "Birthday Bash",
            "Corporate Meetup",
            "Engagement Party",
            "Farewell Program",
            "Anniversary Celebration",
            "Graduation Party",
            "Baby Shower",
            "Reception",
            "Cultural Program"
        };

        JComboBox<String> comboBox = new JComboBox<>(events);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JComboBox combo = (JComboBox) evt.getSource();
                String selectedItem = (String) combo.getSelectedItem();
                String eventPlace = "";

                if (selectedItem.equals("Wedding Ceremony")) {
                    eventPlace = "Solti Grand Party Palace, Kalanki";
                } else if (selectedItem.equals("Birthday Bash")) {
                    eventPlace = "Rudra Banquet & Events, Banasthali";
                } else if (selectedItem.equals("Corporate Meetup")) {
                    eventPlace = "Utsav Banquet, Tripureshwor";
                } else if (selectedItem.equals("Engagement Party")) {
                    eventPlace = "Royal Empire Party Palace, Baneshwor";
                } else if (selectedItem.equals("Farewell Program")) {
                    eventPlace = "Durbar Banquet, Lazimpat";
                } else if (selectedItem.equals("Anniversary Celebration")) {
                    eventPlace = "Subha Griha Banquet, Chabahil";
                } else if (selectedItem.equals("Graduation Party")) {
                    eventPlace = "Golden Palace Banquet, Gwarko";
                } else if (selectedItem.equals("Baby Shower")) {
                    eventPlace = "Paradise Party Venue, Koteshwor";
                } else if (selectedItem.equals("Reception")) {
                    eventPlace = "Everest Party Palace, Gongabu";
                } else if (selectedItem.equals("Cultural Program")) {
                    eventPlace = "Dream Garden Banquet, Bhaktapur";
                } else {
                    eventPlace = "Venue to be announced";
                }

                JOptionPane.showMessageDialog(null, "You selected: " + selectedItem +
                                              "\nEvent Place: " + eventPlace);
            }
        });

        add(comboBox);
    }

    public static void main(String[] args) {
        new EventPlaceSelector().setVisible(true);
    }
}