/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.controller;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;



/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class LoginViewController implements Initializable
{

    @FXML
    private ImageView logoImage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private javafx.scene.control.TextField usernameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        logoImage.setImage(handleImage());
    }    

//    @FXML
//    private void loginButton(ActionEvent event) throws IOException
//    {
//        Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/ListView.fxml"));
//        Scene scene = new Scene(loader);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    }
    
    private Image handleImage()
    {
       Image logo = new Image("/AttendanceAutomation/images/easvlogo.jpg");
       return logo;
    }

    @FXML
    private void LoginButtonClicked(MouseEvent event) throws IOException
    {
    //    String ext = new String(passwordField.getPassword());
        if(usernameField.getText().equals("Admin") && passwordField.getText().equals("Admin"))
    {
        JOptionPane.showMessageDialog(null,"Login Succesful");
        Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/ListView.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    else
    {
        JOptionPane.showMessageDialog(null,"Login Failure");
    }
    }

    
}
