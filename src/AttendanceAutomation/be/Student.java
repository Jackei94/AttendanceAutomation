/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import javafx.beans.property.StringProperty;

/**
 *
 * @author Jacob
 */
public class Student
{
    private int id;
    private String studentName;
    private double attendance;

    public Student(int id, String studentName, double attendance)
    {
        this.id = id;
        this.studentName = studentName;
        this.attendance = attendance;
    }
    
    public Student()
    {
        
    }

    public int getId()
    {
        return id;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public double getAttendance()
    {
        return attendance;
    }

    public void setAttendance(double attendance)
    {
        this.attendance = attendance;
    }

}
