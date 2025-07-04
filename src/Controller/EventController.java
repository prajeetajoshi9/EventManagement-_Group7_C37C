/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.SearchEvent;
import Dao.EventDao;

import Model.EventModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

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

        if (view.getDateChooser().getDate() == null) {
            JOptionPane.showMessageDialog(view, "Please select a date.");
            return;
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
} 