/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class EventModel {
    private String eventType;
    private String venue;
    private String date;

    public EventModel() {
        // Default constructor
    }

    public EventModel(String eventType, String venue, String date) {
        this.eventType = eventType;
        this.venue = venue;
        this.date = date;
    }

    // Getter and Setter for Event Type
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    // Getter and Setter for Venue
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    // Getter and Setter for Date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
