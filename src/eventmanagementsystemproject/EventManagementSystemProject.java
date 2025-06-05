/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystemproject;

import Database.Database;
import Database.MySqlConnection;

/**
 *
 * @author prajeetajoshi
 */
public class EventManagementSystemProject {
     
    public static void main(String[] args) {
        
        Database db = new MySqlConnection();
        if (db.openConnection()!=null) {
            System.out.println("Database connected successfully!");
            } else 
        {
            System.out.println("Failed to connect to database."); 
        } 
    }
    
    
    
} 
