/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import java.time.LocalDate;

/**
 *
 * @author Jacob
 */
public class Attendance
{
    private int studentId;
    private LocalDate attendance;

    public Attendance(int studentId, LocalDate attendance)
    {
        this.studentId = studentId;
        this.attendance = attendance;
    }
    
    public Attendance()
    {
        
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public LocalDate getAttendance()
    {
        return attendance;
    }

    public void setAttendance(LocalDate attendance)
    {
        this.attendance = attendance;
    }
    
}
