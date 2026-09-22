package com.cdac.assignments.employee_lab;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Syllabus Lab Assignment (Sessions 7 & 8):
 * Demonstrating data structures to store Employee objects and utilizing
 * java.util properties, Collections, Predicates, Comparators, and Lambdas.
 */
public class EmployeeManagementDemo {

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("  CDAC PGCP-AI: Sessions 7 & 8 Employee Management Lab Demo   ");
        System.out.println("===============================================================\n");

        // 1. Storing Employees in a List (ArrayList)
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(104, "Rahul Sharma", "AI/ML", 85000.0, LocalDate.of(2023, 6, 15)));
        employeeList.add(new Employee(101, "Ananya Sen", "Data Eng", 72000.0, LocalDate.of(2022, 1, 10)));
        employeeList.add(new Employee(105, "Vikram Patil", "AI/ML", 95000.0, LocalDate.of(2021, 3, 20)));
        employeeList.add(new Employee(102, "Sneha Kulkarni", "DevOps", 68000.0, LocalDate.of(2023, 11, 5)));
        employeeList.add(new Employee(103, "Aditya Rao", "Data Eng", 78000.0, LocalDate.of(2022, 8, 12)));

        // 2. Iteration using Java 8 forEach and Lambda
        System.out.println("1. Initial Employee List (Using forEach & Lambda):");
        employeeList.forEach(System.out::println);

        // 3. Natural Sorting using Comparable (by ID)
        Collections.sort(employeeList);
        System.out.println("\n2. Employees Sorted by ID (Natural Order):");
        employeeList.forEach(emp -> System.out.println("   " + emp));

        // 4. Custom Sorting using Comparator (by Salary Descending)
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("\n3. Employees Sorted by Salary (Descending):");
        employeeList.forEach(emp -> System.out.println("   " + emp));

        // 5. Using java.util.function.Predicate to filter high earners
        Predicate<Employee> highEarnerPredicate = emp -> emp.getSalary() >= 80000.0;
        System.out.println("\n4. High Earners (Salary >= Rs. 80,000 using Predicate & Stream):");
        employeeList.stream()
                .filter(highEarnerPredicate)
                .forEach(emp -> System.out.println("   [MATCH] " + emp.getName() + " -> Rs. " + emp.getSalary()));

        // 6. Mapping Employees by ID using Map (HashMap)
        Map<Integer, Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, emp -> emp));

        System.out.println("\n5. Fast Lookup via java.util.Map (Key = ID):");
        int searchId = 105;
        Employee found = employeeMap.get(searchId);
        if (found != null) {
            System.out.println("   Found Employee #" + searchId + ": " + found.getName() + " (" + found.getDepartment() + ")");
        } else {
            System.out.println("   Employee #" + searchId + " not found.");
        }

        // 7. Grouping by Department using java.util.stream.Collectors
        System.out.println("\n6. Grouping Employees by Department:");
        Map<String, List<Employee>> deptGroup = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        deptGroup.forEach((dept, emps) -> {
            System.out.println("   Department: " + dept + " (" + emps.size() + " members)");
            emps.forEach(e -> System.out.println("      - " + e.getName()));
        });

        System.out.println("\n================ Lab Execution Completed ================");
    }
}
