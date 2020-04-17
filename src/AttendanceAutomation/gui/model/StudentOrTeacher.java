/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.model;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class StudentOrTeacher
{

    private static StudentOrTeacher instance;
    private final SimpleStringProperty studentOrTeacher;

    /**
     * Constructor for StudentOrTeacher
     */
    public StudentOrTeacher()
    {
        this.studentOrTeacher = new SimpleStringProperty();
    }

    /**
     * Gets the instance for StudentOrTeacher
     *
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static StudentOrTeacher getInstance() throws IOException, Exception
    {
        if (instance == null)
        {
            instance = new StudentOrTeacher();
        }
        return instance;
    }

    /**
     * Returns StringProperty of StudentOrTeacher
     *
     * @return
     */
    public StringProperty studentOrTeacherProperty()
    {
        return studentOrTeacher;
    }

    /**
     * Sets the StringProperty of studentOrTeacherProperty
     *
     * @param newOrEdit
     */
    public void setStudentOrTeacher(String studentOrTeacher)
    {
        studentOrTeacherProperty().set(studentOrTeacher);
    }

    /**
     * Returns the studentOrTeacherProperty with the get() method
     *
     * @return
     */
    public final String getStudentOrTeacher()
    {
        return studentOrTeacherProperty().get();
    }
}
