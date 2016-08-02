/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.course.dao.impl;

import com.sajeena.course.dao.CourseDAO;
import com.sajeena.course.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourseDAOImpl implements CourseDAO {

    private int count = 0;
    private List<Course> courseList = new ArrayList<>();

    @Override
    public boolean insert(Course c) {
        return courseList.add(c);
    }

    @Override
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public boolean searchById(int id) {
        for (Course c : courseList) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
