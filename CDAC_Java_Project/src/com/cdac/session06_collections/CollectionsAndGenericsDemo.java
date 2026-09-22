package com.cdac.session06_collections;

import java.util.*;

/**
 * Syllabus Session 6:
 * Enumerations, Autoboxing, Java APIs (java.util, java.lang, java.math),
 * Generics and Collections Framework Overview.
 */
public class CollectionsAndGenericsDemo {

    // Enumeration
    public enum Priority {
        LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);

        private final int level;
        Priority(int level) { this.level = level; }
        public int getLevel() { return level; }
    }

    // Generic Class Box<T>
    public static class StorageBox<T> {
        private T content;

        public void put(T content) { this.content = content; }
        public T get() { return content; }

        @Override
        public String toString() {
            return "StorageBox containing: " + content;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== CDAC Session 6: Generics, Enums & Collections ===\n");

        // 1. Enum usage
        Priority currentPriority = Priority.HIGH;
        System.out.println("Current Alert Priority: " + currentPriority + " (Level " + currentPriority.getLevel() + ")");

        // 2. Generic Box
        StorageBox<String> stringBox = new StorageBox<>();
        stringBox.put("Secure AI Model Weights");
        System.out.println(stringBox);

        // 3. List: ArrayList
        System.out.println("\n--- 1. List Demo (ArrayList) ---");
        List<String> modules = new ArrayList<>();
        modules.add("Basics & OOP");
        modules.add("Exception Handling");
        modules.add("Collections");
        modules.add("Streams & Lambdas");
        System.out.println("Total Modules: " + modules.size());
        modules.forEach(m -> System.out.println(" - " + m));

        // 4. Set: HashSet & TreeSet
        System.out.println("\n--- 2. Set Demo (TreeSet Sorted) ---");
        Set<Integer> uniqueScores = new TreeSet<>(List.of(88, 45, 92, 45, 76, 88));
        System.out.println("Sorted unique scores: " + uniqueScores);

        // 5. Map: HashMap
        System.out.println("\n--- 3. Map Demo (HashMap Key-Value) ---");
        Map<String, String> configMap = new HashMap<>();
        configMap.put("JAVA_HOME", "C:\\Java\\jdk-17");
        configMap.put("IDE", "Eclipse 2024");
        configMap.put("MODULE", "PGCP-AI Java");

        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " => Value: " + entry.getValue());
        }
    }
}
