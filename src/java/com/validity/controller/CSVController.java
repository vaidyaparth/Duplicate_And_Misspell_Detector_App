/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validity.controller;

import com.validity.checker.DuplicateCheck;
import com.validity.checker.MispellCheck;
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
                String check = request.getParameter("userSelection");
                
        
        ModelAndView mv = null;

        if (check.equals("No Duplicates")) {
            DuplicateCheck removeDuplicate = new DuplicateCheck();
            ArrayList<CSVData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate(fileName);
            mv = new ModelAndView("displaydata", "a", csvDataNoDuplicate);
        } else if (check.equals("Duplicate")) {
            DuplicateCheck removeDuplicate = new DuplicateCheck();
            ArrayList<CSVData> csvDataDuplicate = removeDuplicate.getDuplicate(fileName);
            mv = new ModelAndView("displaydata", "a", csvDataDuplicate);
        }
         else if (check.equals("No Mispell")) {
        MispellCheck removeMispell = new MispellCheck();
            ArrayList<CSVData> csvDataNoMispell = removeMispell.removeMissSpell(fileName);
            mv = new ModelAndView("displaydata", "a", csvDataNoMispell);
        }
         else {
        MispellCheck removeMispell = new MispellCheck();
        ArrayList<CSVData> missSpellList = removeMispell.getMispell(fileName);
            mv = new ModelAndView("displaydata", "a", missSpellList);
        }
        

        return mv;

    }

}
