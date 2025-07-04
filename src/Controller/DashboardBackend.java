/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author sumitshah
 */




import View.*;

public class DashboardBackend {

    // Handle personal information redirection
    public void openPersonalInformation(javax.swing.JFrame currentFrame) {
        System.out.println("Opening Personal Information");
        CustomerPersonalInformation personalInfo = new CustomerPersonalInformation();
        personalInfo.setVisible(true);
        currentFrame.dispose();
    }

    // Handle Create Event
    public void openCreateEvent(javax.swing.JFrame currentFrame) {
        System.out.println("Opening Create Event");
        CreateEvent controller = null;
        CreateEvent createEvent = new CreateEvent(controller);
        createEvent.setVisible(true);
        currentFrame.dispose();
    }

    // Handle Search Event
    public void searchEvent(String keyword) {
        System.out.println("Searching events with keyword: " + keyword);
        // Placeholder for search logic
    }

    // Handle View Events
    public void viewEvents() {
        System.out.println("Displaying all events");
        // Placeholder for event view logic
    }

    // Handle Edit Event
    public void editEvent(int eventId) {
        System.out.println("Editing event ID: " + eventId);
        // Placeholder for editing logic
    }

    // Handle Delete Event
    public void deleteEvent(int eventId) {
        System.out.println("Deleting event ID: " + eventId);
        // Placeholder for deletion logic
    }

    // Handle Book Ticket
    public void bookTicket(int eventId, int customerId) {
        System.out.println("Booking ticket for event " + eventId + " by customer " + customerId);
        // Placeholder for booking logic
    }

    // Handle Ticket Details
    public void getTicketDetails(int customerId) {
        System.out.println("Fetching ticket details for customer ID: " + customerId);
        // Placeholder for ticket detail logic
    }

    // Handle Payment Info
    public void showPaymentInfo(int customerId) {
        System.out.println("Showing payment info for customer ID: " + customerId);
        // Placeholder for payment logic
    }

    // Handle sign out
    public void signOut(javax.swing.JFrame currentFrame) {
        System.out.println("Signing out user");
        Customer_Login loginPage = new Customer_Login();
        loginPage.setVisible(true);
        currentFrame.dispose();
    }
}
