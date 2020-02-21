/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.controller;


import AttendanceAutomation.be.Student;
import AttendanceAutomation.bll.StudentManager;
import AttendanceAutomation.dal.StudentDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class ListViewController implements Initializable
{
   

   @FXML
   private TableView<Student> studentView;
   @FXML
   private TableColumn<Student, String> studentName;
   @FXML
   private TableColumn<Student, Boolean> studentAtt;

   private ObservableList<Student> allStudents;
   

    /**
     * Initializes the controller class.
     */
   @Override
   
    public void initialize(URL url, ResourceBundle rb)
    {
       StudentDAO studentDAO = new StudentDAO();
       StudentManager studManager = new StudentManager();
      try
      {
         allStudents = FXCollections.observableArrayList(studentDAO.getAllStudents());
         allStudents = studManager.getAllStudents();
      } catch (Exception ex)
      {
         Logger.getLogger(ListViewController.class.getName()).log(Level.SEVERE, null, ex);
      }
       studentView.setItems(allStudents);
      //studentName.setCellValueFactory(allStudents.get().getName());
       
       
      
//       
//       try {
//         List<Student> list = studentDAO.getAllStudents();
//         
//          for (Student stud : list)
//          {
//             System.out.println(stud.getName());
//          }
//       
//       }
//       catch (Exception e)
//       {
//          
//       }

    }    

}
  
    

