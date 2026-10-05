import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    double basicSalary;
    double hra;
    double da;
    double grossSalary;

    void read() {
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
    }

    void calculateSalary() {
        grossSalary = basicSalary + hra + da;
    }

    void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("HRA           : " + hra);
        System.out.println("DA            : " + da);
        System.out.println("Gross Salary  : " + grossSalary);
    }
}

public class Q01_EmployeeSalary {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.read();
        emp.calculateSalary();
        emp.display();
    }
}
