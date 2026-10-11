import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: ArrayList CRUD Operations (10 Marks Target)
 * Problem 1: Employee Management System using ArrayList
 * 
 * Concepts Demonstrated:
 * 1. Creating ArrayList of custom objects (ArrayList<Employee>)
 * 2. Adding objects (Create - C)
 * 3. Displaying all objects with for-each loop (Read - R)
 * 4. Searching object by empno (Search)
 * 5. Updating salary of an employee (Update - U)
 * 6. Deleting employee by empno (Delete - D)
 * ============================================================================
 */

// Model Class
class Employee {
    int empno;
    String name;
    double sal;

    // Parameterized constructor
    public Employee(int empno, String name, double sal) {
        this.empno = empno;
        this.name = name;
        this.sal = sal;
    }

    // Display method
    public void displayEmp() {
        System.out.println("ID: " + empno + " | Name: " + name + " | Salary: Rs." + sal);
    }
}

public class Prob01_EmployeeManagement_FullCRUD {

    // 1. CREATE: Initialize and return an ArrayList with initial employees
    public static ArrayList<Employee> createEmpList() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "Amit Sharma", 45000));
        list.add(new Employee(1002, "Priya Verma", 52000));
        list.add(new Employee(1003, "Rahul Nair", 60000));
        list.add(new Employee(1004, "Sneha Patel", 48000));
        return list;
    }

    // 2. READ: Display all employees
    public static void displayEmpList(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("No employees found in the list.");
            return;
        }
        System.out.println("\n--- Current Employee List ---");
        for (Employee emp : list) {
            emp.displayEmp();
        }
    }

    // 3. SEARCH: Search by employee number
    public static Employee searchEmployee(ArrayList<Employee> list, int empno) {
        for (Employee emp : list) {
            if (emp.empno == empno) {
                return emp;
            }
        }
        return null;
    }

    // 4. UPDATE: Update employee salary
    public static boolean updateSalary(ArrayList<Employee> list, int empno, double newSal) {
        for (Employee emp : list) {
            if (emp.empno == empno) {
                emp.sal = newSal;
                return true;
            }
        }
        return false;
    }

    // 5. DELETE: Remove employee by empno
    public static boolean deleteEmployee(ArrayList<Employee> list, int empno) {
        int indexToDelete = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).empno == empno) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            list.remove(indexToDelete);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = createEmpList();

        System.out.println("=================================================");
        System.out.println("   EMPLOYEE MANAGEMENT SYSTEM (ArrayList CRUD)  ");
        System.out.println("=================================================");

        // Display initial employees
        displayEmpList(empList);

        // Menu driven loop
        boolean running = true;
        while (running) {
            System.out.println("\n-------------------------------------------------");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (!sc.hasNextInt()) {
                System.out.println("Exiting program.");
                break;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    empList.add(new Employee(id, name, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    displayEmpList(empList);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    Employee found = searchEmployee(empList, searchId);
                    if (found != null) {
                        System.out.println("Employee Found:");
                        found.displayEmp();
                    } else {
                        System.out.println("Employee with ID " + searchId + " NOT found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    if (updateSalary(empList, updateId, newSal)) {
                        System.out.println("Salary updated successfully!");
                    } else {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    if (deleteEmployee(empList, delId)) {
                        System.out.println("Employee deleted successfully!");
                    } else {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Best of luck for the test!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose between 1 and 6.");
            }
        }

        sc.close();
    }
}
