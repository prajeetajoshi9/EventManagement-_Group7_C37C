/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author sumitshah
 */
import Dao.Customer;

public class CustomerController {

    public void saveCustomer(Customer customer) {
        // For now, just simulate saving data
        System.out.println("=== Customer Information Saved ===");
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());
        System.out.println("Contact: " + customer.getContactNumber());
        System.out.println("ID Number: " + customer.getIdentificationNumber());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Address: " + customer.getAddress());
    }

    public void updateCustomer(Customer customer) {
        // Simulate updating customer info
        System.out.println("Customer information updated successfully.");
    }
}