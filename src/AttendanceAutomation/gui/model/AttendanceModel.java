/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.gui.model;

import AttendanceAutomation.be.Attendance;
import AttendanceAutomation.be.Card;
import AttendanceAutomation.bll.AttendanceManager;

/**
 *
 * @author Java Doctors
 */
public class AttendanceModel
{
    private static AttendanceModel instance;
    private AttendanceManager attendanceManager;
    
    public AttendanceModel() throws Exception
    {
        this.attendanceManager = new AttendanceManager();
    }
    
    public static AttendanceModel getInstance() throws Exception
    {
        if (instance == null)
        {
            instance = new AttendanceModel();
        }
        return instance;
    }
    
    public void setAttendance(Attendance attendance, Card card) throws Exception
    {
       attendanceManager.setAttendance(attendance, card);
    }
    
    public int setStudentId(Card card) throws Exception
    {
        return attendanceManager.setStudentId(card);
    }
}
