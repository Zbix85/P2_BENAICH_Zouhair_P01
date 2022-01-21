

package com.hemebiotech.analytics;


/**
 * 
 * @author zouha
 * class ReadSymptomDataFromFile avec 2 attributs chaine(nom de symptome) et occurence(combien de fois le symptome est apparu) avec getter setter
 * 	 
 */

public class ReadSymptomDataFromFile {
	 private String chaine;
	    private int occurence;
	 
	    public ReadSymptomDataFromFile(String chaine, Integer occ) {
	        this.chaine = chaine;
	        this.occurence = occ;
	    }
	 /**
	  *  
	  * @return : methode qui permet de retourner le nom du symptome selon son emplacement dans le tableau
	  */
	    public String getChaine() {
	        return chaine;
	    }
	 /**
	  * 
	  * @return : methode qui permet de retourner le nombre d'occurence  d'un symptome selon son emplacement dans le tableau 
	  */
	    public int getOccurence() {
	        return occurence;
	    }

}
