# CDAC PGCP-AI Java Lab Test: Targeted 1-Question Preparation Guide

## 1. Why Eclipse IDE Doesn't Show Changed Files & How to Fix It

### Reason 1: Eclipse Does Not Auto-Scan the Disk
Eclipse caches project files in its internal memory (`.metadata`). When files are changed or created externally, Eclipse keeps showing the old cached state.

**Fix (Takes 2 seconds):**
1. In Eclipse, look at the **Package Explorer** on the left.
2. Click on **`CDAC_Java_Project`**.
3. Press **`F5`** on your keyboard (or **Right Click -> Refresh**).
   *All updated files and packages will immediately show up!*

**Permanent Fix (Enable Auto-Refresh):**
- In Eclipse top menu: **Window** -> **Preferences** -> **General** -> **Workspace**.
- Check **`Refresh using native hooks or polling`** and **`Refresh on access`**.
- Click **Apply and Close**.

### Reason 2: Project Root vs Subfolder
Eclipse expects Java source files to live under `src/`. We have placed the master test question directly inside:
```
CDAC_Java_Project/src/com/cdac/exam_prep/EmployeeMasterExam.java
```
Once you press **F5**, expand:
`CDAC_Java_Project` -> `src` -> `com.cdac.exam_prep` -> `EmployeeMasterExam.java`.

---

## 2. The 1 Single Predicted Question: Employee Management System (20 Marks)

This single program combines **OOPs (10 Marks)** and **ArrayList CRUD (10 Marks)** into one cohesive question:

### Mark Distribution Breakdown:
| Component | Topic | What Evaluator Looks For | Marks |
| :--- | :--- | :--- | :--- |
| **Part 1** | **OOPs Principles** | Class `Employee`, Subclass `Manager extends Employee`, `super(...)` constructor chaining, `@Override calculateTotalSalary()`, Runtime Polymorphism | **10 Marks** |
| **Part 2** | **ArrayList CRUD** | `ArrayList<Employee>`, `add()`, for-each loop display, search by `empno`, update salary, delete by `empno` | **10 Marks** |
| **Total** | | | **20 Marks** |

---

## 3. The Complete Code to Memorize / Practice

File: [`CDAC_Java_Project/src/com/cdac/exam_prep/EmployeeMasterExam.java`](file:///c:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/exam_prep/EmployeeMasterExam.java)

```java
package com.cdac.exam_prep;

import java.util.ArrayList;
import java.util.Scanner;

// ==========================================
// PART 1: OOPs HIERARCHY (10 MARKS)
// ==========================================

// Base Class
class Employee {
    int empno;
    String name;
    double basicSal;

    public Employee(int empno, String name, double basicSal) {
        this.empno = empno;
        this.name = name;
        this.basicSal = basicSal;
    }

    public double calculateTotalSalary() {
        return basicSal;
    }

    public void display() {
        System.out.printf("[EMPLOYEE] ID: %-4d | Name: %-15s | Basic: Rs.%-8.2f | Total: Rs.%.2f\n",
                empno, name, basicSal, calculateTotalSalary());
    }
}

// Derived Class (Inheritance + Overriding)
class Manager extends Employee {
    double bonus;

    public Manager(int empno, String name, double basicSal, double bonus) {
        super(empno, name, basicSal); // 'super' calls parent constructor
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return basicSal + bonus;
    }

    @Override
    public void display() {
        System.out.printf("[MANAGER]  ID: %-4d | Name: %-15s | Basic: Rs.%-8.2f | Bonus: Rs.%-6.2f | Total: Rs.%.2f\n",
                empno, name, basicSal, bonus, calculateTotalSalary());
    }
}

// ==========================================
// PART 2: ARRAYLIST CRUD OPERATIONS (10 MARKS)
// ==========================================

public class EmployeeMasterExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();

        // Pre-loaded records (Polymorphism: Manager stored in Employee list)
        empList.add(new Employee(1001, "Amit Sharma", 40000));
        empList.add(new Manager(1002, "Priya Verma", 65000, 15000));
        empList.add(new Employee(1003, "Rahul Nair", 45000));

        boolean running = true;
        while (running) {
            System.out.println("\n--- EMPLOYEE MANAGEMENT MENU ---");
            System.out.println("1. Display All Employees");
            System.out.println("2. Add Employee / Manager");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Salary by ID");
            System.out.println("5. Delete Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();

            switch (choice) {
                // 1. READ
                case 1:
                    System.out.println("\n--- Current Employees ---");
                    for (Employee emp : empList) {
                        emp.display();
                    }
                    break;

                // 2. CREATE
                case 2:
                    System.out.print("Type (1 for Employee, 2 for Manager): ");
                    int type = sc.nextInt();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Basic Salary: ");
                    double sal = sc.nextDouble();

                    if (type == 2) {
                        System.out.print("Enter Bonus: ");
                        double bonus = sc.nextDouble();
                        empList.add(new Manager(id, name, sal, bonus));
                    } else {
                        empList.add(new Employee(id, name, sal));
                    }
                    System.out.println("Added successfully!");
                    break;

                // 3. SEARCH
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Employee emp : empList) {
                        if (emp.empno == searchId) {
                            emp.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Employee not found.");
                    break;

                // 4. UPDATE
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;
                    for (Employee emp : empList) {
                        if (emp.empno == updateId) {
                            System.out.print("Enter new basic salary: ");
                            emp.basicSal = sc.nextDouble();
                            System.out.println("Salary updated!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) System.out.println("Employee not found.");
                    break;

                // 5. DELETE
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    int delIndex = -1;
                    for (int i = 0; i < empList.size(); i++) {
                        if (empList.get(i).empno == delId) {
                            delIndex = i;
                            break;
                        }
                    }
                    if (delIndex != -1) {
                        empList.remove(delIndex);
                        System.out.println("Employee deleted successfully!");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                // 6. EXIT
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
```

---

## 4. Eclipse Shortcuts To Code 2x Faster In The Test

1. **`main` + `Ctrl + Space`** -> Generates `public static void main(String[] args)`
2. **`sysout` + `Ctrl + Space`** -> Generates `System.out.println()`
3. **`Ctrl + Shift + O`** -> Automatically imports `ArrayList` and `Scanner`
4. **`Ctrl + Shift + F`** -> Automatically indents and formats all code
5. **`Ctrl + F11`** -> Runs the program immediately
