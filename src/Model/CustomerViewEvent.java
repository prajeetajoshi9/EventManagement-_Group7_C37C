package Model;

public class CustomerViewEvent {
    private int eventId;
    private String title;
    private String type;
    private String time;
    private String description;
    private int guests;
    private String date;
    private String venue;
    private double budget;
    private String privacy;

    // Constructors
    public CustomerViewEvent() {}

    public CustomerViewEvent(int eventId, String title, String type, String time, String description,
                 int guests, String date, String venue, double budget, String privacy) {
        this.eventId = eventId;
        this.title = title;
        this.type = type;
        this.time = time;
        this.description = description;
        this.guests = guests;
        this.date = date;
        this.venue = venue;
        this.budget = budget;
        this.privacy = privacy;
    }

    // Getters and setters
    // ... (Generate them via IDE or manually add for all fields)

    //public void setVisible(boolean b) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}