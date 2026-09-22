package com.cdac.session01_basics;

/**
 * Syllabus Session 2:
 * Control Statements: if-else, switch (including Java 17+ switch expressions),
 * while, do-while, for, break and continue.
 */
public class ControlStatementsDemo {

    public static void main(String[] args) {
        System.out.println("=== CDAC Session 2: Control Flow Statements ===");

        // 1. If-Else Ladder
        int score = 82;
        char grade;
        if (score >= 90) grade = 'A';
        else if (score >= 80) grade = 'B';
        else if (score >= 70) grade = 'C';
        else grade = 'F';
        System.out.println("Score: " + score + " -> Grade: " + grade);

        // 2. Modern Java Switch Expression (Standard in Java 17+)
        String day = "WEDNESDAY";
        String dayCategory = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Working Day";
            case "SATURDAY", "SUNDAY" -> "Weekend Holiday";
            default -> "Unknown Day";
        };
        System.out.println("Day: " + day + " is a " + dayCategory);

        // 3. For loop with break and continue
        System.out.print("Odd numbers up to 10 (using continue): ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // Skip evens
            System.out.print(i + " ");
        }
        System.out.println();

        // 4. While loop
        int count = 3;
        System.out.print("Countdown: ");
        while (count > 0) {
            System.out.print(count + "... ");
            count--;
        }
        System.out.println("Go!");

        // 5. Do-While loop (Guaranteed at least 1 execution)
        int doCount = 0;
        do {
            System.out.println("Do-while executed at count = " + doCount);
            doCount++;
        } while (doCount < 1);
    }
}
