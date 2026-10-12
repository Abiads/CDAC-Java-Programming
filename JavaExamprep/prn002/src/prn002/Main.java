package prn002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService s = new EmployeeService();
        s.addEmployee(new Employee(1, "John Doe", 50000));
		s.addEmployee(new Employee(2, "Jane Smith", 60000));
		s.addEmployee(new Employee(3, "Alice Johnson", 55000));
		s.addEmployee(new Employee(4, "Bob Brown", 70000));
		s.addEmployee(new Employee(5, "Charlie Davis", 65000));

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search");
            System.out.println("4.Update 5.Delete 6.Count 7.Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    s.addEmployee(
                        new Employee(id, name, salary)
                    );
                    break;

                case 2:
                    s.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Employee e = s.search(sc.nextInt());

                    if (e != null) {
                        e.display();
                    } else {
                        System.out.println("Not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new name: ");
                    String uname = sc.next();

                    System.out.print("Enter new salary: ");
                    double usalary = sc.nextDouble();

                    s.update(uid, uname, usalary);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    s.delete(sc.nextInt());
                    break;

                case 6:
                    s.count();
                    break;

                case 7:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}