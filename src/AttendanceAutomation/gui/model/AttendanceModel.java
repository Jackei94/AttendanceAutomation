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
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class AttendanceModel
{

    private static AttendanceModel instance;
    private AttendanceManager attendanceManager;

    /**
     * Constructor for AttendanceModel
     *
     * @throws Exception
     */
    public AttendanceModel() throws Exception
    {
        this.attendanceManager = new AttendanceManager();
    }

    /**
     * Gets the instance for the model
     *
     * @return
     * @throws Exception
     */
    public static AttendanceModel getInstance() throws Exception
    {
        if (instance == null)
        {
            instance = new AttendanceModel();
        }
        return instance;
    }

    /**
     * Sets the attendance for a student
     *
     * @param attendance
     * @param card
     * @throws Exception
     */
    public void setAttendance(Attendance attendance, Card card) throws Exception
    {
        attendanceManager.setAttendance(attendance, card);
    }

    /**
     * Sets the id for a student (To register attendance for)
     *
     * @param card
     * @return
     * @throws Exception
     */
    public int setStudentId(Card card) throws Exception
    {
        return attendanceManager.setStudentId(card);
    }
}
