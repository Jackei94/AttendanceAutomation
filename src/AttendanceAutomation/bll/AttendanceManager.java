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
 * @author Java Doctors
 */
public class AttendanceManager
{
    private IAttendanceDao attendanceDao;
    
    public AttendanceManager() throws Exception
    {
        attendanceDao = (IAttendanceDao) new AttendanceDBDAO();
    }
    
    public void setAttendance(Attendance attendance, Card card) throws DalException
    {
        attendanceDao.setAttendance(attendance, card);
    }
    
    public int setStudentId(Card card) throws DalException
    {
        return attendanceDao.setStudentId(card);
    }
}
