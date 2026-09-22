package com.cdac.practice.module03_collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * Counts unique word occurrences in a text block after sanitizing punctuation
 * and normalizing casing, storing results in a sorted TreeMap.
 */
public class WordFrequencyCounterDemo {

    public static Map<String, Integer> countFrequencies(String text) {
        Map<String, Integer> freqMap = new TreeMap<>();
        if (text == null || text.trim().isEmpty()) {
            return freqMap;
        }

        // Remove punctuation and convert to lowercase
        String cleaned = text.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();
        String[] words = cleaned.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        return freqMap;
    }

    public static void main(String[] args) {
        System.out.println("=== Word Frequency Counter (TreeMap) ===\n");

        String sampleText = """
                Java is a powerful object-oriented programming language.
                Java enables developers to write once and run anywhere.
                Functional programming in Java provides streams and lambdas;
                streams make data processing in Java clean, expressive, and concise!
                """;

        System.out.println("Sample Passage:");
        System.out.println(sampleText.trim());
        System.out.println("\n--- Word Frequency Breakdown (Alphabetical) ---");

        Map<String, Integer> frequencies = countFrequencies(sampleText);
        System.out.printf("%-18s | %s%n", "Word", "Count");
        System.out.println("-------------------+------");

        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.printf("%-18s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("-------------------+------");
        System.out.println("Total Unique Words : " + frequencies.size());
    }
}
