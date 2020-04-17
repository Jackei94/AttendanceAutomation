/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.bll;

import AttendanceAutomation.be.Card;
import AttendanceAutomation.be.Student;
import AttendanceAutomation.dal.Interface.IStudentDao;
import AttendanceAutomation.dal.StudentDBDAO;
import dal.DalException;
import java.util.List;

/**
 *
 * @author Java Doctors
 */
public class StudentManager
{
    private IStudentDao studentDao;
    
    public StudentManager() throws Exception
    {
        studentDao = (IStudentDao) new StudentDBDAO();
    }
    
    public String setStudent(Card card, Student student) throws DalException
    {
        return studentDao.setStudent(card, student);
    }
    
    public List<Student> getAllStudents() throws DalException
    {
        return studentDao.getAllStudents();
    }
    
        
}


