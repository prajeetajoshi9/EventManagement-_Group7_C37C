package View;

import Model.TicketBooking;

public class TicketSummaryPage extends javax.swing.JFrame {
    public TicketSummaryPage(TicketBooking ticket) {
        initComponents();

        summaryArea.setText(
            "🎟 Ticket Confirmation\n\n" +
            "Event: " + ticket.getEventName() + "\n" +
            "Booker: " + ticket.getBookerName() + "\n" +
            "ID: " + ticket.getBookerIdNumber() + "\n" +
            "Tickets: " + ticket.getNumberOfTickets() + "\n" +
            "Type: " + ticket.getTicketType() + "\n" +
            "Total Price: Rs " + ticket.getTotalPrice() + "\n" +
            "Payment: " + ticket.getPaymentService() + "\n" +
            "Confirmed: " + (ticket.isConfirmTicket() ? "Yes" : "No")
        );
    }

    // Your initComponents with a JTextArea named summaryArea

    private void initComponents() {
    }
}
