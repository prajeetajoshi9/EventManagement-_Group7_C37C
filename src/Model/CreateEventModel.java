/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus Zenbook
 */
public class CreateEventModel {
    private String title;
    private String type;
    private String date;
    private String time;
    private String description;
    private int guestCount;
    private double budget;
    private String venue;
    private String privacy;
    private double ticketPrice;

    // Constructor
    public CreateEventModel(String title, String type, String date, String time, String description,
                 int guestCount, double budget, String venue, String privacy, double ticketPrice) {
        this.title = title;
        this.type = type;
        this.date = date;
        this.time = time;
        this.description = description;
        this.guestCount = guestCount;
        this.budget = budget;
        this.venue = venue;
        this.privacy = privacy;
        this.ticketPrice = ticketPrice;
    }

    // Getters
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDescription() { return description; }
    public int getGuestCount() { return guestCount; }
    public double getBudget() { return budget; }
    public String getVenue() { return venue; }
    public String getPrivacy() { return privacy; }
    public double getTicketPrice() { return ticketPrice; }
}



