/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vishal.si.main;

import au.com.bytecode.opencsv.CSVReader;
import com.vishal.si.struct.Scaffold;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Om Sai Ram
 */
public class ReadScaffold {

    public static void main(String[] args) {
        String[] row = null;
        String csvFilename = "C:/Users/Om Sai Ram/Desktop/scaffolds.csv";
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(csvFilename));

            // entry map <Moleculename, SMILES>
            TreeMap<String, Scaffold> scfList = new TreeMap<String, Scaffold>();
            List<String[]> content = csvReader.readAll();
int i = 0;
            for (Object object : content) {
                row = (String[]) object;
                Scaffold s = new Scaffold();

                s.setIUPACname(row[0]);
                s.setLogP(Double.parseDouble(row[1]));
                s.setBMframework(row[2]);
                s.setUniqueSmile(row[3]);
                scfList.put(s.getUniqueSmile(), s);
             
               
            }

             System.out.println("Size is: "+scfList.size());
            String scList = "C:/Users/Om Sai Ram/Desktop/scaffoldList.hmap";
            Utility.saveObjectToFile(new File(scList), scfList);
        } catch (Exception ex) {
            Logger.getLogger(ReadScaffold.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
