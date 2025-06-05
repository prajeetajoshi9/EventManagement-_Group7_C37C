/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystemproject;
import View.Registration_form;
import Controller.SignupController;

public class EventManagementSystemProject {
     
    public static void main(String[] args) {
        
        Registration_form SignUppForm = new Registration_form();                 
        SignupController controller = new SignupController(SignUppForm);  
        controller.open(); 
        }
    }
 
