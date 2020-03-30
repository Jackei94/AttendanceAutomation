/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.bll;

import AttendanceAutomation.dal.CardDBDAO;
import AttendanceAutomation.dal.Interface.ICard;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tramm
 */
public class CardManager
{
        
        private ICard iCard;
        
        public CardManager() throws Exception
                {
iCard = (ICard) new CardDBDAO();
}

   public List<String> getCard() throws Exception
   {
      return iCard.getCard();
   }
}
