package com.cdac.session03_oop;

/**
 * Syllabus Sessions 3 & 4:
 * Understanding String Class, StringBuilder Class, and Immutability.
 */
public class StringAndStringBuilderDemo {

    public static void main(String[] args) {
        System.out.println("=== CDAC Sessions 3 & 4: String vs. StringBuilder ===");

        // 1. String Immutability
        String str1 = "CDAC";
        String str2 = str1; // Points to the same object in String Constant Pool
        str1 = str1 + " ACTS"; // Creates a new String object!

        System.out.println("str1: " + str1);
        System.out.println("str2 (original unchanged): " + str2);
        System.out.println("str1 == str2: " + (str1 == str2));

        // 2. StringBuilder for efficient mutable concatenation
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming")
          .append(" for AI")
          .append(" (2026)");

        System.out.println("\nStringBuilder result : " + sb.toString());
        sb.reverse();
        System.out.println("Reversed              : " + sb.toString());
        sb.reverse(); // Reverse back

        // 3. Performance demonstration
        int iterations = 10_000;
        long start = System.currentTimeMillis();
        StringBuilder fast = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            fast.append("A");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("\nTime taken by StringBuilder for " + iterations + " appends: " + duration + " ms");
    }
}
