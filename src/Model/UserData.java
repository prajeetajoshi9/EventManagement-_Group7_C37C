/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class UserData {

    private int id;
    private String adminId;
    private String username;
    private String email;
    private String password;

    public String getAdminId() {
        return adminId;
}

    public void setAdminId(String adminId)  {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
}
