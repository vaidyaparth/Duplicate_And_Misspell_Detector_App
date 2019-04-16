/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validity.checker;

import com.validity.helper.CSVData;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class MispellCheck {
      ArrayList<CSVData> mispells = new ArrayList<>();
    /**
     * Checks The Data For Spelling mistake(Not more than 2 Characters)
     * Compares Email_id, First_name, Last_name
     */
    public ArrayList<CSVData> removeMissSpell(String file) {
        DuplicateCheck removeDuplicate = new DuplicateCheck();
        ArrayList<CSVData> data = removeDuplicate.CsvDataWithNoDuplicate(file);
        ArrayList<CSVData> dataWithoutMispell = new ArrayList<>();
        if(data!=null) {
            for (int i = 0; i < data.size() - 1; i++) {
                for (int j = i + 1; j < data.size(); j++) {
                    //Calls misspellCheck method to get the cost of edit
                    int countFirstName = misspellCheck(data.get(i).getFirst_name(), data.get(j).getFirst_name());
                    int countPhone = misspellCheck(data.get(i).getPhone(), data.get(j).getPhone());
                    int countEmail = misspellCheck(data.get(i).getEmail(), data.get(j).getEmail());
                    if (((countFirstName < 3) && (countPhone == 0)) || ((countFirstName < 3) && (countEmail == 0))) {
                        mispells.add(data.get(i));
                        mispells.add(data.get(j));
                        data.remove(j);
                    } else if ((countFirstName == 0) && (countEmail == 0) && (countPhone < 3)) {
                        mispells.add(data.get(i));
                        mispells.add(data.get(j));
                        data.remove(j);
                    } else if ((countFirstName == 0) && (countPhone == 0) && (countEmail < 3)) {
                        mispells.add(data.get(i));
                        mispells.add(data.get(j));
                        data.remove(j);
                    }

                }
            }
        }else{
            System.out.println("Data is empty");
        }
        return data;
    }

    /**
     * get data of mispelled words in that list
     * @param file
     * @return
     */

    public ArrayList<CSVData> getMispell(String file){
        removeMissSpell(file);
        return mispells;
    }
    /**
     * Calculates The cost of different Characters in Strings
     * Takes tow string as input and returns the cost
     *
     */
    public  int misspellCheck(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
}
