package Controller;

import Dao.UserDao;
  
public class UserController {
    private UserDao userDAO = new UserDao();

    public String register(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
        Boolean isverified = false;
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
    
    
    public String updateAdminInfo(String f_name, String s_name, String email, String admin_username, String contact_number, String admin_id, String admin_address, String id_number) {
    // Validate email
    boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    if (!isValid) {
        return "Enter a valid email";
    }

    // Check if the user with this ID exists (optional safety check)
    if (!userDAO.isAdminIdExists(admin_id)) {
        return "Admin ID does not exist!";
    }

    // Update in the database
    boolean success = userDAO.updateUser(f_name, s_name, email, admin_username, contact_number, admin_id, admin_address, id_number);
    return success ? "Information updated successfully!" : "Failed to update information!";
}

} 