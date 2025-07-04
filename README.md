# Event Management System

A Java Swing-based Event Management System with ticket booking functionality.

## Features

- **Event Management**: Create, edit, and manage events
- **Ticket Booking**: Book tickets for events with payment options
- **User Management**: Customer and admin user management
- **Database Integration**: MySQL database for data persistence
- **GUI Interface**: User-friendly Java Swing interface

## Prerequisites

- Java JDK 8 or higher
- MySQL Server 5.7 or higher
- NetBeans IDE (recommended) or any Java IDE

## Database Setup

1. **Install MySQL Server** if not already installed
2. **Run the database setup script**:
   ```bash
   mysql -u root -p < database_setup.sql
   ```
   Or copy and paste the contents of `database_setup.sql` into your MySQL client.

3. **Verify the database connection**:
   - Database name: `Event management`
   - Username: `root`
   - Password: `12345678`
   - Host: `localhost`
   - Port: `3306`

## Project Structure

```
src/
├── Controller/          # Business logic controllers
├── Dao/                # Data Access Objects
├── Database/           # Database connection classes
├── Model/              # Data models
└── View/               # GUI forms and views
```

## Key Components

### Models
- `Event.java` - Event data model
- `TicketBooking.java` - Ticket booking data model
- `UserModel.java` - User data model

### DAOs (Data Access Objects)
- `EventDAO.java` - Event database operations
- `TicketBookingDAO.java` - Ticket booking database operations
- `UserDao.java` - User database operations

### Views
- `BookTicketList.java` - Ticket booking form
- `Ticket.java` - Ticket summary display
- `Customerdashboard.java` - Customer main dashboard
- `AdminDashboard.java` - Admin main dashboard

## How to Run

1. **Open the project** in NetBeans IDE
2. **Set up the database** using the provided SQL script
3. **Update database credentials** if needed in the connection classes
4. **Build and run** the project

## Database Tables

### events
- `event_id` (Primary Key)
- `title` - Event title
- `type` - Event type
- `venue` - Event venue
- `date` - Event date
- `time` - Event time
- `budget` - Event budget
- `guests` - Number of guests
- `privacy` - Event privacy setting
- `status` - Event status
- `description` - Event description
- `ticket_price` - Ticket price

### ticket_booking
- `id` (Primary Key)
- `event_name` - Name of the event
- `booker_name` - Name of the person booking
- `booker_id_number` - ID number of the booker
- `number_of_tickets` - Number of tickets booked
- `ticket_type` - Type of ticket
- `total_price` - Total price
- `payment_service` - Payment method used
- `confirm_ticket` - Booking confirmation status
- `booking_date` - Date and time of booking

### users
- `id` (Primary Key)
- `first_name` - User's first name
- `last_name` - User's last name
- `phone_no` - Phone number
- `email` - Email address (unique)
- `password` - Password
- `confirm_password` - Password confirmation

## Ticket Booking Process

1. **Select Event**: Choose an event from the available events
2. **Enter Details**: Fill in booker information
3. **Select Tickets**: Choose number and type of tickets
4. **Payment**: Select payment method (Khalti/Esewa)
5. **Confirmation**: Confirm the booking
6. **Summary**: View ticket summary

## Troubleshooting

### Database Connection Issues
- Verify MySQL server is running
- Check database credentials in connection classes
- Ensure database and tables exist
- Check MySQL JDBC driver is in classpath

### Compilation Issues
- Ensure all required libraries are included
- Check Java version compatibility
- Verify all source files are in correct packages

### Runtime Issues
- Check database connection
- Verify all required tables exist
- Check for null pointer exceptions in logs

## Dependencies

- MySQL Connector/J (mysql-connector-j-9.3.0.jar)
- JCalendar (jcalendar-1.4.jar)
- AbsoluteLayout library

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is for educational purposes.

## Support

For issues and questions, please check the troubleshooting section or create an issue in the repository.

## Sample Data

The database setup script includes sample data:
- Sample events (Tech Conference, Music Festival, Business Workshop)
- Sample user (john.doe@example.com)
- Sample admin (admin@example.com)
- Sample customer (jane.smith@example.com)

You can use these for testing the application functionality. 