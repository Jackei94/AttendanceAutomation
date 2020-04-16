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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class ListViewTeacherController implements Initializable
{

    private static void setItems(List<Student> allStudents)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
    private TextField StudentID;
    
    private double attendance = 50;
    private double abscence = 50;
    
    
    List<Student> studentList;
    
    PieChart attendancePieChart;
    BarChart attendanceBarChart;
    @FXML
    private Button ButtonLogOut;
    


    /**
     * Initializes the controller class.
     */
   @Override
   
    public void initialize(URL url, ResourceBundle rb)
    {
        
       StudentDBDAO StudentDBDAO = null;
       try
       {
           studentModel = new StudentModel();
           StudentDBDAO = new StudentDBDAO();
       } catch (Exception ex)
       {
           Logger.getLogger(ListViewTeacherController.class.getName()).log(Level.SEVERE, null, ex);
       }
        Student test = null;
        try {
            studentList = StudentDBDAO.getAllStudents();
            studentChoice.getItems().clear();
            for (Student stud : studentList)
            {
                System.out.println("");
                System.out.println("Student ID: "+stud.getId());
                System.out.println("Student Name: "+stud.getStudentName());
                System.out.println("Student Attendance: "+stud.getAttendance());
                
                studentChoice.getItems().add(stud.getStudentName());
            }
        studentView.setItems(studentModel.getAllStudents());
        // Sets all cells to their values for student table
        studentAtt.setCellValueFactory(new PropertyValueFactory("Attendance"));
        studentName.setCellValueFactory(new PropertyValueFactory("studentName"));
            
       }
       catch (Exception e)
       {
          
                System.out.println("Failed");
       }
//        updateAttendancePieChart(99);
        
    }


    private void StudentIdSelect(ActionEvent event)
    {
        int id = StudentID.getText().length() - 1;
        System.out.println(id);
//        updateAttendancePieChart(id);
    }
    
//    private void updateAttendancePieChart(int id)
//    {
//        Student student = studentList.get(id);
//        attendance = student.getAttendance();
//        abscence = 100 - attendance;
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("Attendance: " + attendance, attendance),
//                new PieChart.Data("Abscence: " + abscence, abscence)
//        );
//        attendancePieChart = new PieChart(pieChartData);
//        attendancePieChart.setTitle("Attendance");
//        dataChart.setCenter(attendancePieChart);
//    }
//    
   private void LogOutButton(ActionEvent event)
   {
       Stage stage = (Stage) ButtonLogOut.getScene().getWindow();
        stage.close();
   }
}
  
    

