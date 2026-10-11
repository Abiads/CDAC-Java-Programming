/**
 * TOPIC: Single Inheritance & Constructor Chaining (10 Marks OOPs Question)
 * 
 * PROBLEM STATEMENT:
 * Create a superclass Employee with properties employeeId, employeeName, and basicSalary.
 * Provide a constructor and methods calculateSalary() and displayEmployeeDetails().
 * 
 * Create a subclass Manager that inherits from Employee.
 * Add properties department and bonus.
 * Use super(...) to initialize parent properties.
 * Provide calculateTotalSalary() and displayManagerDetails().
 * 
 * In main(), create a Manager object and display complete employee details and total salary.
 */

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
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Basic Salary  : Rs. " + basicSalary);
    }
}

class Manager extends Employee {
    String department;
    double bonus;

    Manager(int employeeId, String employeeName, double basicSalary, String department, double bonus) {
        // Calling superclass constructor - MUST be first statement!
        super(employeeId, employeeName, basicSalary);
        this.department = department;
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return calculateSalary() + bonus;
    }

    void displayManagerDetails() {
        // Reusing superclass display method
        displayEmployeeDetails();
        System.out.println("Department    : " + department);
        System.out.println("Bonus         : Rs. " + bonus);
        System.out.println("Total Salary  : Rs. " + calculateTotalSalary());
    }
}

public class Prob01_EmployeeManager_Inheritance {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("        MANAGER DETAILS (SINGLE INHERITANCE)    ");
        System.out.println("================================================");

        Manager mgr = new Manager(101, "Rahul Sharma", 55000.0, "IT Development", 12000.0);
        mgr.displayManagerDetails();

        System.out.println("================================================");
    }
}
