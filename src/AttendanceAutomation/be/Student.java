/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import java.util.Date;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class Student
{

    private int id;
    private String studentName;
    private Date attendance;

    /**
     * Getter for id
     *
     * @return
     */
    public int getId()
    {
        return id;
    }

    /**
     * Getter for studentName
     *
     * @return
     */
    public String getStudentName()
    {
        return studentName;
    }

    /**
     * Setter for studentName
     *
     * @param studentName
     */
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    /**
     * Getter for attendance
     *
     * @return
     */
    public Date getAttendance()
    {
        return attendance;
    }

    /**
     * Setter for attendance
     *
     * @param attendance
     */
    public void setAttendance(Date attendance)
    {
        this.attendance = attendance;
    }

}
