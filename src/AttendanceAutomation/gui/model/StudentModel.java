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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class StudentModel
{

    private final ObservableList<Student> allStudents;
    private static StudentModel instance;
    private StudentManager studentManager;

    /**
     * Constructor for StudentModel
     *
     * @throws Exception
     */
    public StudentModel() throws Exception
    {
        this.studentManager = new StudentManager();
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(studentManager.getAllStudents());
    }

    /**
     * Gets the instance of the model
     *
     * @return
     * @throws Exception
     */
    public static StudentModel getInstance() throws Exception
    {
        if (instance == null)
        {
            instance = new StudentModel();
        }
        return instance;
    }

    /**
     * Sets the shown student
     *
     * @param card
     * @param student
     * @return
     * @throws Exception
     */
    public String setStudent(Card card, Student student) throws Exception
    {
        return studentManager.setStudent(card, student);
    }

    /**
     * Gets all students to a list
     *
     * @return
     * @throws DalException
     */
    public ObservableList<Student> getAllStudents() throws DalException
    {
        return allStudents;
    }

}
