/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Student;
import dal.DalException;
import java.util.List;

/**
 *
 * @author Jacob
 */
public interface IStudentDao
{
    List<Student> setStudent() throws DalException;
}
