package controller;
import Model.TicketBooking;
import Dao.TicketBookingDAO;
import View.Bookmark;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.Ticket;

public class TicketBookingController {
    private Bookmark view;
    private TicketBookingDAO bookingDAO;

    public TicketBookingController(Bookmark view) {
        this.view = view;
       
        this.bookingDAO = new TicketBookingDAO();
        this.view.getBookButton().addActionListener(new BookTicketListener());
    }
public void open(){
    view.setVisible(true);
}
    public String bookTicket(String event, String name, String id, int quantity, String type, double price, String payment, boolean confirm) {
        
//        double price = calculatePrice(type,quantity);
        
        TicketBooking booking = new TicketBooking();
        booking.setEventName(event);
        booking.setBookerName(name);
        booking.setBookerIdNumber(id);
        booking.setNumberOfTickets(quantity);
        booking.setTicketType(type);
        booking.setTotalPrice(price);
        booking.setPaymentService(payment);
        booking.setConfirmTicket(confirm);

        try {
            boolean success = bookingDAO.insertBooking(booking);
            return success ? "Booking successful!" : "Booking failed!";
//            bookingDAO.insertBooking(booking);
//            System.out.println("Booking successful!");
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occured: " + e.getMessage();
        }
    }
    private double calculatePrice(String ticketType, int quantity){
        double pricePerTicket;
        switch(ticketType){
            case "VIP": pricePerTicket = 1000; break;
            case "Regular": pricePerTicket = 500; break;
            default: pricePerTicket = 300;
        }
        return pricePerTicket* quantity;
    }
    class BookTicketListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String event = view.getSelectedEvent();
                String name = view.getBookerName().getText();
                String id = view.getBookerId().getText();
                int quantity = Integer.parseInt(view.getTicketQuantity().getSelectedItem().toString());
                String type = view.getTicketType().getSelectedItem().toString();
                String payment = view.getPaymentMethod().getSelectedItem().toString();
                boolean confirm = view.isConfirmed();
                
                double totalPrice = calculatePrice(type, quantity);
                
                String result = bookTicket(event,name,id,quantity,type,totalPrice,payment,confirm);
                JOptionPane.showMessageDialog(view, result);
                
                if(result.equals("Booking successful!")){
                    new Ticket().setVisible(true);
                    view.dispose();
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(view,"Error: "+ex.getMessage());
            }
//            System.out.println("clicked");
//            JOptionPane.showMessageDialog("Clicked!");
        }
        
    }
}
