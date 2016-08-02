/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajeena.course.dao.impl;

import com.sajeena.course.dao.EnquiryDAO;
import com.sajeena.course.entity.Enquiry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    
     private int count = 0;
   private List<Enquiry> enquiryList=new ArrayList<>();

    @Override
    public boolean insert(Enquiry en) {
        return enquiryList.add(en);
    }

    @Override
    public List<Enquiry> getAll() {
         return enquiryList;
    }

    @Override
    public boolean searchByemail(String email) {
          for(Enquiry en:enquiryList)
        {
            if(en.getEmail().contentEquals(email))
            {
                return true;
            }
        }
        return false;
    }
    
}
