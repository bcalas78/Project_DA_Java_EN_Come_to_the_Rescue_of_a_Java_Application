package com.hemebiotech.analytics;

import java.util.List;

/**
 * <b>Main is the main class of the app. The program is executed here in the
 * main method.</b>
 * 
 * @see ISymptomReader
 * @see ISymptomWriter
 * @see AnalyticsCounter
 * 
 * @author Barbara Calas
 * @version 1.0
 */

public class Main {

	static ISymptomReader symptomreader = new ReadSymptomDataFromFile(
			"C:\\Users\\barba\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
	static ISymptomWriter symptomwriter = new WriteSymptomsOccurrencesInResultOutFile(
			"C:\\Users\\barba\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\results.out");

	public static AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomreader, symptomwriter);

	/**
	 * <b>The program is executed in the main method.</b>
	 * <ul>
	 * <li>Read all the symptoms from symptoms.txt file with the getSymptoms()
	 * method</li>
	 * <li>Count the occurrences per symptom with the countOccurrences() method,
	 * symptoms as params</li>
	 * <li>Sort the symptoms by alphabetical order with the sortByAlphabet()
	 * method</li>
	 * <li>Write the new ordered list in the results.out.txt file</li>
	 * </ul>
	 * 
	 * @see AnalyticsCounter
	 * @throws Exception If and exception occurred
	 */
	public static void main(String[] args) throws Exception {

		List<String> symptoms = analyticsCounter.getSymptoms();

		analyticsCounter.countOccurrences(symptoms);

		analyticsCounter.sortByAlphabet();

		analyticsCounter.writeResult();
	}
}