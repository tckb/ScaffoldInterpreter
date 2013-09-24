/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vishal.si.main;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.fingerprint.Fingerprinter;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.smiles.SmilesParser;

/**
 *
 * @author Om Sai Ram
 */
public class TestBed {
    public static void main(String[] args) throws InvalidSmilesException, CDKException {
        String smiles1 = "C1COC(C1)CN2CCNCC2";
        String smiles2 = "C(C1CCCO1)N1CCNCC1";
        
        IAtomContainer mol1 = new SmilesParser(DefaultChemObjectBuilder.getInstance()).parseSmiles(smiles1);
        IAtomContainer mol2 = new SmilesParser(DefaultChemObjectBuilder.getInstance()).parseSmiles(smiles2);
        
        java.util.BitSet fingerprint1 = new Fingerprinter().getFingerprint(mol1);
        java.util.BitSet fingerprint2 = new Fingerprinter().getFingerprint(mol2);
        
        if(fingerprint1.equals(fingerprint2)){
            System.out.println("Both are same!");
        }
    }
}
