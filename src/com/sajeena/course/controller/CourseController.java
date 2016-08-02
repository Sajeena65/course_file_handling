/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.course.controller;

import com.sajeena.course.dao.CourseDAO;
import com.sajeena.course.dao.EnquiryDAO;
import com.sajeena.course.entity.Course;
import com.sajeena.course.entity.Enquiry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class CourseController {
     CourseDAO coursedao;
    EnquiryDAO enquirydao;
    

    public CourseController(CourseDAO coursedao, EnquiryDAO enquirydao) {
        this.coursedao = coursedao;
        this.enquirydao = enquirydao;
    }
    
     public void process() throws IOException
    {
        
        course();
        System.out.println("*********************");
       
        enquiry();
    }
    
    
     private void course() throws FileNotFoundException, IOException
    {
        
        try ( 
            BufferedReader bufferedReader=new BufferedReader(new FileReader("C:/Users/Admin/Desktop/course.csv")))
                {
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                Course c = new Course();
                String[] tokens=line.split(",");
                c.setId(Integer.parseInt(tokens[0]));
                c.setCoursename(tokens[1]);
                c.setPrice(Double.parseDouble(tokens[2]));
                
                coursedao.insert(c);
                if (!coursedao.insert(c)) {
                    System.out.println("Cannot Insert into Course array.");
                }
                
                
            }
            
            bufferedReader.close();
        }
    }
    
    private void enquiry() throws FileNotFoundException, IOException
    {
         System.out.println("Reading enquiry.csv..");
         
        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/enquiry.csv"))) {
            BufferedWriter errorwriter =new BufferedWriter(new FileWriter("C:/Users/Admin/Desktop/error.csv"));
         BufferedWriter outputwriter =new BufferedWriter(new FileWriter("C:/Users/Admin/Desktop/output.csv"));
            String line1="";
            while((line1=bufferedReader1.readLine())!=null)
            {
                String[] tokens1=line1.split(",");
                Enquiry en = new Enquiry();
                if(enquirydao.searchByemail(tokens1[4])||(!coursedao.searchById(Integer.parseInt(tokens1[1]))))
                {
                    writeToErrorFile(tokens1,errorwriter);
                }
                else{
                    
                    en.setStudentId(Integer.parseInt(tokens1[0]));
                    en.setCourseId(Integer.parseInt(tokens1[1]));
                    en.setFirstname(tokens1[2]);
                    en.setLastname(tokens1[3]);
                    en.setEmail(tokens1[4]);
                    
                    enquirydao.insert(en);
                    
                    writeToOutputFile(en,outputwriter);
                    
                    if (!enquirydao.insert(en)) {
                        System.out.println("Cannot Insert into Enquiry array.");
                    }
                }
                
            }
              errorwriter.close();
              outputwriter.close();
              bufferedReader1.close();
            
        }
         
        
        
    }
    
    private void writeToErrorFile(String[] array,BufferedWriter errorwriter) throws IOException
    {
        
                
                 
            
                try {
                    
                    errorwriter.write(array[0]+","+array[1]+","+array[2]+"," +array[3]+","+array[4]);
                    errorwriter.newLine();
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            
       
          
        
                    
    }
    
    private void writeToOutputFile(Enquiry e,BufferedWriter outputwriter) throws IOException
    {        
                try {
                    
                    outputwriter.write(e.getStudentId()+","+e.getCourseId()+","+e.getFirstname()+","+e.getLastname()+","+e.getEmail());
                    outputwriter.newLine();
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
           
           
    }
}
