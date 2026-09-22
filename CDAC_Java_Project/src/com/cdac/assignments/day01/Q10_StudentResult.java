package com.cdac.assignments.day01;

/**
 * Question 10: Student Result
 * Problem: Accept marks of a student and check whether the student has passed or failed.
 * Rule:
 *   Marks >= 40 -> Pass
 *   Marks < 40  -> Fail
 */
public class Q10_StudentResult {

    public static void evaluateResult(String studentName, double marks) {
        System.out.printf("Student: %-10s | Marks: %5.1f/100 | Result: ", studentName, marks);
        if (marks < 0 || marks > 100) {
            System.out.println("INVALID MARKS (Must be between 0 and 100)");
        } else if (marks >= 40.0) {
            String grade = (marks >= 75) ? "Distinction" : (marks >= 60) ? "First Class" : "Pass Class";
            System.out.println("PASSED (" + grade + ")");
        } else {
            System.out.println("FAILED");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 10: Student Result Evaluation ===");

        evaluateResult("Aarav", 88.5);
        evaluateResult("Priya", 64.0);
        evaluateResult("Rohan", 41.0);
        evaluateResult("Sneha", 33.5);
        evaluateResult("Invalid", 105.0);
    }
}
