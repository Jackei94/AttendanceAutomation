/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal.Interface;

import AttendanceAutomation.be.Attendance;
import AttendanceAutomation.be.Card;
import dal.DalException;

/**
 *
 * @author Jacob
 */
public interface IAttendanceDao
{
    public void setAttendance(Attendance attendance, Card card) throws DalException;
    
    public int setStudentId(Card card) throws DalException;
}
