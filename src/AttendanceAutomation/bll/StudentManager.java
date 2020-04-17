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
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class StudentManager
{

    private IStudentDao studentDao;

    /**
     * Constructor for StudentManager
     *
     * @throws Exception
     */
    public StudentManager() throws Exception
    {
        studentDao = (IStudentDao) new StudentDBDAO();
    }

    /**
     * Sets the shown student
     *
     * @param card
     * @param student
     * @return
     * @throws DalException
     */
    public String setStudent(Card card, Student student) throws DalException
    {
        return studentDao.setStudent(card, student);
    }

    /**
     * Gets all students to a list
     *
     * @return
     * @throws DalException
     */
    public List<Student> getAllStudents() throws DalException
    {
        return studentDao.getAllStudents();
    }

}
