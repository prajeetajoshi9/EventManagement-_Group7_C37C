/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

public class EventModel {
    private String eventType;
    private String venue;
    private String date;

    public EventModel() {
       
    }

    public EventModel(String eventType, String venue, String date) {
        this.eventType = eventType;
        this.venue = venue;
        this.date = date;
    }

   
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

   
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

   
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
