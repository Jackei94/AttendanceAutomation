/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

/**
 *
 * @author Tramm
 */
public class Card
{
   private int id;
   private int login;

   public Card(int id, int login)
   {
      this.id = id;
      this.login = login;
   }

   public Card()
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public int getLogin()
   {
      return login;
   }

   public void setLogin(int login)
   {
      this.login = login;
   }
   
   
}
