/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal.Interface;

import AttendanceAutomation.be.Card;
import AttendanceAutomation.be.Student;
import dal.DalException;

/**
 *
 * @author Jacob
 */
public interface IStudentDao
{
    public String setStudent(Card card, Student student) throws DalException;
}
