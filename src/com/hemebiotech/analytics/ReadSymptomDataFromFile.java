
package com.hemebiotech.analytics;
/**
 * 
 * @author zouha
 * class ReadSymptomData FromFile with 2 attributes string(symptom name) and occurrence(how many times the symptom has appeared) with getter setter
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
	  * @return : method that returns the name of the symptom according to its location in the table
	  */
	    public String getChaine() {
	        return chaine;
	    }
	 /**
	  * 
	  * @return : method that returns the number of occurrences of a symptom according to its location in the table
	  */
	    public int getOccurence() {
	        return occurence;
	    }

}
