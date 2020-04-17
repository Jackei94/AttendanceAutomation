package AttendanceAutomation.gui.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AttendanceAutomation.be.Attendance;
import AttendanceAutomation.be.Card;
import AttendanceAutomation.be.Student;
import AttendanceAutomation.gui.model.AttendanceModel;
import AttendanceAutomation.gui.model.StudentModel;
import AttendanceAutomation.gui.model.StudentOrTeacher;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class MainViewController implements Initializable
{

    private StudentModel studentModel;
    private AttendanceModel attendanceModel;
    private StudentOrTeacher studentOrTeacher;

    @FXML
    private Label successOrFailed;
    @FXML
    private Label studentName;
    @FXML
    private ImageView logoImage;
    @FXML
    private TextField idInputField;

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
            studentModel = StudentModel.getInstance();
            attendanceModel = AttendanceModel.getInstance();
            studentOrTeacher = StudentOrTeacher.getInstance();
        } catch (Exception ex)
        {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        logoImage.setImage(handleImage());
    }

    /**
     * Eventhandler for student login
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void studentLoginButton(ActionEvent event) throws IOException
    {
        this.studentOrTeacher = studentOrTeacher;
        studentOrTeacher.setStudentOrTeacher("Student");

        handleLoginScene();
    }

    /**
     * Eventhandler for teacher login
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void teacherLoginButton(ActionEvent event) throws IOException
    {
        this.studentOrTeacher = studentOrTeacher;
        studentOrTeacher.setStudentOrTeacher("Teacher");

        handleLoginScene();
    }

    /**
     * Handles the login scene
     *
     * @throws IOException
     */
    public void handleLoginScene() throws IOException
    {
        Parent loader = FXMLLoader.load(getClass().getResource("/AttendanceAutomation/gui/view/LoginView.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Eventhandler for the check-in button
     *
     * @param event
     * @throws Exception
     */
    @FXML
    private void checkInButton(ActionEvent event) throws Exception
    {
        handleStudentCard();
        handleAttendance();
    }

    /**
     * Handles the attendance
     *
     * @throws Exception
     */
    private void handleAttendance() throws Exception
    {
        Card card = new Card();
        Card cardId = new Card();
        Attendance attendance = new Attendance();

        card.setLoginNO(Integer.parseInt(idInputField.getText()));
        cardId.setId(attendanceModel.setStudentId(card));
        attendance.setAttendance(LocalDate.now());

        attendanceModel.setAttendance(attendance, cardId);
    }

    /**
     * Handles shown attendee
     *
     * @throws Exception
     */
    private void handleStudentCard() throws Exception
    {
        Card card = new Card();
        Student student = new Student();
        card.setLoginNO(Integer.parseInt(idInputField.getText()));
        studentName.setText(studentModel.setStudent(card, student));

        if (studentModel.setStudent(card, student).equalsIgnoreCase(""))
        {
            successOrFailed.setText("Failed");
        } else
        {
            successOrFailed.setText("Success");
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

}
