/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import java.time.LocalDate;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class Attendance
{

    private int studentId;
    private LocalDate attendance;

    /**
     * Getter for studentId
     *
     * @return
     */
    public int getStudentId()
    {
        return studentId;
    }

    /**
     * Setter for studentId
     *
     * @param studentId
     */
    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    /**
     * Getter for attendance
     *
     * @return
     */
    public LocalDate getAttendance()
    {
        return attendance;
    }

    /**
     * Setter for attendance
     *
     * @param attendance
     */
    public void setAttendance(LocalDate attendance)
    {
        this.attendance = attendance;
    }

}
