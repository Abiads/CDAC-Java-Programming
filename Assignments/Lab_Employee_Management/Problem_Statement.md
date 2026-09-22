# Lab Assignment: Employee Management System
## Syllabus Sessions 7 & 8 (PGCP-AI)

### Objective
> "Create an appropriate data structure to store your employee object and use the `java.util` package properties."

### Detailed Requirements

1. **Entity Definition (`Employee`)**:
   - Private Fields:
     - `int id`
     - `String name`
     - `String department`
     - `double salary`
     - `LocalDate dateOfJoining`
   - Constructors (Default & Parameterized).
   - Getters, Setters, `toString()`, `equals()`, and `hashCode()` (based on `id`).
   - Implement `Comparable<Employee>` to sort naturally by `id`.

2. **Collection Operations (`EmployeeManagementDemo`)**:
   - Store employees in a `List<Employee>` (`ArrayList`) and unique employees in a `Set<Employee>` (`HashSet`).
   - Key Operations to Demonstrate:
     - **Add**: Adding employees to the list/set.
     - **Iterate**: Using Java 8 `forEach` with lambda expressions and method references.
     - **Search**: Finding an employee by ID using both traditional loop and Stream API `filter`.
     - **Sort**:
       - Natural order by ID (via `Comparable`).
       - Custom sorting by Salary (descending) using `Comparator.comparingDouble(...).reversed()`.
       - Custom sorting by Department and Name.
     - **Filter**: Removing or listing employees earning above a certain threshold (`Predicate`).
     - **Map Storage**: Grouping/mapping employees by ID using `Map<Integer, Employee>` (`HashMap`).

3. **Corresponding Project Implementation**:
   - Model: `com.cdac.assignments.employee_lab.Employee`
   - Demo: `com.cdac.assignments.employee_lab.EmployeeManagementDemo`
