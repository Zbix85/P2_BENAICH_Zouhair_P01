
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author zouhair
 * Creation of a Main class which will instantiate the ReadSymptomDataFromFile object of the ReadSymptomDataFromFile class
 */

public class AnalyticsCounter {
	
	/**
	 * Class main  project execution
	 * @param args
	 */
	public static void main(String[] args) {
			
	   executionProjet();

    }
	
	/**
	 * CountMyItems function which will count the items in an array
	 * @param objects: reads an array with several strings
	 * @return: returns an array with counted strings (displayed occurrence for redundant strings)
	 */
	public ArrayList countMyItems(ArrayList<String> objets) {
	    ArrayList<ReadSymptomDataFromFile> mesObjets = new ArrayList();
	    while (!objets.isEmpty()) {
	        String tmp = objets.get(0);
	        int j = 0;
	        while (objets.remove(tmp)) {
	            j++;
	        }
	        ReadSymptomDataFromFile a = new ReadSymptomDataFromFile(tmp, j);
	        mesObjets.add(a);
	    }
	System.out.println();

	    return mesObjets;
	}
	
	public static void executionProjet()
	{
	/**
	 * Try catch method to catch exceptions related to opening the symptoms file
	 */
	try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();

			int j = 0;
			AnalyticsCounter sd = new AnalyticsCounter();
	        ArrayList array = new ArrayList();
	        ArrayList res = new ArrayList();
	   /**
	    * While loop on the symptoms file and to read line by line to feed the  array 
	    */
			while (line != null) {
				j++;	// increment i
				array.add(line);
				line = reader.readLine();	// get another symptom
			    }
	        // Methode pour trier le tableau 
			Collections.sort(array);
			//Création d'un objet de sortie Writer de class FileWriter afin d'afficher les symptomes sur le FileOut.java
			FileWriter writer = new FileWriter ("result.out");
	        res = sd.countMyItems(array);
	       
	      //Boucle sur le tableau des symptoms déjà triés et comptés afin de faire l'affichage sur system.out.println via les 2 methodes getChaine et getOccurence
	        for (int i = 0; i < res.size(); i++) {
	            System.out.println("" + ((ReadSymptomDataFromFile)res.get(i)).getChaine() +" " + ((ReadSymptomDataFromFile)res.get(i)).getOccurence());
	            writer.write("Symptom " + ((ReadSymptomDataFromFile)res.get(i)).getChaine() +" présent " + ((ReadSymptomDataFromFile)res.get(i)).getOccurence()+ " fois\n");
	        }
	      //Fermeture des ressources
	       	writer.close();
			reader.close();	
		 //La captutre des exceptions sera effectuée afin de les représenter à l'utilisateur d'uen façon conpréhensive et fonctionnelle
		} catch (FileNotFoundException e) {
			System.err.println("Symptoms file not found");
		} catch (IOException e) {
			System.err.println("Unable to read the contents of the symptoms file");
		}
   }


}
