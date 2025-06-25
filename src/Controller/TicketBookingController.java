package controller;
import Model.TicketBooking;
import Dao.TicketBookingDAO;
import Dao.EventDAO;
import View.BookTicketList;

import View.Bookmark;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.Ticket;

public class TicketBookingController{
//    private Bookmark view;
    private TicketBookingDAO ticketDAO;
    private BookTicketList view;
    private EventDAO eventDAO;

    public TicketBookingController(BookTicketList view) {
        this.view = view;
       this.eventDAO = new EventDAO();
        this.ticketDAO = new TicketBookingDAO();
//        this.view.getBookButton().addActionListener(new BookTicketListener());
initController();
    }
public void open(){
    view.setVisible(true);
}
private void initController(){
    String eventName = view.getEventNameField().getText().trim();
    if(eventName.isEmpty()){
        JOptionPane.showMessageDialog(view,"Please enter an event name.");
        return;
    }
    if(!eventDAO.eventExists(eventName)){
        JOptionPane.showMessageDialog(view, "Event not found in the database");
        return;
    }
    TicketBooking ticket= new TicketBooking();
    
        ticket.setEventName(eventName);
        ticket.setBookerName(view.getBookerNameField().getText());
        ticket.setBookerIdNumber(view.getBookerIdField().getText());
        ticket.setNumberOfTickets(Integer.parseInt(view.getNumTicketsField().getText()));
        ticket.setTotalPrice(Double.parseDouble(view.getTotalPriceField().getText()));
        ticket.setPaymentService((String) view.getPaymentMethodCombo().getSelectedItem());
        ticket.setTicketType(view.getTicketTypeField().getText());
        ticket.setConfirmTicket(view.getYesRadioButton().isSelected());

//       int generatedId = ticketDAO.saveTicket(ticket);
//if (generatedId != -1) {
//    ticket.setId(generatedId); // Save the ID to use in Ticket.java
//
//    JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
//    Ticket summary = new Ticket(ticket); // Pass ticket object with ID
//    summary.setVisible(true);
//} else {
//    JOptionPane.showMessageDialog(null, "Error saving ticket. Try again.");
//}
boolean saved = ticketDAO.saveTicket(ticket);

 if (saved) {
     JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
    
     // Optional: Show ticket summary form
     Ticket summary = new Ticket(ticket);
     summary.setVisible(true);
//    this.dispose(); // close current window
 } else {
     JOptionPane.showMessageDialog(null, "Error saving ticket. Try again.");
 }

    }
}

//    public String bookTicket(String event, String name, String id, int quantity, String type, double price, String payment, boolean confirm) {
//        
////        double price = calculatePrice(type,quantity);
//        
//        TicketBooking booking = new TicketBooking();
//        booking.setEventName(event);
//        booking.setBookerName(name);
//        booking.setBookerIdNumber(id);
//        booking.setNumberOfTickets(quantity);
//        booking.setTicketType(type);
//        booking.setTotalPrice(price);
//        booking.setPaymentService(payment);
//        booking.setConfirmTicket(confirm);
//
//        try {
//            boolean success = ticketDAO.insertBooking(booking);
//            return success ? "Booking successful!" : "Booking failed!";
////            bookingDAO.insertBooking(booking);
////            System.out.println("Booking successful!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "An error occured: " + e.getMessage();
//        }
//    }
//    private double calculatePrice(String ticketType, int quantity){
//        double pricePerTicket;
//        switch(ticketType){
//            case "VIP": pricePerTicket = 1000; break;
//            case "Regular": pricePerTicket = 500; break;
//            default: pricePerTicket = 300;
//        }
//        return pricePerTicket* quantity;
//    }
//    class BookTicketListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try{
//                String event = view.getSelectedEvent();
//                String name = view.getBookerName().getText();
//                String id = view.getBookerId().getText();
//                int quantity = Integer.parseInt(view.getTicketQuantity().getSelectedItem().toString());
//                String type = view.getTicketType().getSelectedItem().toString();
//                String payment = view.getPaymentMethod().getSelectedItem().toString();
//                boolean confirm = view.isConfirmed();
//                
//                double totalPrice = calculatePrice(type, quantity);
//                
//                String result = bookTicket(event,name,id,quantity,type,totalPrice,payment,confirm);
//                JOptionPane.showMessageDialog(view, result);
//                
//                if(result.equals("Booking successful!")){
//                    new Ticket().setVisible(true);
//                    view.dispose();
//                }
//            }catch (Exception ex){
//                JOptionPane.showMessageDialog(view,"Error: "+ex.getMessage());
//            }
////            System.out.println("clicked");
////            JOptionPane.showMessageDialog("Clicked!");
//        }
//        
//    }
//}
//
