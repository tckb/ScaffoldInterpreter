package com.vishal.si.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import au.com.bytecode.opencsv.CSVReader;

public class InvertedIndex {

    public static void main(String[] args) throws IOException {

        String[] row = null;
        String csvFilename = "C:/Users/Om Sai Ram/Desktop/unique_substructures.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        // entry map <Moleculename, SMILES>
        TreeMap<Integer, String> UniqueSubStructureMap = new TreeMap<Integer, String>();
        TreeMap<String, List<String>> InvertedIndexMap = new TreeMap<String, List<String>>();
        List<String[]> content = csvReader.readAll();
        // substructure map <MoleculeName, List<Fragments>>
        int i = 0;

        for (Object object : content) {
            row = (String[]) object;
            UniqueSubStructureMap.put(i++, row[0]);
            // System.out.println(i + ":::::::" + row[0]);

        }

        String[] row1 = null;
        String csvFilename1 = "C:/Users/Om Sai Ram/Desktop/substructures.csv";
        CSVReader csvReader1 = new CSVReader(new FileReader(csvFilename1));
        // entry map <Moleculename, SMILES>
        TreeMap<String, String> substructureMap = new TreeMap<String, String>();
        List<String[]> content1 = csvReader1.readAll();

        for (Object object : content1) {
            row1 = (String[]) object;
            substructureMap.put(row1[0], row1[1]);
            // System.out.println(row1[0] + ":::::::" + row1[1]);

        }


        for (Map.Entry<Integer, String> e1 : UniqueSubStructureMap.entrySet()) {
            // MoleculeNames.clear();
            List<String> MoleculeNames = new ArrayList<String>();
            String uniqueSMILE = e1.getValue();
            for (Map.Entry<String, String> e2 : substructureMap.entrySet()) {
                String Molecule = e2.getKey();
                String[] longSMILE = e2.getValue().split(";");
                // MoleculeNames.clear();

                for (String smile : longSMILE) {
                    if (smile.equals(uniqueSMILE)) {
                        MoleculeNames.add(Molecule);
                        System.out.println(Molecule);
                    }
                }
                InvertedIndexMap.put(uniqueSMILE, MoleculeNames);
            }

            System.out.println(InvertedIndexMap.size());

        }

        String IISavedfile = "C:/Users/Om Sai Ram/Desktop/InvertedIndexMap.hmap";
        Utility.saveObjectToFile(new File(IISavedfile), InvertedIndexMap);


//		File synOutFile = new File("C:/Users/Om Sai Ram/Desktop/InvertedIndex.txt");
//
//		StringBuilder fileCont = new StringBuilder();
//
//		for (Entry<String, List<String>> e : InvertedIndexMap.entrySet()) {
//			fileCont.append(e.getKey()).append("\t")
//					.append(e.getValue().toString()).append("\n");
//			System.out.println(fileCont.toString());
//		}
//
//		Utility.saveStringToFile(fileCont.toString(), synOutFile);

        csvReader.close();

    }
}
