/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

/**
 *
 * @author Java Doctors
 */
public class Card
{
   private int cardID;
   private int loginNO;

   public Card(int id, int login)
   {
      this.cardID = id;
      this.loginNO = login;
   }

   public Card()
   {

   }

   public int getId()
   {
      return cardID;
   }

   public void setId(int id)
   {
      this.cardID = id;
   }

   public int getLoginNO()
   {
      return loginNO;
   }

   public void setLoginNO(int login)
   {
      this.loginNO = login;
   }
   
   
}
