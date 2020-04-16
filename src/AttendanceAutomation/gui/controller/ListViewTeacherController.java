/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.controller;

import AttendanceAutomation.be.Student;
import AttendanceAutomation.dal.StudentDBDAO;
import AttendanceAutomation.gui.model.StudentModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class ListViewTeacherController implements Initializable
{
    private StudentModel studentModel;

    @FXML
    private TableView<Student> studentView;
    @FXML
    private TableColumn<Student, String> studentName;
    @FXML
    private TableColumn<Student, Boolean> studentAtt;
    @FXML
    private ChoiceBox<String> classChoice;
    @FXML
    private ChoiceBox<String> studentChoice;
    @FXML
    private ChoiceBox<?> subjectChoice;
    @FXML
    private BorderPane dataChart;

    List<Student> studentList;

    PieChart attendancePieChart;
    BarChart attendanceBarChart;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            studentModel = new StudentModel();
        } catch (Exception ex)
        {
            Logger.getLogger(ListViewTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            studentList = studentModel.getAllStudents();
            studentChoice.getItems().clear();
            boolean first = true;
            for (Student stud : studentList)
            {
                studentChoice.getItems().add(stud.getStudentName());
                if (first == true)
                {
                    first = false;
                }
            }
            studentView.setItems(studentModel.getAllStudents());
            // Sets all cells to their values for student table
            studentAtt.setCellValueFactory(new PropertyValueFactory("Attendance"));
            studentName.setCellValueFactory(new PropertyValueFactory("studentName"));

        } catch (Exception ex)
        {
            Logger.getLogger(ListViewTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleLogoutButton(ActionEvent event)
    {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
}
