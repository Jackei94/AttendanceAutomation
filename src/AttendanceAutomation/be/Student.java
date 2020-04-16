/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import dal.DalException;
import java.util.Date;
import java.util.List;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jacob
 */
public class Student
{
    private int id;
    private String studentName;
    private Date attendance;

    public Student(int id, String studentName, Date attendance)
    {
        this.id = id;
        this.studentName = studentName;
        this.attendance = attendance;
    }
    
    public Student()
    {
        
    }

    public Student(int id, int classId, double twoDecimals)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Student(int id, int classId)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getAttendance()
    {
        return attendance;
    }

    public void setAttendance(Date attendance)
    {
        this.attendance = attendance;
    }

    public void setId(int aInt)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
