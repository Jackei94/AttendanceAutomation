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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class ListViewTeacherController implements Initializable
{
   

   @FXML
   private TableView<Student> studentView;
   @FXML
   private TableColumn<Student, String> studentName;
   @FXML
   private TableColumn<Student, Boolean> studentAtt;
    @FXML
    private ChoiceBox<?> classChoice;
    @FXML
    private ChoiceBox<?> studentChoice;
    @FXML
    private ChoiceBox<?> subjectChoice;
    @FXML
    private BorderPane dataChart;


    /**
     * Initializes the controller class.
     */
   @Override
   
    public void initialize(URL url, ResourceBundle rb)
    {
        StudentDAO studentDAO = new StudentDAO();
        Student test = null;
        try {
            List<Student> list = studentDAO.getAllStudents();
            System.out.println(list);
            
            for (Student stud : list)
            {
                System.out.println("Student ID: "+stud.getId());
                System.out.println("Student Name: "+stud.getName());
                System.out.println("Student Attendance: "+stud.getAttendance());
                test = stud;
            }
            
       }
       catch (Exception e)
       {
          
                System.out.println("Failed");
       }
       
        double attendance = test.getAttendance();
        double abscence = 100 - attendance;
       
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Attendance: " + attendance, attendance),
                new PieChart.Data("Abscence: " + abscence, abscence)
        );
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Imported Fruits");
        dataChart.setCenter(pieChart);
    }    

}
  
    

