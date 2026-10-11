package com.cdac.exam_prep;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================================
 *               CDAC PGCP-AI JAVA LAB TEST: PREDICTED MASTER QUESTION
 * ============================================================================
 * TOTAL: 20 MARKS
 * 
 * [PART 1 - 10 MARKS: OOPs Principles]
 * 1. Base Class: Employee (empno, name, basicSal)
 * 2. Derived Class: Manager extends Employee (adds bonus, uses super(...) constructor)
 * 3. Method Overriding: calculateTotalSalary() & display()
 * 4. Runtime Polymorphism: Manager treated as Employee inside ArrayList
 * 
 * [PART 2 - 10 MARKS: ArrayList CRUD Operations]
 * 1. Create: ArrayList<Employee> storing Employee and Manager objects
 * 2. Read: Display all employees using for-each loop
 * 3. Search: Search employee by empno
 * 4. Update: Update salary by empno
 * 5. Delete: Remove employee by empno
 * ============================================================================
 */

// -------------------------------------------------------------
// PART 1: OOPs HIERARCHY (10 MARKS)
// -------------------------------------------------------------

// Base Class: Employee
class Employee {
    int empno;
    String name;
    double basicSal;

    // Parameterized Constructor
    public Employee(int empno, String name, double basicSal) {
        this.empno = empno;
        this.name = name;
        this.basicSal = basicSal;
    }

    // Method to calculate total salary (can be overridden)
    public double calculateTotalSalary() {
        return basicSal;
    }

    // Display method
    public void display() {
        System.out.printf("[EMPLOYEE] ID: %-4d | Name: %-15s | Basic: Rs.%-8.2f | Total: Rs.%.2f\n",
                empno, name, basicSal, calculateTotalSalary());
    }
}

// Derived Class: Manager (Demonstrates Inheritance & Method Overriding)
class Manager extends Employee {
    double bonus;

    // Subclass constructor using 'super'
    public Manager(int empno, String name, double basicSal, double bonus) {
        super(empno, name, basicSal); // Calls Employee constructor
        this.bonus = bonus;
    }

    // Method Overriding (Polymorphism)
    @Override
    public double calculateTotalSalary() {
        return basicSal + bonus;
    }

    // Overriding display method
    @Override
    public void display() {
        System.out.printf("[MANAGER]  ID: %-4d | Name: %-15s | Basic: Rs.%-8.2f | Bonus: Rs.%-6.2f | Total: Rs.%.2f\n",
                empno, name, basicSal, bonus, calculateTotalSalary());
    }
}

// -------------------------------------------------------------
// PART 2: ARRAYLIST CRUD & MENU DRIVEN SYSTEM (10 MARKS)
// -------------------------------------------------------------

public class EmployeeMasterExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generic ArrayList storing Employee (and Manager through polymorphism)
        ArrayList<Employee> empList = new ArrayList<>();

        // 1. Pre-populated sample data (Matches Sir's classroom examples)
        empList.add(new Employee(1001, "Amit Sharma", 40000));
        empList.add(new Manager(1002, "Priya Verma", 65000, 15000));
        empList.add(new Employee(1003, "Rahul Nair", 45000));
        empList.add(new Manager(1004, "Sneha Patel", 70000, 20000));

        System.out.println("===============================================================");
        System.out.println("     CDAC JAVA EXAM: EMPLOYEE MANAGEMENT SYSTEM (OOPs + CRUD)  ");
        System.out.println("===============================================================");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n----------------- SELECT AN OPERATION -----------------");
            System.out.println("1. Display All Employees (Read)");
            System.out.println("2. Add Employee / Manager (Create)");
            System.out.println("3. Search Employee by ID (Search)");
            System.out.println("4. Update Salary by ID (Update)");
            System.out.println("5. Delete Employee by ID (Delete)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (!sc.hasNextInt()) {
                System.out.println("Exiting system.");
                break;
            }

            int choice = sc.nextInt();

            switch (choice) {

                // 1. READ: Display all using for-each loop
                case 1:
                    System.out.println("\n--- Current Employee List ---");
                    if (empList.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Employee emp : empList) {
                            emp.display(); // Polymorphic call (calls Manager.display() or Employee.display())
                        }
                    }
                    break;

                // 2. CREATE: Add new Employee or Manager
                case 2:
                    System.out.println("\nSelect Employee Type:");
                    System.out.println("a) Regular Employee");
                    System.out.println("b) Manager");
                    System.out.print("Choice (a/b): ");
                    char type = sc.next().charAt(0);

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    if (type == 'b' || type == 'B') {
                        System.out.print("Enter Bonus: ");
                        double bonus = sc.nextDouble();
                        empList.add(new Manager(id, name, salary, bonus));
                        System.out.println("Manager added successfully!");
                    } else {
                        empList.add(new Employee(id, name, salary));
                        System.out.println("Employee added successfully!");
                    }
                    break;

                // 3. SEARCH: Search by ID
                case 3:
                    System.out.print("\nEnter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Employee emp : empList) {
                        if (emp.empno == searchId) {
                            System.out.println("Record Found:");
                            emp.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                    break;

                // 4. UPDATE: Update Salary
                case 4:
                    System.out.print("\nEnter Employee ID to update salary: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;

                    for (Employee emp : empList) {
                        if (emp.empno == updateId) {
                            System.out.print("Enter New Basic Salary: ");
                            double newSal = sc.nextDouble();
                            emp.basicSal = newSal;
                            System.out.println("Salary updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee ID " + updateId + " not found.");
                    }
                    break;

                // 5. DELETE: Remove by ID
                case 5:
                    System.out.print("\nEnter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    int removeIndex = -1;

                    for (int i = 0; i < empList.size(); i++) {
                        if (empList.get(i).empno == delId) {
                            removeIndex = i;
                            break;
                        }
                    }

                    if (removeIndex != -1) {
                        Employee removedEmp = empList.remove(removeIndex);
                        System.out.println("Removed: " + removedEmp.name + " (ID: " + removedEmp.empno + ")");
                    } else {
                        System.out.println("Employee ID " + delId + " not found.");
                    }
                    break;

                // 6. EXIT
                case 6:
                    System.out.println("Exiting test application. All the best!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option! Please enter 1 to 6.");
            }
        }

        sc.close();
    }
}
