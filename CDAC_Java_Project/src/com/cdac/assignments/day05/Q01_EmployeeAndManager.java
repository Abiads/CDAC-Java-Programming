package com.cdac.assignments.day05;

import java.util.Scanner;

// Superclass
class Employee {
    int employeeId;
    String employeeName;
    double basicSalary;

    // Parameterized constructor
    Employee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Basic Salary  : " + basicSalary);
    }
}

// Subclass demonstrating Simple Inheritance
class Manager extends Employee {
    String department;
    double bonus;

    // Constructor using super() to initialize superclass properties
    Manager(int employeeId, String employeeName, double basicSalary, String department, double bonus) {
        super(employeeId, employeeName, basicSalary);
        this.department = department;
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return calculateSalary() + bonus;
    }

    void displayManagerDetails() {
        System.out.println("--- Manager Details ---");
        displayEmployeeDetails();
        System.out.println("Department    : " + department);
        System.out.println("Bonus         : " + bonus);
        System.out.println("Total Salary  : " + calculateTotalSalary());
    }
}

public class Q01_EmployeeAndManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        Manager mgr = new Manager(id, name, salary, dept, bonus);
        System.out.println();
        mgr.displayManagerDetails();

        sc.close();
    }
}
