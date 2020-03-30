/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.controller;

import AttendanceAutomation.be.Student;
import AttendanceAutomation.dal.StudentDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Chri9
 */
public class ListViewStudentController implements Initializable
{

    @FXML
    private TableView<Student> studentView;
    @FXML
    private TableColumn<Student, String> studentName;
    @FXML
    private TableColumn<Student, Boolean> studentAtt;
    @FXML
    private ChoiceBox<String> classChoice;
    @FXML
    private ChoiceBox<Integer> dateChoice;
    @FXML
    private ChoiceBox<String> graphChoice;
    @FXML
    private BorderPane dataChart;
    @FXML
    private TextArea studentInfobox;
    private double attendance = 50;
    private double abscence = 50;
    
    StudentDAO studentDAO = new StudentDAO();
    List<Student> studentList;
    
    PieChart attendancePieChart;
    BarChart attendanceBarChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    try {
            studentList = studentDAO.getAllStudents();
            studentInfobox.clear();
            for (Student stud : studentList)
            {
                System.out.println("");
                System.out.println("Student ID: "+stud.getId());
                System.out.println("Student Name: "+stud.getName());
                System.out.println("Student Attendance: "+stud.getAttendance());
            }
            
       }
       catch (Exception e)
       {
          
                System.out.println("Failed");
       }
       
        updateAttendancePieChart(15);
        
    }

private void updateAttendancePieChart(int id)
    {
        Student student = studentList.get(id);
        attendance = student.getAttendance();
        abscence = 100 - attendance;
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Attendance: " + attendance, attendance),
                new PieChart.Data("Abscence: " + abscence, abscence)
        );
        attendancePieChart = new PieChart(pieChartData);
        attendancePieChart.setTitle("Attendance");
        dataChart.setCenter(attendancePieChart);
    }

    private void StudentIdSelect(ActionEvent event)
    {
        int id = studentName.getText().length() - 1;
        System.out.println(id);
        updateAttendancePieChart(id);
    }
        
    
}
