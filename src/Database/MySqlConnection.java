<<<<<<< HEAD

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*; 

/**
 *   
 * @author prajeetajoshi
 */
public class MySqlConnection implements Database {  

    @Override
    public Connection openConnection() {
        try{
                String username ="root";
                String password ="12345678";
<<<<<<< HEAD
                String database ="file"; 
=======
                String database ="File"; 
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
                Connection connection;
                connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/" + database,username,password 
                ); 
<<<<<<< HEAD
                if (connection ==null ){
=======
                if (connection == null ){ 
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
                    System.out.println("Databse connection fail");
                } else{
                    System.out.println("Databse connection success"); 
                }
                return connection; 
                
        } catch (Exception e){ 
            System.out.println(e);
            return  null;
        }
    } 

    @Override
    public void closeConnection(Connection conn) {
        try{
            if(conn != null && !conn.isClosed()){ 
                conn.close();
                System.out.println("Connection close");
            }
        } catch(Exception e){
            System.out.println(e); 
                    
        }
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) { 
        try{
            Statement stmp = conn.createStatement();
            ResultSet result = stmp.executeQuery(query);
            return result;
            
        } catch(Exception e){ 
            System.out.println(e);
            return null;
        }
        
    }

    @Override
    public int executeUpdate(Connection conn, String query) { 
        try{
            Statement stmp = conn.createStatement();
            int result = stmp.executeUpdate(query);
            return result;
            
        } catch(Exception e){
            System.out.println(e); 
            return -1; 
        
    }
    
    } 
<<<<<<< HEAD
}  
=======
} 
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
