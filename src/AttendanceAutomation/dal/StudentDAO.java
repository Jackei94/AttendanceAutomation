/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttendanceAutomation.dal;

import AttendanceAutomation.be.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob
 */
public class StudentDAO
{
     private static final String USER_SOURCE = "data/student.txt";

    /**
     * Gets a list of all known students.
     *
     * @return List of students.
     */
    
    public List<Student> getAllStudents() throws Exception
    {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(USER_SOURCE))))
        {
            ArrayList<Student> allStudents = new ArrayList<>();

            while (true)
            {
                String aLineOfText = br.readLine();
                if (aLineOfText == null)
                {
                    break;
                } else if (!aLineOfText.isEmpty())
                {
                    //read one line
                    try
                    {
                        String[] arrStudent = aLineOfText.split(",");
                        int id = Integer.parseInt(arrStudent[0].trim()); //Jeg læser ID'et.
                        String name = arrStudent[1].trim(); //Jeg læser årstal.
                        double attendance = Double.parseDouble(arrStudent[2].trim());
                        // Add if commas in title, includes the rest of the string:
                        for (int i = 3; i < arrStudent.length; i++) //Loop will only run if the array has a length of 3+
                        {
                            name += "," + arrStudent[i];
                        }
                        Student stu = new Student(id, name, attendance);
                        allStudents.add(stu);
                    } catch (Exception e)
                    {
                       e.printStackTrace();
                        //Skip row
                    }
                        
                    
                }
            } 
            
            return allStudents;
            
        }
        catch (Exception e)
        {
           e.printStackTrace();
           throw new Exception("Could not acces User file");
           
        }
        
        
    }
}

       
        
          
        
           
        
        
        
        
    
 

