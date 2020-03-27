/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.be;

import javafx.beans.property.StringProperty;

/**
 *
 * @author Jacob
 */
public class Student
{

   
    private int id;
    public static String name;
    public String login;
    

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setLogin(String login)
   {
      this.login = login;
   }
   
   public String getLogin()
   {
     return login;
                   }
   
   public Student(int id, String name, double attendance)
   {
      this.id = id;
      this.name = name;
      this.login = login;
      
   }
    
    
}
