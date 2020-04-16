/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Card;
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
import javafx.collections.ObservableList;

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
            
//            while (rs.next())
//            {
//                Student stud = new Student();
//                stud.setName(rs.getString("StudentName"));
//                setStud.add(stud);
//            }
//            return setStud;
            
        } catch (SQLException ex)
        {
            Logger.getLogger(StudentDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new DalException("Can't do it.");
        }
    }
    
     public boolean updateAttendace(double attendance, int studentId) throws SQLException
    {
        try (Connection con = dbCon.getConnection())
        {
            String sql = "UPDATE Student SET attendance = ? WHERE studentId = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, attendance);
            ps.setInt(2, studentId);
            ps.executeUpdate();
            return true;
        }
    }

    
public List<Student> getAllStudents() throws DalException
    {
        ArrayList<Student> allStudents = new ArrayList<>();
        // Attempts to connect to the database.
        try ( Connection con = dbCon.getConnection())
        {
            // SQL code. 
            String sql = "SELECT * FROM Student INNER JOIN StudentAttendances ON Student.studentID = StudentAttendances.studentID;";
            // Create statement.
            Statement statement = con.createStatement();
            // Attempts to execute the statement.
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                // Add all to a list
                Student student = new Student();
                student.setAttendance(rs.getDate("attendance"));
                student.setStudentName(rs.getString("studentName"));

                allStudents.add(student);
            }
            //Return
            return allStudents;

        } catch (SQLException ex)
        {
            Logger.getLogger(StudentDBDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new DalException("Can´t make list");
        }
    }
    }
