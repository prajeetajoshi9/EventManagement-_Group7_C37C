<<<<<<< HEAD
package Controller;

//import Controller.SignupController.AddUserListener.signUp.LoginUserListener;
=======

package Controller;

>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
import Dao.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.UserModel;
import View.Customer_Login;
import View.Registration_form;

public class SignupController {
    private final User userdao = new User();
    private final Registration_form userView;

    public SignupController(Registration_form userView) {
        this.userView = userView;
        userView.addAddUserListener(new AddUserListener());
<<<<<<< HEAD
        userView.addLoginListener(new LoginListener()); 
=======
        userView.addLoginListener(new AddLoginListener()); 
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
        
    
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
            User userdao = new User();
=======
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
            try {
                String first_name = userView.getFirstNameField().getText();
                String last_name = userView.getLastNameField().getText();
                String phone_no = userView.getPhoneNoField().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                String confirm_password = userView.getConfirmPasswordField().getText();
<<<<<<< HEAD
                
                UserModel usermodel = new UserModel(first_name,last_name,phone_no,email, password, confirm_password);
                
                boolean check = userdao.CheckUser(usermodel);
                if(check){
                    JOptionPane.showMessageDialog(userView,"User already exists");
                }else if (!email.contains("@")){
                    JOptionPane.showMessageDialog(userView,"Enter a valid Email");
                }else if (!password.equals (confirm_password)){
                    JOptionPane.showMessageDialog(userView,"Password doesn't match");
                }else{
                    userdao.User(usermodel);
                    JOptionPane.showMessageDialog(null, "Registration success");
                    
                    Customer_Login login = new Customer_Login();
                    login.setVisible(true);
                    logincontroller loginuser= new logincontroller(login);
                    loginuser.open();
//                    Customer_Login login = new Customer_Login;
//                    login.setVisible(true);
                    
                    
//                    userView.dispose();
                }
                
                

                // Call the signUp method
//                signUp(first_name, last_name, phone_no, email, password, confirm_password);
=======

                // Call the signUp method
                signUp(first_name, last_name, phone_no, email, password, confirm_password);
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        }

<<<<<<< HEAD
//        public boolean signUp(String first_name, String last_name, String phone_no, String email, String password, String confirm_password) {
//            if (first_name==null || first_name.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "First Name cannot be empty.");
//                return false;
//            }
//            
//             if (last_name==null || last_name.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Last Name cannot be empty.");
//                return false;
//            }
//             
//             if (phone_no==null || phone_no.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Phone_no cannot be empty.");
//                return false;
//            }
//
//            if (email == null || email.trim().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Email cannot be empty.");
//                return false;
//            }
//
//            if (password == null || password.trim().isEmpty() || password.equals("Set Password")) {
//                JOptionPane.showMessageDialog(null, "Please enter a valid password.");
//                return false;
//            }
//
//            if (!password.equals(confirm_password)) {
//                JOptionPane.showMessageDialog(null, "Confirm password didn't match!");
//                return false;
//            }
//         
////            if (userdao.isEmailExists(email)){
////                JOptionPane.showMessageDialog(null, "Email already in use!");
////                return false;
////            }
//
////            UserModel user = new UserModel(first_name, last_name, phone_no, email, password, confirm_password);
////            boolean success = userdao.signUp(user);
////
////            if (success) {
////                JOptionPane.showMessageDialog(null, "User signed up failed!");
////                
////                Customer_Login loginView = new Customer_Login();
////                loginView.setVisible(true);
////                Customer_Login userloginform= new Customer_Login();
////                logincontroller Controller= new logincontroller(userloginform);
////                Controller.open();
////                close();
//                // You can open a new view or redirect here if needed
////            } else {
////                JOptionPane.showMessageDialog(null, "Signup success!");
////                Customer_Login loginView = new Customer_Login();
////                loginView.setVisible(true);
////                Customer_Login userloginform= new Customer_Login();
////                logincontroller Controller= new logincontroller(userloginform);
////                Controller.open();
////                close();
////            }
//
////            return success;
////        }
////    }
//        }
    }


    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        Customer_Login loginView = new Customer_Login();
        loginView.setVisible(true);
        logincontroller login = new logincontroller(loginView);  
        login.open();
        
    
}
    }
}
    
    
    
   
        
=======
        public boolean signUp(String first_name, String last_name, String phone_no, String email, String password, String confirm_password) {
            if (first_name==null || first_name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "First Name cannot be empty.");
                return false;
            }
            
             if (last_name==null || last_name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Last Name cannot be empty.");
                return false;
            }
             
             if (phone_no==null || phone_no.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone_no cannot be empty.");
                return false;
            }

            if (email == null || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email cannot be empty.");
                return false;
            }

            if (password == null || password.trim().isEmpty() || password.equals("Set Password")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid password.");
                return false;
            }

            if (!password.equals(confirm_password)) {
                JOptionPane.showMessageDialog(null, "Confirm password didn't match!");
                return false;
            }
         
            if (userdao.isEmailExists(email)){
                JOptionPane.showMessageDialog(null, "Email already in use!");
                return false;
            }

            UserModel user = new UserModel(first_name, last_name, phone_no, email, password, confirm_password);
            boolean success = userdao.signUp(user);

            if (success) {
                JOptionPane.showMessageDialog(null, "User signed up failed!");
                
//                Customer_Login loginView = new Customer_Login();
//                loginView.setVisible(true);
//                Customer_Login userloginform= new Customer_Login();
//                logincontroller Controller= new logincontroller(userloginform);
//                Controller.open();
//                close();
                // You can open a new view or redirect here if needed
            } else {
                JOptionPane.showMessageDialog(null, "Signup success!");
                Customer_Login loginView = new Customer_Login();
                loginView.setVisible(true);
                Customer_Login userloginform= new Customer_Login();
                logincontroller Controller= new logincontroller(userloginform);
                Controller.open();
                close();
            }

            return success;
        }
    }
    class AddLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        Customer_Login loginView = new Customer_Login();                 
        logincontroller login = new logincontroller(loginView);  
        
        login.open();
        close();
        
    }
}
   
        
    }
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
