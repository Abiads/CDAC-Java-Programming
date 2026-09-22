package com.cdac.assignments.day02;

import java.util.Scanner;

public class Q02_StudentGradeCalculation {

    public static String calculateGrade(int marks) {
        if (marks >= 90 && marks <= 100) {
            return "A";
        } else if (marks >= 75 && marks <= 89) {
            return "B";
        } else if (marks >= 60 && marks <= 74) {
            return "C";
        } else if (marks >= 50 && marks <= 59) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's marks: ");
        int marks = sc.nextInt();

        String grade = calculateGrade(marks);

        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + grade);

        sc.close();
    }
}
