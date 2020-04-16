/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.dal.Interface.IStudentDao;
import AttendanceAutomation.be.Card;
import AttendanceAutomation.be.Student;
import dal.DalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Tramm
 */
public class StudentDBDAO implements IStudentDao
{
    private final DatabaseConnector dbCon;
    
    public StudentDBDAO() throws Exception
    {
        dbCon = new DatabaseConnector();
    }

    @Override
    public String setStudent(Card card, Student student) throws DalException
    {
        StringBuilder stud = new StringBuilder();
        try (Connection con = dbCon.getConnection())
        {
            String sql = "SELECT StudentName FROM Student JOIN StudentCard ON Student.StudentID = StudentCard.CardID WHERE LoginNO=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            int studentNo = card.getLoginNO(); 
            ps.setInt(1, studentNo);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                stud.append(rs.getString("studentName"));
            }
            return stud.toString();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(StudentDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new DalException("Can't do it.");
        }
    }
    
}
