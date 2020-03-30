/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal.Interface;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tramm
 */
public interface ICard
{
   List<String> getCard() throws SQLException;
}
