package AttendanceAutomation.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class MainViewController implements Initializable
{

    @FXML
    private Label successOrFailed;
    @FXML
    private Label studentName;
    @FXML
    private ImageView logoImage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        logoImage.setImage(handleImage());
    }    

    @FXML
    private void studentLoginButton(ActionEvent event) throws IOException
    {
        Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/LoginView.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void adminLoginButton(ActionEvent event) throws IOException
    {
        Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/LoginView.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void checkInButton(ActionEvent event)
    {
        
    }
    
    
    private Image handleImage()
    {
       Image logo = new Image("/AttendanceAutomation/images/easvlogo.jpg");
       return logo;
    }
}
