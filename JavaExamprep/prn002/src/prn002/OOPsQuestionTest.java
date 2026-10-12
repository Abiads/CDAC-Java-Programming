
package prn002;

class Employee1 {

    // Private fields: encapsulation
    private int id;
    private String name;

    // Protected field: accessible in subclasses
    protected double salary;

    // Parameterized constructor
    Employee1(int id, String name, double salary) {
        this.id = id;   // this refers to current object's field
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate basic salary
    public double calculateSalary() {
        return salary;
    }

    // Common method inherited by Manager
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);

        // Runtime polymorphism:
        // Calls the overridden method if object is Manager
        System.out.println("Salary: " + calculateSalary());
    }
}

// Child class inherits Employee
class Manager extends Employee1 {

    // Manager-specific field
    private double bonus;

    // Constructor of child class
    Manager(int id, String name, double salary, double bonus) {

        // Calls parent class constructor
        super(id, name, salary);

        this.bonus = bonus;
    }

    // Method overriding
    @Override
    public double calculateSalary() {

        // Manager salary = basic salary + bonus
        return salary + bonus;
    }
}

public class OOPsQuestionTest {

    public static void main(String[] args) {

        // Create Employee object
        Employee1 emp = new Employee1(1, "John Doe", 50000);
        emp.display();

        System.out.println();

        // Parent reference holding child object
        Employee1 mgr = new Manager(2, "Jane Smith", 60000, 10000);
        mgr.display();
    }
}
