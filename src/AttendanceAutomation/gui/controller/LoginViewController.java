/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.controller;

import AttendanceAutomation.gui.model.StudentOrTeacher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class LoginViewController implements Initializable
{

    private StudentOrTeacher studentOrTeacher;

    @FXML
    private ImageView logoImage;
    @FXML
    private Label studentOrTeacherLogin;
    @FXML
    private Button loginCancelButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    /**
     * Initialize the controller
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            this.studentOrTeacher = StudentOrTeacher.getInstance();
        } catch (Exception ex)
        {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        logoImage.setImage(handleImage());

        this.studentOrTeacher = studentOrTeacher;
        studentOrTeacherLogin.textProperty().unbind();
        studentOrTeacherLogin.textProperty().bind(studentOrTeacher.studentOrTeacherProperty());
    }

    /**
     * Eventhandler for logging in either as teacher or student
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void loginButtonClicked(MouseEvent event) throws IOException
    {
        if (usernameField.getText().equals("Admin") && passwordField.getText().equals("Admin"))
        {
            JOptionPane.showMessageDialog(null, "Login Succesful");
            Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/ListViewTeacher.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else if (usernameField.getText().equals("Student") && passwordField.getText().equals("Student"))
        {
            JOptionPane.showMessageDialog(null, "Login Succesful");
            Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/ListViewTeacher.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else
        {
            JOptionPane.showMessageDialog(null, "Login Failure");
        }
    }

    /**
     * Handles the shown logo
     *
     * @return
     */
    private Image handleImage()
    {
        Image logo = new Image("/AttendanceAutomation/images/easvlogo.jpg");
        return logo;
    }

    /**
     * Eventhandler for closing the window
     *
     * @param event
     */
    @FXML
    private void cancelButton(ActionEvent event)
    {
        Stage stage = (Stage) loginCancelButton.getScene().getWindow();
        stage.close();
    }

}
