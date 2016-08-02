/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.course.dao;

import com.sajeena.course.entity.Course;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CourseDAO {
    boolean insert(Course c);
     List <Course> getAll();
      boolean  searchById(int id);
    
}
