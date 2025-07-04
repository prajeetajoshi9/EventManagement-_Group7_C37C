/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Dao;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prasmshachapagain
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    @Test
    public void test(){
        assertEquals(1+1,2);
    }
    


    /**
     * Test of isEmailExists method, of class UserDao.
     */
    @Test
    public void testIsEmailExists() {
        System.out.println("isEmailExists");
        String email = "";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.isEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class UserDao.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String f_name = "";
        String s_name = "";
        String email = "";
        String admin_username = "";
        String phone_number = "";
        String admin_id = "";
        String admin_address = "";
        String id_number = "";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.registerUser(f_name, s_name, email, admin_username, phone_number, admin_id, admin_address, id_number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateUser method, of class UserDao.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("UpdateUser");
        String f_name = "";
        String s_name = "";
        String email = "";
        String admin_username = "";
        String contact_number = "";
        String admin_id = "";
        String admin_address = "";
        String id_number = "";
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.UpdateUser(f_name, s_name, email, admin_username, contact_number, admin_id, admin_address, id_number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
