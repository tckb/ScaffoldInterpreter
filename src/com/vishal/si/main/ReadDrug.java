/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vishal.si.main;

import au.com.bytecode.opencsv.CSVReader;
import com.vishal.si.struct.Drug;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Om Sai Ram
 */
public class ReadDrug {

    public static void main(String[] args) {
        try {
            String[] row = null;
            String csvFilename = "C:/Users/Om Sai Ram/Desktop/drugs.csv";
            CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
            // entry map <Moleculename, SMILES>
            TreeMap<String, Drug> drugList = new TreeMap<String, Drug>();
            List<String[]> content = csvReader.readAll();

            for (Object object : content) {
                row = (String[]) object;
               Drug d = new Drug();
               d.setName(row[0].toLowerCase());
               d.setUniqueSMILE(row[1]);
               d.setDrugbankID(row[2]);
               d.setIndication(row[3]);
               d.setLogP(row[4]);
               drugList.put(d.getName(), d);
            }
            
            
            
            System.out.println(drugList.size());
            String dList = "C:/Users/Om Sai Ram/Desktop/drugList.hmap";
            Utility.saveObjectToFile(new File(dList), drugList);
                
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ReadDrug.class.getName()).log(Level.SEVERE, null, ex); 

        }
    }
}
