package com.cdac.assignments.day01;

/**
 * Question 5: Calculate Total and Average
 * Problem: Store marks of three subjects in variables and calculate
 * the total and average marks.
 */
public class Q05_TotalAndAverage {

    public static void main(String[] args) {
        System.out.println("=== Question 5: Calculate Total and Average Marks ===");

        int subject1 = 85;
        int subject2 = 78;
        int subject3 = 92;

        int total = subject1 + subject2 + subject3;
        double average = total / 3.0; // Floating-point division

        System.out.println("Subject 1 Marks : " + subject1);
        System.out.println("Subject 2 Marks : " + subject2);
        System.out.println("Subject 3 Marks : " + subject3);
        System.out.println("------------------------------");
        System.out.println("Total Marks     : " + total + " / 300");
        System.out.printf("Average Marks   : %.2f%%%n", average);
    }
}
