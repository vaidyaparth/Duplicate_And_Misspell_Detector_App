/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validity.dao;

import com.opencsv.CSVReader;
import com.validity.helper.CSVData;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author parth
 */
public class CSVDao {
    
    
     public ArrayList<CSVData> getCsvData(String fileName){
        ArrayList<CSVData> csvDataList = new ArrayList<>();
        try {
          
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader, ',', '"', 1);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                CSVData person = new CSVData();
                person.setId(Integer.parseInt(nextRecord[0]));
                person.setFirst_name(nextRecord[1]);
                person.setLast_name(nextRecord[2]);
                person.setCompany(nextRecord[3]);
                person.setEmail(nextRecord[4]);
                person.setAddress1(nextRecord[5]);
                person.setAddress2(nextRecord[6]);
                String zipcode = String.valueOf(nextRecord[7]);
                if(zipcode == "" || zipcode == null)
                {
                    person.setZip("null");
                }
                else
                {
                    person.setZip(zipcode);
                }
                person.setCity(nextRecord[8]);
                person.setState_long(nextRecord[9]);
                person.setState(nextRecord[10]);
                person.setPhone(nextRecord[11]);
                csvDataList.add(person);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  csvDataList;
    }
    
}
