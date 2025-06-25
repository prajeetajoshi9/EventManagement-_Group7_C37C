/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.BookingData;
import Model.DBBookTicketModel;
import Model.TicketBooking;
import View.DBBookTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus Zenbook
 */
public class DBBookingsController {
     
    private final BookingData bookDao = new BookingData();
    private final DBBookTicket bookView;

    public DBBookingsController(DBBookTicket view) {
        this.bookView = view;
        this.bookView.AddSearchListener(new AddListener());
//        view.addLogoutListener(new LogoutListener(view));
//        billView.addOrderListener(new OrderListener());
//        billView.addDashboardListener(new DashboardListener());
    }
     void open() {
       
    }
      void close() {
       
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String bookers_name = bookView.getCustomerNameField().getText().trim();
            if (bookers_name.isEmpty()) {
                bookView.showMessage("Please enter a bookers name.");
                return;
            }

            List<TicketBooking> ticket_booking = bookDao.getDataByBookings(bookers_name);
            if (ticket_booking.isEmpty()) {
                bookView.showMessage("No records found for: " + bookers_name);
                return;
            }

            DefaultTableModel tableModel = (DefaultTableModel) bookView.getDBBookTicketTable().getModel();
            tableModel.setRowCount(0); 

            for (TicketBooking book : ticket_booking) {
                tableModel.addRow(new Object[]{
                    book.getId(),
                    book.getEventName(),
                    book.getBookerName(),
                    book.getNumberOfTickets(),
                    book.getTicketType(),
                    book.getTotalPrice(),
                    book.getPaymentService(),
                    book.isConfirmTicket()
                });
            }
        }
    }
//    public void setupLogoutListener(Bill view) {
//        view.addLogoutListener(new LogoutListener(view));
//    }
//
//    class LogoutListener implements ActionListener {
//        private JFrame currentFrame;
//
//        public LogoutListener(JFrame frame) {
//            this.currentFrame = frame;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Logout button clicked");
//            int confirm = JOptionPane.showConfirmDialog(null,
//                    "Are you sure you want to logout?",
//                    "Logout Confirmation",
//                    JOptionPane.YES_NO_OPTION);
//
//            if (confirm == JOptionPane.YES_OPTION) {
//                currentFrame.dispose(); // Close dashboard
//                new EmployeeSignIn().setVisible(true); 
//            }
//        }
//    }
//    public void setupOrderListener(Bill view) {
//        view.addOrderListener(new OrderListener());
//    }
//     
//    class OrderListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Order button clicked"); 
//            OrderFrame orderView = new OrderFrame();
//            new OrderController(orderView);
//            orderView.setVisible(true);
//
//            if (billView != null) billView.dispose();
//        }
//    }
//    public void setupDashboardListener(Bill view) {
//        view.addDashboardListener(new DashboardListener());
//    }
//     
//    class DashboardListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Dashboard button clicked"); 
//            EmployeeDashboard dashboardView = new EmployeeDashboard();
//            new EDashboardController(dashboardView);
//            dashboardView.setVisible(true);
//            
//            if (billView != null) billView.dispose();
//        }
//    }
//}
//
}

