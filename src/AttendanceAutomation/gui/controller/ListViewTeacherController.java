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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


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


    /**
     * Initializes the controller class.
     */
   @Override
   
    public void initialize(URL url, ResourceBundle rb)
    {
       StudentDAO studentDAO = new StudentDAO();
       
       try {
         List<Student> list = studentDAO.getAllStudents();
         
          for (Student stud : list)
          {
             System.out.println(stud.getName());
          }
       
       }
       catch (Exception e)
       {
          
       }
    }    

}
  
    

