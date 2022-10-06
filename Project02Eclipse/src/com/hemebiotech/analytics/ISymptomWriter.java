package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 */
public interface ISymptomWriter {
	/**
	 * @return a map which lists the number of occurrence for each symptom (key:
	 *         symptom, value: number of occurrence)
	 */
	void writeNumberPerSymptom(Map<String, Integer> numberPerSymptom);
}