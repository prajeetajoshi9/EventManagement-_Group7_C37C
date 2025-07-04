/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sumitshah
 */


public class CustomerEdit {

    public static String getStartTime() {
        return "10:00 AM"; // Default start time
    }
    private int id;
    private String title;
    private String type;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private int guests;
    private String venue;
    private double budget;
    private String privacy;
    private double ticketPrice;

    // Constructors, Getters and Setters
    public CustomerEdit() {}

    public CustomerEdit(int id, String title, String type, String date, String startTime, String endTime,
                 String description, int guests, String venue, double budget, String privacy, double ticketPrice) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.guests = guests;
        this.venue = venue;
        this.budget = budget;
        this.privacy = privacy;
        this.ticketPrice = ticketPrice;
    }

    // Add getters and setters here...

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public int getGuests() {
        return guests;
    }

    public String getVenue() {
        return venue;
    }

    public String getPrivacy() {
        return privacy;
    }

    public double getBudget() {
        return budget;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getId() {
        return id;
    }

    // Add setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
}