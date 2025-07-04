/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sumitshah
 */


public class Customer {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String identificationNumber;
    private String email;
    private String address;

    public Customer(String firstName, String lastName, String contactNumber, String identificationNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.address = address;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getContactNumber() { return contactNumber; }
    public String getIdentificationNumber() { return identificationNumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
}