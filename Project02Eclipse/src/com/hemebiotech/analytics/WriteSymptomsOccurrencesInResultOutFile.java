package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * <b>WriteSymptomsOccurrencesInResultOutFile is the class that represents the
 * writing of the results in a new file. </b>
 * <p>
 * This class implements the interface ISymptomWriter.
 * </p>
 * 
 * @see ISymptomWriter
 * 
 * @author Barbara Calas
 * @version 1.0
 */
public class WriteSymptomsOccurrencesInResultOutFile implements ISymptomWriter {

	private String filepath;

	/**
	 * <b>Write the number of occurrences per symptom in "result.out" file</b>
	 * 
	 * @param filepath a full or partial path to file where the symptom strings and
	 *                 number of occurrence will be written in it, one per line
	 */
	public WriteSymptomsOccurrencesInResultOutFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * <b>Write number of occurrence per symptom.</b>
	 * <p>
	 * The file writing and creating process may give some IOException, that's why
	 * it is mandatory to use try block to check for exception/s. And a catch block
	 * to catch if exception/s occurs, print and display an error message.
	 * </p>
	 * <ul>
	 * <li>Creating a FileWriter object which will create a new file
	 * "resultOut"</li>
	 * <li>Iterate map entries</li>
	 * <li>Write() method will write the string in the file "resultOut"</li>
	 * <li>For each entry, put key and value separated by an equals</li>
	 * <li>Always close the file with close() method</li>
	 * <li>Print and display a message in the console</li>
	 * </ul>
	 * 
	 * @param occurrencePerSymptom which is a map of string (name of the syptom) and
	 *                             integer (number of occurrence).
	 */
	@Override
	public void writeNumberPerSymptom(Map<String, Integer> occurrencePerSymptom) {

		try {

			FileWriter resultsOut = new FileWriter(filepath, false);

			for (Map.Entry<String, Integer> entry : occurrencePerSymptom.entrySet()) {

				resultsOut.write(entry.getKey() + "=" + entry.getValue() + "\n");

			}

			resultsOut.close();

			System.out.println("\nFile write done");
		}

		catch (IOException e) {

			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
