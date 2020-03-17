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
 * @author Jacob
 */
public class StudentOrTeacher
{
    private static StudentOrTeacher instance;
    private final SimpleStringProperty studentOrTeacher;

    public StudentOrTeacher()
    {
        this.studentOrTeacher = new SimpleStringProperty();
    }
    
    public static StudentOrTeacher getInstance() throws IOException, Exception
    {
        if (instance == null)
        {
            instance = new StudentOrTeacher();
        }
        return instance;
    }
    
    public StringProperty studentOrTeacherProperty()
    {
        return studentOrTeacher;
    }

    /**
     * Sets the newOrEdit stringproperty.
     *
     * @param newOrEdit
     */
    public void setStudentOrTeacher(String newOrEdit)
    {
        studentOrTeacherProperty().set(newOrEdit);
    }

    /**
     * Returns newOrEditProperty with the get() method.
     *
     * @return
     */
    public final String getStudentOrTeacher()
    {
        return studentOrTeacherProperty().get();
    }
}
