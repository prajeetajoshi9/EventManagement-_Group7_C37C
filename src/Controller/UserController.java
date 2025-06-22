package Controller;

import Dao.UserDao;

  
public class UserController {
    private UserDao userDAO = new UserDao();

    public String register(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Boolean isVerified = false;
        // Validate email format
        boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!isValid) {
            return "Enter a valid email";
        }

        // Check if email already exists in the database
        else if (userDAO.isEmailExists(email)) {
            return "Email already in use!";
        }

        // Insert user into the database
        else {
            boolean success = userDAO.registerUser(f_name, s_name, email, admin_username, contact_number, admin_id, admin_address, id_number);
            return success ? "Information added successfully!" : "Failed to record information!";
        }
    } 
    
    
    
} 