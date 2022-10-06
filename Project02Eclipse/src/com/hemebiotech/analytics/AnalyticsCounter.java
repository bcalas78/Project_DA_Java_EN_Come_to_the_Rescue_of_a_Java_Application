package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	static ISymptomReader symptomreader = new ReadSymptomDataFromFile(
			"C:\\Users\\barba\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
	static ISymptomWriter symptomwriter = new WriteSymptomsOccurrencesInResultOutFile("resultOut.txt");

	public static void main(String[] args) throws Exception {

		// Read all the symptoms from symptoms.txt file
		List<String> symptoms = symptomreader.GetSymptoms();

		// Count the occurrences per symptom with countOccurrences method
		countOccurrences(symptoms);

		// Ordered the map of symptoms alphabetically

		// write the new ordered list in the result.out file
		// FileWriter writer = FileWriter ("result.out");
		// writer.close();

	}

	// method to count occurrences of symptoms using HashMap
	public static void countOccurrences(List<String> list) {
		// hashmap to store the occurrence of symptom
		Map<String, Integer> occurrencePerSymptom = new HashMap<String, Integer>();

		for (String symptom : list) {
			Integer occurrence = occurrencePerSymptom.get(symptom);
			occurrencePerSymptom.put(symptom, (occurrence == null) ? 1 : occurrence + 1);
		}

		// displaying the occurrence of symptoms in the list
		for (Map.Entry<String, Integer> value : occurrencePerSymptom.entrySet()) {
			System.out.println(value.getKey() + "=" + value.getValue());
		}
	}
}
