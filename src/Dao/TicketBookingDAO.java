/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;

import Model.TicketBooking;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;

/**
 *
 * @author Asus Zenbook
 */
public class TicketBookingDAO {
    private final String jdbcURL = "jdbc:mysql://127.0.0.1:3306/file";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "12345678";

    private static final String INSERT_BOOKING_SQL =
        "INSERT INTO ticket_bookings (event_name, booker_name, booker_id_number, number_of_tickets, ticket_type, total_price, payment_service, confirm_ticket) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean insertBooking(TicketBooking booking) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {

            preparedStatement.setString(1, booking.getEventName());
            preparedStatement.setString(2, booking.getBookerName());
            preparedStatement.setString(3, booking.getBookerIdNumber());
            preparedStatement.setInt(4, booking.getNumberOfTickets());
            preparedStatement.setString(5, booking.getTicketType());
            preparedStatement.setDouble(6, booking.getTotalPrice());
            preparedStatement.setString(7, booking.getPaymentService());
            preparedStatement.setBoolean(8, booking.isConfirmTicket());

//            int rowsInserted = preparedStatement.executeUpdate();
//            return rowsInserted >0;
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
//            printSQLException(e);
//            return false;
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex)
            System.err.println("SQL Error!"+ e);
    }
    
}
