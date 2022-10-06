package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class WriteSymptomWithNumberOfOccurrenceInResultOutFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings and
	 *                 number of occurrence in it, one per line
	 */
	public WriteSymptomWithNumberOfOccurrenceInResultOutFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeNumberPerSymptom(Map<String, Integer> numberPerSymptom) {

		try {
			FileWriter fileWriter = new FileWriter(filepath, false);
			// BufferedWriter writer = new BufferedWriter(fileWriter);

			fileWriter.write(numberPerSymptom.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
