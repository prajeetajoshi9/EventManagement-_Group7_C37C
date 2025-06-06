/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystemproject;
import View.Registration_form;
import Controller.SignupController;
import Controller.SignupController;
import Database.Database;
import Database.MySqlConnection;
import View.Registration_form;

public class EventManagementSystemProject {
     
    public static void main(String[] args) {
     

        // TODO code application logic here
//       Database db=new MySqlConnection();
//       if(db.openConnection()!=null){
//        System.out.print("Database connected successfully!");
//    }else{
//           System.out.print("Failed to connect to database");
//       }
           
//       }  
        Registration_form register = new Registration_form();
        register.setVisible(true);
        SignupController controller = new SignupController(register);
//        SignupController controller = new SignupController(SignUppForm);  
        controller.open();
        }
}

    
 
