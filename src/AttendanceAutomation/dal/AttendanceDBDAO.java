/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Attendance;
import AttendanceAutomation.be.Card;
import AttendanceAutomation.dal.Interface.IAttendanceDao;
import dal.DalException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian, Jacob, Jonas & Mikkel
 */
public class AttendanceDBDAO implements IAttendanceDao
{

    private final DatabaseConnector dbCon;
    private final LocalDate currentDate;

    /**
     * Constructor for AttendanceDBDAO
     *
     * @throws Exception
     */
    public AttendanceDBDAO() throws Exception
    {
        dbCon = new DatabaseConnector();
        currentDate = LocalDate.now();
    }

    /**
     * Sets the attendance for a student
     *
     * @param attendance
     * @param card
     * @throws DalException
     */
    @Override
    public void setAttendance(Attendance attendance, Card card) throws DalException
    {
        try ( Connection con = dbCon.getConnection())
        {
            String sql = "INSERT INTO Attendance(studentID, attendance) VALUES (?,?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, card.getId());
            ps.setDate(2, Date.valueOf(currentDate));

            int affectedRows = ps.executeUpdate();
            if (affectedRows < 1)
            {

                throw new DalException("Can't register attendance");
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                attendance.setStudentId(rs.getInt(1));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(AttendanceDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the id for a student (To register attendance for)
     *
     * @param card
     * @return
     * @throws DalException
     */
    @Override
    public int setStudentId(Card card) throws DalException
    {
        try ( Connection con = dbCon.getConnection())
        {
            StringBuilder stud = new StringBuilder();
            String sql = "SELECT cardID FROM StudentCard WHERE LoginNO=?";
            PreparedStatement ps = con.prepareStatement(sql);

            int studentNo = card.getLoginNO();
            ps.setInt(1, studentNo);

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                stud.append(rs.getInt("cardID"));
            }
            return Integer.parseInt(stud.toString());

        } catch (SQLException ex)
        {
            Logger.getLogger(StudentDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new DalException("Can't do it.");
        }
    }

}
