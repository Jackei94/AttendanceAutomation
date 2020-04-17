/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.bll;

import AttendanceAutomation.be.Attendance;
import AttendanceAutomation.be.Card;
import AttendanceAutomation.dal.AttendanceDBDAO;
import AttendanceAutomation.dal.Interface.IAttendanceDao;
import dal.DalException;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class AttendanceManager
{

    private IAttendanceDao attendanceDao;

    /**
     * Constructor for AttendanceManager
     *
     * @throws Exception
     */
    public AttendanceManager() throws Exception
    {
        attendanceDao = (IAttendanceDao) new AttendanceDBDAO();
    }

    /**
     * Sets the attendance for a student
     *
     * @param attendance
     * @param card
     * @throws DalException
     */
    public void setAttendance(Attendance attendance, Card card) throws DalException
    {
        attendanceDao.setAttendance(attendance, card);
    }

    /**
     * Sets the id for a student (To register attendance for)
     *
     * @param card
     * @return
     * @throws DalException
     */
    public int setStudentId(Card card) throws DalException
    {
        return attendanceDao.setStudentId(card);
    }
}
