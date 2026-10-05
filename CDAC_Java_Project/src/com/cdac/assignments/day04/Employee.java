package com.cdac.assignments.day04;

import java.util.Scanner;

public class Employee {
    int empId;
    String empName;
    double basicSalary;
    double hra;
    double da;
    double grossSalary;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        empName = sc.next();
        System.out.print("Enter Basic Salary: ");
        basicSalary = sc.nextDouble();
        System.out.print("Enter HRA: ");
        hra = sc.nextDouble();
        System.out.print("Enter DA: ");
        da = sc.nextDouble();
        sc.close();
    }

    public void calculateSalary() {
        grossSalary = basicSalary + hra + da;
    }

    public void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("HRA           : " + hra);
        System.out.println("DA            : " + da);
        System.out.println("Gross Salary  : " + grossSalary);
    }
}
