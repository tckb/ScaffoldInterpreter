/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vishal.si.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.io.iterator.IteratingMDLReader;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.smiles.SmilesParser;

/**
 *
 * @author Om Sai Ram
 */
public class ReadSDF {

    public static String getSmilesFromFile(File sdfFile) throws FileNotFoundException, InvalidSmilesException {
        String smiles = null;
        int mCnt = 0;



        IteratingMDLReader reader = new IteratingMDLReader(new FileInputStream(sdfFile), DefaultChemObjectBuilder.getInstance());
        while (reader.hasNext()) {
            IMolecule molecule = (IMolecule) reader.next();
            SmilesGenerator sg = new SmilesGenerator();
            smiles = sg.createSMILES(molecule);

            IMolecule mol = new SmilesParser(
                    DefaultChemObjectBuilder.getInstance()).parseSmiles(smiles);
            smiles = sg.createSMILES(mol);

            mCnt++;
        }
        if (mCnt > 1) {
            Utility.UI.showInfoMessage(null, "SDF contains more than one molecule. Last molecule selecte!");
        }

        
       
        return smiles;
    }

    public static String getCanonicalSmiles(String smiles) throws InvalidSmilesException {
        String uniqueSmiles = null;

        SmilesParser parser = new SmilesParser(DefaultChemObjectBuilder.getInstance());
        SmilesGenerator generator = new SmilesGenerator();

        uniqueSmiles = generator.createSMILES(parser.parseSmiles(smiles));

        return uniqueSmiles;
    }
}
