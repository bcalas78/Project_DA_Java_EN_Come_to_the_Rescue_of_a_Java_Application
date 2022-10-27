package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <b>AnalyticsCounter is the class that represents the counting of the
 * analytics. The methods executing the program are defined in it. </b>
 * 
 * @see ISymptomReader
 * @see ISymptomWriter
 * @see AnalyticsCounter
 * 
 * @author Barbara Calas
 * @version 1.0
 */

public class AnalyticsCounter {

	/**
	 * Hashmap to store the number of occurrences per unsorted symptom.
	 */
	static SortedMap<String, Integer> occurrencePerSymptom = new TreeMap<>();

	/**
	 * Instance of ISymptomReader
	 * 
	 * @see ISymptomReader
	 */
	ISymptomReader symptomreader;

	/**
	 * Instance of ISymptomReader
	 * 
	 * @see ISymptomWriter
	 */
	ISymptomWriter symptomwriter;

	/**
	 * @param sr Symptom reader
	 * @param sw Symptom writer
	 */
	public AnalyticsCounter(ISymptomReader sr, ISymptomWriter sw) {
		this.symptomreader = sr;
		this.symptomwriter = sw;
	}

	/**
	 * <b>Get symptoms from a list of strings.</b>
	 * <p>
	 * If no data is available, return an empty List.
	 * </p>
	 * 
	 * @return the list of symptoms from the "symptoms.txt" file
	 */
	public List<String> getSymptoms() {
		return symptomreader.GetSymptoms();
	}

	/**
	 * <b>Count the occurrences for each symptom using a hashmap.</b>
	 * <ul>
	 * <li>For each symptom of the list, associate the number of occurrence
	 * (integer) using get and put methods</li>
	 * <li>Displaying the occurrence of symptoms in the arraylist for each value of
	 * symptom</li>
	 * </ul>
	 * 
	 * @param list list of the symptoms (strings)
	 */
	public void countOccurrences(List<String> list) {

		for (String symptom : list) {
			Integer occurrence = occurrencePerSymptom.get(symptom);
			occurrencePerSymptom.put(symptom, (occurrence == null) ? 1 : occurrence + 1);
		}

		for (Map.Entry<String, Integer> value : occurrencePerSymptom.entrySet()) {
			System.out.println(value.getKey() + "=" + value.getValue());
		}
	}

	/**
	 * <b>Sort the map by alphabetical order of the symptoms (strings).</b>
	 * <ul>
	 * <li>Create a list 'sortedSymptoms' of strings</li>
	 * <li>Collections.sort method is sorting the elements of ArrayList in ascending
	 * order.</li>
	 * <li>Create an empty hash map 'occurrencePerSymptomSorted' by declaring object
	 * of string and integer type</li>
	 * <li>For each symptom of the list 'sortedSymptoms', print the sorted list in
	 * the format 'symptom=nombre d'occurrences'</li>
	 * </ul>
	 * 
	 * @param sortedSymptoms list of the symptoms (string)
	 */
	public void sortByAlphabet() {

		List<String> sortedSymptoms = new ArrayList<String>(occurrencePerSymptom.keySet());

		Collections.sort(sortedSymptoms);
		Map<String, Integer> occurrencePerSymptomSorted = new HashMap<>();

		// Display the TreeMap which is naturally sorted
		for (String symptom : sortedSymptoms) {
			occurrencePerSymptomSorted.put(symptom, occurrencePerSymptom.get(symptom));
			System.out.println(symptom + "=" + occurrencePerSymptom.get(symptom));
		}
	}

	/**
	 * <b>Write the result in a new file.</b>
	 */
	public void writeResult() {
		symptomwriter.writeNumberPerSymptom(occurrencePerSymptom);
	}
}
