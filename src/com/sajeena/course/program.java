/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.course;

import com.sajeena.course.dao.CourseDAO;
import com.sajeena.course.dao.EnquiryDAO;
import com.sajeena.course.dao.impl.CourseDAOImpl;
import com.sajeena.course.dao.impl.EnquiryDAOImpl;
import com.sajeena.course.controller.CourseController;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       CourseDAO coursedao = new CourseDAOImpl();
        EnquiryDAO enquirydao = new EnquiryDAOImpl();
        CourseController pc=new CourseController(coursedao, enquirydao);
         pc.process();
    }
    
}
