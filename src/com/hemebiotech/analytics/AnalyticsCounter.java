
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
 * Création d'une class Main qui instancie l'objet ReadSymptomDataFromFile de la class ReadSymptomDataFromFile
 */

public class AnalyticsCounter {
	
	/**
	 * Class main d'execution du projet
	 * @param args
	 */
	public static void main(String[] args) {
			
	   Execution_projet();

    }
	
	/**
	 * Fonction CountMyItems qui va faire un comptage des items dans un tableau 
	 * @param objets :lit un tableau avec plusieurs chaines
	 * @return : retourne un tableau avec des chaines comptés (occurence affichée pour les chaines redondantes)
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
	
	public static void Execution_projet()
	{
	/**
	 * Methode try catch pour capturer les exceptions liées à l'ouverture du fichier symptoms 
	 */
	try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();

			int j = 0;
			AnalyticsCounter sd = new AnalyticsCounter();
	        ArrayList array = new ArrayList();
	        ArrayList res = new ArrayList();
	   /**
	    * Boucle while sur le fichier  symptoms et pour lire ligne par ligne afin d'alimenter le tableau array 
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
			System.err.println("Le fichier symptomes n'a pas été trouvé");
		} catch (IOException e) {
			System.err.println("Impossible de lire le contenu du fichier symptomes");
		}

   }


}
