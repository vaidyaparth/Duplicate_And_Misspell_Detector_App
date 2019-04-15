/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validity.checker;

import com.validity.dao.CSVDao;
import com.validity.helper.CSVData;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class DuplicateCheck {
    

    ArrayList<CSVData> duplicates = new ArrayList<>();
    /**
     *
     * @return Arraylist of csv data
     * removing exact duplicates form the list
     */

    public ArrayList<CSVData> CsvDataWithNoDuplicate(String file){
        ArrayList<CSVData> CsvDataNoDuplicate = new ArrayList<>();
        CSVDao csvReader = new CSVDao();
        //passing the file path for reding csv
        if(file.equals("Normal") ){
            File ff = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Validity_Demo\\src\\java\\resources\\normal.csv");
            CsvDataNoDuplicate = csvReader.getCsvData(ff.getAbsolutePath());
            System.out.println("Normal");
        }
        else {
            File ff = new File("src\\main\\resources\\advanced.csv");
            CsvDataNoDuplicate = csvReader.getCsvData(ff.getAbsolutePath());
            System.out.println("Advance ");
        }
        
        //Iterating over the list to find exact duplicates
        if (CsvDataNoDuplicate!=null) {
            for (int i = 0; i < CsvDataNoDuplicate.size() - 1; i++) {
                for (int j = i + 1; j < CsvDataNoDuplicate.size(); j++) {
                    if ((CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail())) && (CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name())) && (CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))) {
                        duplicates.add(CsvDataNoDuplicate.get(i));
                        duplicates.add(CsvDataNoDuplicate.get(j));
                        CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                    }
                    //Check if the field is empty for further consideration
                    if ((CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name())) && (CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail()))) {
                        if (CsvDataNoDuplicate.get(j).getPhone().equals("")) {
                            duplicates.add(CsvDataNoDuplicate.get(i));
                            duplicates.add(CsvDataNoDuplicate.get(j));
                            CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                        }
                    }
                    if ((CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name())) && (CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))) {
                        if (CsvDataNoDuplicate.get(j).getEmail().equals("")) {
                            duplicates.add(CsvDataNoDuplicate.get(i));
                            duplicates.add(CsvDataNoDuplicate.get(j));
                            CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                        }
                    }
                    if ((CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail())) && (CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))) {
                        if (CsvDataNoDuplicate.get(j).getFirst_name().equals("")) {
                            duplicates.add(CsvDataNoDuplicate.get(i));
                            duplicates.add(CsvDataNoDuplicate.get(j));
                            CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                        }
                    }
                }

            }

        }else{
            System.out.println("List is empty");
        }
        return CsvDataNoDuplicate;
    }

    /**
     * get duplicate data from the list
     * @param file
     * @return
     */

    public ArrayList<CSVData> getDuplicate(String file){
        CsvDataWithNoDuplicate(file);
        return duplicates;
    }
}
