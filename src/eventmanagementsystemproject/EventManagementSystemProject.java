/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystemproject;

import View.Registration_form;
import View.CreateEventForm;
import Controller.CreateEventController;

public class EventManagementSystemProject {

    public static void main(String[] args) {
        // Display Registration Form
        Registration_form signUpForm = new Registration_form();                 
        signUpForm.setVisible(true); // Shows the form window

        // (Optional) If you want to directly use CreateEventController:
        // CreateEventForm createEventForm = new CreateEventForm();
        // CreateEventController controller = new CreateEventController(createEventForm);
        // controller.open();
    }
} 