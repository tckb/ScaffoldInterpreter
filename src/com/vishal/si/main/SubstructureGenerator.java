package com.vishal.si.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.fragment.MurckoFragmenter;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.smiles.SmilesParser;

import au.com.bytecode.opencsv.CSVReader;

public class SubstructureGenerator {

	public static List<String> getFragments(IAtomContainer mol)
			throws CDKException {

		List<String> fragmentsAsSMILES = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String toString() {
				StringBuilder elements = new StringBuilder();

				for (Object s : toArray())
					elements.append((String) s).append(";");
				return elements.toString();
			}
		};

		MurckoFragmenter fragmenter = new MurckoFragmenter();
		fragmenter.generateFragments(mol);

		IAtomContainer[] fragments = fragmenter.getFragmentsAsContainers();
		SmilesGenerator sg = new SmilesGenerator();

		for (int i = 0; i < fragments.length; i++) {
			fragmentsAsSMILES.add(sg.createSMILES(fragments[i]));
		}

		return fragmentsAsSMILES;
	}

	public static void main(String[] args) throws IOException, CDKException {

		String[] row = null;
		String csvFilename = "H:/vsiramshetty/Desktop/SMILESforFragments1.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		// entry map <Moleculename, SMILES>
		HashMap<String, String> map = new HashMap<String, String>();
		List<String[]> content = csvReader.readAll();
		// substructure map <MoleculeName, List<Fragments>>
		HashMap<String, List<String>> substructureMap = new HashMap<String, List<String>>();
		SmilesParser sp = new SmilesParser(
				DefaultChemObjectBuilder.getInstance());

		for (Object object : content) {
			row = (String[]) object;
			map.put(row[0], row[1]);
			IAtomContainer mol = sp.parseSmiles(row[1]);
			List<String> Fragments = getFragments(mol);
			System.out.println(map.size() + " " + Fragments.toString());
			substructureMap.put(row[0], Fragments);
		}

		// we have the substructureMap<MoleculeName,List<Substructures>>
		// now generate an inverted index of the substructures, i.e, generate
		// the list of unique substructures along with the names of drugs that
		// have those scaffolds
		// (InvertedIndexMap<Substructure,List<MoleculeNames>>)

		File synOutFile = new File("H:/vsiramshetty/Desktop/Substructures1.txt");

		StringBuilder fileCont = new StringBuilder();

		for (Entry<String, List<String>> e : substructureMap.entrySet()) {
			fileCont.append(e.getKey()).append("\t")
					.append(e.getValue().toString()).append("\n");
			System.out.println(fileCont.toString());
		}

		Utility.saveStringToFile(fileCont.toString(), synOutFile);

		csvReader.close();
	}

}
