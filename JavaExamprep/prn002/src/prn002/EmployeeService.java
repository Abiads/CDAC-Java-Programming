package prn002;

import java.util.ArrayList;

public class EmployeeService {
    public ArrayList<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added");
    }

    // Read all
    public void displayAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }

        for (Employee e : employees) {
            e.display();
        }
    }

    // Search by ID
    public Employee search(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    // Update
    public void update(int id, String name, double salary) {
        Employee e = search(id);

        if (e != null) {
            e.name = name;
            e.salary = salary;
            System.out.println("Employee updated");
        } else {
            System.out.println("Employee not found");
        }
    }

    // Delete
    public void delete(int id) {
        Employee e = search(id);

        if (e != null) {
            employees.remove(e);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
    }

    // Count
    public void count() {
        System.out.println("Total employees: " + employees.size());
    }
}
