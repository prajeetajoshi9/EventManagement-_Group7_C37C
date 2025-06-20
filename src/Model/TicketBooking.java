/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus Zenbook
 */
public class TicketBooking {
    private String eventName;
    public String getEventName() {
        return eventName;
    }
    private String bookerName;
    public String getBookerName() {
        return bookerName;
    }
    private String bookerIdNumber;
    public String getBookerIdNumber() {
        return bookerIdNumber;
    }
    private int numberOfTickets;
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    private String ticketType;
    public String getTicketType() {
        return ticketType;
    }
    private double totalPrice;
    public double getTotalPrice() {
        return totalPrice;
    }
    private String paymentService;
    public String getPaymentService() {
        return paymentService;
    }
    private boolean confirmTicket;
  
    public boolean isConfirmTicket() {
        return confirmTicket;
    }
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public void setBookerName(String bookerName){
        this.bookerName = bookerName;
    }
    public void setBookerIdNumber(String bookerIdNumber){
        this.bookerIdNumber = bookerIdNumber;
    }
    public void setNumberOfTicket(int numberOfTickets){
        this.numberOfTickets = numberOfTickets;
    }
    public void setTicketType(String ticketType){
        this.ticketType = ticketType;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    public void setPaymentService(String paymentService){
        this.paymentService = paymentService;
    }
    public void setConfirmTicket(boolean confirmTicket){
        this.confirmTicket= confirmTicket;
    }
    
    
}
