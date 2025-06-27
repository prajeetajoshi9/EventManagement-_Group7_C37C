/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author prasmshachapagain
 */

  

import Dao.UserDao;
  
public class UserController {
    private UserDao userDAO = new UserDao();

    public String register(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Boolean isverified = false;
       
        boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!isValid) {
            return "Enter a valid email";
        }

        
        else if (userDAO.isEmailExists(email)) {
            return "Email already in use!";
        }

       
        else {
            boolean success = userDAO.registerUser(f_name, s_name, email, admin_username, contact_number, admin_id, admin_address, id_number);
            return success ? "Information added successfully!" : "Failed to record information!";
        }
    } 
    public String edituser (String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Boolean isverified = false;
  
        boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!isValid) {
            return "Enter a valid email";
        }

       
        else if (userDAO.isEmailExists(email)) {
            return "User not found with this email!";
        }

       
        else {
            boolean success = userDAO.registerUser(f_name, s_name, email, admin_username, contact_number, admin_id, admin_address, id_number);
            return success ? "Information added successfully!" : "Failed to record information!";
        }
    } 
} 

