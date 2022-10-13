package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	static ISymptomReader symptomreader = new ReadSymptomDataFromFile(
			"C:\\Users\\barba\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
	static ISymptomWriter symptomwriter = new WriteSymptomsOccurrencesInResultOutFile(
			"C:\\Users\\barba\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\results.out.txt");

	// hashmap to store the unsorted occurrence of symptom
	static Map<String, Integer> occurrencePerSymptom = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {

		// Read all the symptoms from symptoms.txt file
		List<String> symptoms = symptomreader.GetSymptoms();

		// Calling the function to count the occurrences per symptom
		countOccurrences(symptoms);

		// Calling the function to sort the symptoms by alphabetical order
		sortByAlphabet();

		// write the new ordered list in the results.out.txt file
		// symptomwriter.writeNumberPerSymptom(occurrencePerSymptom);
	}

	// Function to count occurrences of symptoms using HashMap
	public static void countOccurrences(List<String> list) {

		// store the occurrence of symptom in the hashmap
		for (String symptom : list) {
			Integer occurrence = occurrencePerSymptom.get(symptom);
			occurrencePerSymptom.put(symptom, (occurrence == null) ? 1 : occurrence + 1);
		}

		// displaying the occurrence of symptoms in the arraylist
		for (Map.Entry<String, Integer> value : occurrencePerSymptom.entrySet()) {
			System.out.println(value.getKey() + "=" + value.getValue());
		}
	}

	// Function to sort map by symptom (Key)
	public static void sortByAlphabet() {

		ArrayList<String> sortedSymptoms = new ArrayList<String>(occurrencePerSymptom.keySet());

		Collections.sort(sortedSymptoms);

		// Display the TreeMap which is naturally sorted
		for (String symptom : sortedSymptoms)
			System.out.println(symptom + "=" + occurrencePerSymptom.get(symptom));
	}
}
