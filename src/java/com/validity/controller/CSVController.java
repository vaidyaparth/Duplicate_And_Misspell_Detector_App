/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validity.controller;

import com.validity.checker.DuplicateCheck;
import com.validity.helper.CSVData;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author parth
 */
public class CSVController extends AbstractController {
    
    public CSVController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String fileName = request.getParameter("selection");
                ModelAndView mv = null;

         
        DuplicateCheck removeDuplicate = new DuplicateCheck();
        ArrayList<CSVData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate(fileName);
         mv = new ModelAndView("displaydata", "noduplicate", csvDataNoDuplicate);

        return mv;
        
        
    }
    
      

}
