/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.model;

import AttendanceAutomation.be.Card;
import AttendanceAutomation.be.Student;
import AttendanceAutomation.bll.StudentManager;
import dal.DalException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacob
 */
public class StudentModel
{
    private final ObservableList<Student> allStudents;
    private static StudentModel instance;
    private StudentManager studentManager;
    
    public StudentModel() throws Exception
    {
        this.studentManager = new StudentManager();
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(studentManager.getAllStudents());
    }
    
    public static StudentModel getInstance() throws Exception
    {
        if (instance == null)
        {
            instance = new StudentModel();
        }
        return instance;
    }
    
    public String setStudent(Card card, Student student) throws Exception
    {
       return studentManager.setStudent(card, student);
    }
    public ObservableList<Student> getAllStudents() throws DalException
    {
        return allStudents;
    }
    
}
