/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.bll;

import AttendanceAutomation.be.Student;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacob
 */
public class StudentManager
{
    private ObservableList allStudents;
   
   public ObservableList<Student> getAllStudents()
    {
        return allStudents;
    }
}

