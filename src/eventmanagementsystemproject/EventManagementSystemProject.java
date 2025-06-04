/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventmanagementsystemproject;

/**
 *
 * @author prajeetajoshi
 */
public class EventManagementSystemProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here

        SignUp signupForm = new SignUp();
        SignupController controller = new SignupController(signupForm);
        controller.open();
    }
}

        // TODO code application logic here
  
    

