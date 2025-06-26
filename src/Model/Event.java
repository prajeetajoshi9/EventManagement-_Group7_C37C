package Model;

import java.util.Date;

public class Event {
    private int eventId;
    private String title;
    private String type;
    private String venue;
    private Date date;
    private String time;
    private double budget;
    private int guests;
    private String privacy;
    private String status;
    private String description;

    // Getters and Setters
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public int getGuests() { return guests; }
    public void setGuests(int guests) { this.guests = guests; }

    public String getPrivacy() { return privacy; }
    public void setPrivacy(String privacy) { this.privacy = privacy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}