package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class WriteSymptomsOccurrencesInResultOutFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings and
	 *                 number of occurrence in it, one per line
	 */
	public WriteSymptomsOccurrencesInResultOutFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeNumberPerSymptom(Map<String, Integer> occurrencePerSymptom) {
		// The file writing and creating process may give some IOException,
		// that's why it is mandatory to use try block

		// Try block to check for exception/s
		try {

			// Creating a FileWriter object which will create a new file
			// and if already available it will open it

			FileWriter resultsOut = new FileWriter(filepath, false);

			// iterate map entries
			for (Map.Entry<String, Integer> entry : occurrencePerSymptom.entrySet()) {

				// put key and value separated by a colon
				resultsOut.write(entry.getKey() + "=" + entry.getValue() + "\n");

			}

			// Content to be written on file
			// Custom input string

			// write() method will write the string in the file
			// resultsOut.write(occurrencePerSymptom.toString());

			// Always close the file
			resultsOut.close();

			// Print and display message
			System.out.println("\nFile write done");
		}

		// Catch block to catch if exception/s occurs
		catch (IOException e) {

			// Print and display error message
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
