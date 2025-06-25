/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Asus Zenbook
 */
public class DBBookTicketModel {
       private int id;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
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
    private Date bookingDate;
    public Date getBookingDate(){
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate){
        this.bookingDate = bookingDate;
    }
    private String CustomerName;
    public String getCustomerName(){
        return CustomerName;
    }
    public void setCustomerName(String CustomerName){
        this.CustomerName=CustomerName;
    }
    
    public DBBookTicketModel(int id, String eventName, String bookerName, String bookerIdNumber, int numberofTickets, String ticketType, double totalPrice, String paymentService, boolean confirmTicket, Date bookingDate, String CustomerName)
    {
        this.id = id;
    this.eventName = eventName;
    this.bookerName = bookerName;
    this.bookerIdNumber = bookerIdNumber;
    this.numberOfTickets = numberOfTickets;
    this.ticketType = ticketType;
    this.totalPrice = totalPrice;
    this.paymentService = paymentService;
    this.confirmTicket = confirmTicket;
    this.bookingDate = bookingDate;
    this.CustomerName=CustomerName;
    }   
    
}
