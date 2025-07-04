/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.Login;

/**
 *
 * @author prasmshachapagain
 */

public class UserModel {

    private int id;

    public UserModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

//    public int getId() {
//        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String first_name;

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    private String last_name;

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    private String phone_no;

    public String getPhoneNo() {
        return phone_no;
    }

    public void setPhoneNo(String phone_no) {
        this.phone_no = phone_no;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String confirm_password;

    public String getConfirmPassword() {
        return confirm_password;
    }

    public void setConfirmPassword(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public UserModel(String first_name, String last_name, String phone_no, String email, String password, String confirm_password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public String getFirst_name() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
