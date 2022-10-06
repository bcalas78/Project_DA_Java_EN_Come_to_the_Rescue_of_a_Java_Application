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

		try {
			FileWriter fileWriter = new FileWriter(filepath, false);
			// BufferedWriter writer = new BufferedWriter(fileWriter);

			fileWriter.write(occurrencePerSymptom.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
