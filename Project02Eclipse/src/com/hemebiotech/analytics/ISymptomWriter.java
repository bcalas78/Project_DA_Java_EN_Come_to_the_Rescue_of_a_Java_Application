package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface that will write number of occurrence per symptom. The important
 * part is, the return value from the operation, which is a Map of key (strings)
 * - value (integer). Each key is unique. The map needs to be ordered.
 * 
 * @author Barbara Calas
 * @version 1.0
 */

public interface ISymptomWriter {
	/**
	 * Write number of occurrence for each symptom in a sorted map (key: symptom,
	 * value: number of occurrence)
	 * 
	 * @param occurrencePerSymptom Map of symtoms and the number of their
	 *                             occurrences
	 */
	void writeNumberPerSymptom(Map<String, Integer> occurrencePerSymptom);
}