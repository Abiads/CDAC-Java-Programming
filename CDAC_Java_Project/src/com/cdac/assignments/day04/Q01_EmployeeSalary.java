package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Runner class for Assignment 4 - Problem 1: Employee Salary Calculation
 */
public class Q01_EmployeeSalary {

    public static void main(String[] args) {
        System.out.println("=== Day 04 - Assignment 1: Employee Salary Calculation ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Run with interactive user input? (y/n, default n for demo): ");
        String choice = sc.hasNextLine() ? sc.nextLine().trim() : "n";

        Employee emp = new Employee();

        if (choice.equalsIgnoreCase("y")) {
            emp.read();
        } else {
            System.out.println("Running with sample data...");
            emp.read(1001, "Vikramaditya Roy", 55000.0, 11000.0, 5500.0);
        }

        emp.calculateSalary();
        emp.display();
    }
}
