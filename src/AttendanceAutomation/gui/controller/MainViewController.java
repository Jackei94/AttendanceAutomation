package AttendanceAutomation.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AttendanceAutomation.be.Student;
import AttendanceAutomation.gui.model.StudentModel;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class MainViewController implements Initializable
{
    
    private StudentModel studentModel;
    private StudentOrTeacher studentOrTeacher;

    @FXML
    private Label successOrFailed;
    @FXML
    private Label studentName;
    @FXML
    private ImageView logoImage;
    @FXML
    private TextField idInputField;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            studentModel = StudentModel.getInstance();
            studentOrTeacher = StudentOrTeacher.getInstance();
        } catch (Exception ex)
        {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        logoImage.setImage(handleImage());
    }

    @FXML
    private void studentLoginButton(ActionEvent event) throws IOException
    {
        this.studentOrTeacher = studentOrTeacher;
        studentOrTeacher.setStudentOrTeacher("Student");

        handleLoginScene();
    }

    @FXML
    private void teacherLoginButton(ActionEvent event) throws IOException
    {
        this.studentOrTeacher = studentOrTeacher;
        studentOrTeacher.setStudentOrTeacher("Teacher");

        handleLoginScene();
    }

    public void handleLoginScene() throws IOException
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
//        if (idInputField.equals(setStudent()));
////        int id = Integer.parseInt(input);
////        if (id == 123456)
//        {
//            try {
//                studentName.setText(studentModel.setStudent().toString());
//                successOrFailed.setText("Success");
//            } catch (Exception ex) {
//                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else
//        {
//            studentName.setText("");
//            successOrFailed.setText("Failed");
//        }
    }

    private Image handleImage()
    {
        Image logo = new Image("/AttendanceAutomation/images/easvlogo.jpg");
        return logo;
    }

}
