-- Event Management System Database Setup
-- Run this script in your MySQL database

-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `Event management`;
USE `Event management`;

-- Create events table
CREATE TABLE IF NOT EXISTS `events` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `venue` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `budget` decimal(10,2) DEFAULT 0.00,
  `guests` int(11) DEFAULT 0,
  `privacy` varchar(50) DEFAULT 'Public',
  `status` varchar(50) DEFAULT 'Pending',
  `description` text,
  `ticket_price` decimal(10,2) DEFAULT 0.00,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create ticket_booking table
CREATE TABLE IF NOT EXISTS `ticket_booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) NOT NULL,
  `booker_name` varchar(255) NOT NULL,
  `booker_id_number` varchar(50) NOT NULL,
  `number_of_tickets` int(11) NOT NULL,
  `ticket_type` varchar(100) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `payment_service` varchar(100) NOT NULL,
  `confirm_ticket` tinyint(1) DEFAULT 0,
  `booking_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create users table
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create admin_details table
CREATE TABLE IF NOT EXISTS `admin_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `admin_username` varchar(100) NOT NULL,
  `contact_number` varchar(20) DEFAULT NULL,
  `admin_id` varchar(50) DEFAULT NULL,
  `admin_address` text,
  `id_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create customer table
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `contact_number` varchar(20) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insert sample data for testing
INSERT INTO `events` (`title`, `type`, `venue`, `date`, `time`, `budget`, `guests`, `privacy`, `status`, `description`, `ticket_price`) VALUES
('Tech Conference 2024', 'Conference', 'Convention Center', '2024-12-15', '9:00 AM', 50000.00, 200, 'Public', 'Approved', 'Annual technology conference featuring industry experts', 500.00),
('Music Festival', 'Concert', 'Central Park', '2024-12-20', '6:00 PM', 75000.00, 500, 'Public', 'Approved', 'Live music festival with multiple artists', 750.00),
('Business Workshop', 'Workshop', 'Business Center', '2024-12-25', '10:00 AM', 15000.00, 50, 'Private', 'Pending', 'Professional development workshop', 300.00);

-- Insert sample user
INSERT INTO `users` (`first_name`, `last_name`, `phone_no`, `email`, `password`, `confirm_password`) VALUES
('John', 'Doe', '1234567890', 'john.doe@example.com', 'password123', 'password123');

-- Insert sample admin
INSERT INTO `admin_details` (`first_name`, `last_name`, `email`, `admin_username`, `contact_number`, `admin_id`, `admin_address`, `id_number`) VALUES
('Admin', 'User', 'admin@example.com', 'admin', '9876543210', 'ADM001', '123 Admin Street', 'ADM123456');

-- Insert sample customer
INSERT INTO `customer` (`first_name`, `last_name`, `contact_number`, `id_number`, `email`, `address`) VALUES
('Jane', 'Smith', '5551234567', 'CUST001', 'jane.smith@example.com', '456 Customer Avenue');

-- Show tables
SHOW TABLES;

-- Show sample data
SELECT 'Events:' as Table_Name;
SELECT * FROM events;

SELECT 'Users:' as Table_Name;
SELECT id, first_name, last_name, email FROM users;

SELECT 'Admin Details:' as Table_Name;
SELECT id, first_name, last_name, email, admin_username FROM admin_details;

SELECT 'Customers:' as Table_Name;
SELECT id, first_name, last_name, email FROM customer; 