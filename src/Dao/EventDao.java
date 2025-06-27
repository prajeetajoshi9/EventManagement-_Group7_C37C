/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.EventModel;
import java.util.ArrayList;
import java.util.List;

public class EventDao {

    // Simulated database (static list for testing)
    private static final List<EventModel> events = new ArrayList<>();

    static {
        events.add(new EventModel("Pasni", "Kathmandu", "2025-07-10"));
        events.add(new EventModel("Wedding", "Pokhara", "2025-08-05"));
        events.add(new EventModel("Bratabandha", "Lalitpur", "2025-09-01"));
        events.add(new EventModel("Guniu Cholo", "Bhaktapur", "2025-10-15"));
        events.add(new EventModel("Concert", "Chitwan", "2025-12-20"));
    }

    // ✅ Get all event types
    public List<String> getAllEventTypes() {
        List<String> types = new ArrayList<>();
        for (EventModel e : events) {
            if (!types.contains(e.getEventType())) {
                types.add(e.getEventType());
            }
        }
        return types;
    }

    // ✅ Get all venues
    public List<String> getAllVenues() {
        List<String> venues = new ArrayList<>();
        for (EventModel e : events) {
            if (!venues.contains(e.getVenue())) {
                venues.add(e.getVenue());
            }
        }
        return venues;
    }

    // ✅ Get all events
    public List<EventModel> getAllEvents() {
        return events;
    }

    // ✅ Filtered search
    public List<EventModel> filterEvents(String type, String venue, String date) {
        List<EventModel> filtered = new ArrayList<>();
        for (EventModel e : events) {
            if (e.getEventType().equals(type) &&
                e.getVenue().equals(venue) &&
                e.getDate().equals(date)) {
                filtered.add(e);
            }
        }
        return filtered;
    }
}
