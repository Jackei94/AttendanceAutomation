/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Card;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Tramm
 */
public class CardDBDAO
{
   private final DatabaseConnector dbCon;


public CardDBDAO() throws Exception
{
dbCon = new DatabaseConnector();

}

public List<String> getCard() throws SQLException
{
   List<String> getCard = new ArrayList();
   try ( Connection con = dbCon.getConnection())
   {
      PreparedStatement pstmt
              = con.prepareStatement("SELECT LoginNO FROM StudentCard WHERE CardID =? INNER JOIN Student ON StudentName WHERE StudentID = CardID");
      
      
      
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next())
      {
        
       getCard.add(rs.getString("CardID"));
       
      }
      }catch (SQLException ex)
              {
      
      Logger.getLogger(CardDBDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
   
   return getCard;
   
      
}

}