/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

<<<<<<< HEAD
import Dao.LoginDao;
=======
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
import Dao.User;
import model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.UserData;
import Model.UserModel;
import View.Customer_Login;
import View.Registration_form;
import model.Login;


/**
 *
 * @author digitech
 */
public class logincontroller {

<<<<<<< HEAD
    private final LoginDao loginDao = new LoginDao();
=======
    private final User userdao = new User();
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
    private final Customer_Login userView;

    public logincontroller(Customer_Login userView) {
        this.userView = userView;
        userView.addLoginUserListener(new AddLoginUserListener());
        userView.addAddUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddLoginUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                Login user = new Login(email,password);
                
<<<<<<< HEAD
                boolean check = loginDao.validateUser(user);
                if(check){
                    JOptionPane.showMessageDialog(userView,"Login Successful");
                    
                }else{
                  JOptionPane.showMessageDialog(userView,"Invalid Credentials");  
                }
                
//                UserModel loginUser = userdao.signIn(user);
//                
//                if (loginUser == null) {
//                    JOptionPane.showMessageDialog(userView, "Login Successful");
//                } else {
//                    // success
//                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
//                    Dashboard dashboard = new Dashboard();
//                    dashboard.setVisible(true);
//                    close();
//                }
=======
                UserModel loginUser = userdao.signIn(user);
                
                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                } else {
                    // success
                    JOptionPane.showMessageDialog(userView, "Login Successful");
//                    Dashboard dashboard = new Dashboard();
//                    dashboard.setVisible(true);
//                    close();
                }
>>>>>>> c9ba1214272a4ff36654d35046790f22b457d3c7
            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
    class AddUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Registration_form register = new Registration_form();
            register.setVisible(true);
            SignupController controller = new SignupController(register);
            controller.open();
            
        }
        
    }
}
