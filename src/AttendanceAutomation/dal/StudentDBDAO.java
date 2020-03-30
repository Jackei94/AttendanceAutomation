/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Student;
import dal.DalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    public List<Student> setStudent() throws DalException
    {
        List<Student> setStud = new ArrayList<>();
        try (Connection con = dbCon.getConnection())
        {
            String sql = "Select StudentName From Student JOIN StudentCard ON Student.StudentID = StudentCard.CardID WHERE LoginNO=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery(sql);
           Student student = new Student();
            student.setName(rs.getString("StudentName"));
          
           
            setStud.add(student);
           
            int affected = ps.executeUpdate();
            if (affected < 1)
            {
                throw new DalException("Can't get student");
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(StudentDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new DalException("Can't do it.");
        }
        return setStud;
    }
    
}
