package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Assignment 4 - Problem 1: Employee Salary Calculation
 *
 * Requirements:
 * - Data members: Employee ID, Employee Name, Basic Salary, HRA, DA
 * - Methods:
 *     read() - to read employee details
 *     calculateSalary() - to calculate gross salary (Gross Salary = Basic Salary + HRA + DA)
 *     display() - to display employee details and gross salary
 * - Create an object of the Employee class and display the result.
 */
public class Employee {

    private int empId;
    private String empName;
    private double basicSalary;
    private double hra;
    private double da;
    private double grossSalary;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int empId, String empName, double basicSalary, double hra, double da) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.grossSalary = calculateSalary();
    }

    // Interactive read method using Scanner
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Enter Employee Details -----");
        System.out.print("Enter Employee ID: ");
        this.empId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        this.empName = sc.nextLine();

        System.out.print("Enter Basic Salary (₹): ");
        this.basicSalary = sc.nextDouble();

        System.out.print("Enter HRA (₹): ");
        this.hra = sc.nextDouble();

        System.out.print("Enter DA (₹): ");
        this.da = sc.nextDouble();

        this.grossSalary = calculateSalary();
    }

    // Overloaded programmatic read method
    public void read(int empId, String empName, double basicSalary, double hra, double da) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.grossSalary = calculateSalary();
    }

    // Method to calculate gross salary
    public double calculateSalary() {
        this.grossSalary = this.basicSalary + this.hra + this.da;
        return this.grossSalary;
    }

    // Method to display employee details and gross salary
    public void display() {
        System.out.println("\n========== Employee Details ==========");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.printf("Basic Salary  : ₹%.2f%n", basicSalary);
        System.out.printf("HRA           : ₹%.2f%n", hra);
        System.out.printf("DA            : ₹%.2f%n", da);
        System.out.println("--------------------------------------");
        System.out.printf("Gross Salary  : ₹%.2f%n", grossSalary);
        System.out.println("======================================");
    }

    // Getters and Setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }

    public double getGrossSalary() { return grossSalary; }

    // Standalone runner for quick Eclipse execution
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.read(101, "Aarav Sharma", 45000.0, 9000.0, 4500.0);
        emp.display();
    }
}
