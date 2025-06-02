/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;




public class Adminregister {
    private String adminId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public Adminregister(String adminId, String username, String firstName, String lastName, String email, String phone, String password) {
        this.adminId = adminId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters
    public String getAdminId() { return adminId; }
    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
}


/**
 *
 * @author prasmshachapagain
 */

 