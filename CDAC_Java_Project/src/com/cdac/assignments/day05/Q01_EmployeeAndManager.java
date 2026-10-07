package com.cdac.assignments.day05;

class Employee {
    int employeeId;
    String employeeName;
    double basicSalary;

    Employee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class Manager extends Employee {
    String department;
    double bonus;

    Manager(int employeeId, String employeeName, double basicSalary, String department, double bonus) {
        super(employeeId, employeeName, basicSalary);
        this.department = department;
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return calculateSalary() + bonus;
    }

    void displayManagerDetails() {
        displayEmployeeDetails();
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + calculateTotalSalary());
    }
}

public class Q01_EmployeeAndManager {
    public static void main(String[] args) {
        Manager m = new Manager(101, "Rahul Sharma", 50000, "IT", 12000);
        m.displayManagerDetails();
    }
}
