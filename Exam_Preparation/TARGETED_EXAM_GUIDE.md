# CDAC PGCP-AI Java Lab Test: Targeted 1-Question Preparation Guide

---

## 1. Eclipse IDE Troubleshooting: Fix Refresh & Autocomplete

### 1.1 Why Eclipse Doesn't Show Changed / New Files (Fix in 2 Seconds)
Eclipse caches project files in its internal memory (`.metadata`). When files are changed or created externally (via Git, VS Code, or terminal), Eclipse keeps showing the old cached state.

* **Quick Fix (Takes 2 seconds):**
  1. In Eclipse, look at the **Package Explorer** on the left.
  2. Click on **`CDAC_Java_Project`**.
  3. Press **`F5`** on your keyboard (or **Right Click &rarr; Refresh**).
  *All updated files and packages will immediately appear!*
* **Permanent Fix (Auto-Refresh on Change):**
  1. Go to top menu: **Window &rarr; Preferences &rarr; General &rarr; Workspace**.
  2. Check **`Refresh using native hooks or polling`** and **`Refresh on access`**.
  3. Click **Apply and Close**.

---

### 1.2 Why Autocomplete / Content Assist Doesn't Work & How to Fix It

If typing `sysout` or `main` or variable names does not give suggestions, here are the 4 tested fixes:

#### Trick #1: Enable "VS Code-Like" Instant Autocomplete on Every Letter (The Secret Setting)
By default, Eclipse **ONLY** triggers autocomplete when you type a period (`.`). Typing letters like `sys` or `emp` does not show suggestions automatically!

**How to enable automatic suggestions while typing:**
1. In Eclipse, go to top menu: **Window &rarr; Preferences**.
2. Navigate to: **Java &rarr; Editor &rarr; Content Assist**.
3. Under **Auto-Activation**:
   * Check **Enable auto activation**.
   * Change **Auto activation delay (ms)** from `200` to **`40`** (makes it instant).
   * In **Auto activation triggers for Java**, replace the single `.` with:
     ```
     .abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_
     ```
4. Click **Apply and Close**.
> *(Now as soon as you type ANY letter like `s` or `E` or `m`, Eclipse automatically pops up the completion menu instantly!)*

---

#### Trick #2: Fix the "No Default Proposals" Bug
If pressing `Ctrl + Space` says *"No Default Proposals"*:
1. Go to: **Window &rarr; Preferences &rarr; Java &rarr; Editor &rarr; Content Assist &rarr; Advanced**.
2. In the top list (*Proposal kinds that will be included in the default list*), make sure the following are **CHECKED**:
   * &#9745; **Java Proposals**
   * &#9745; **Java Proposals (Task Tags)**
   * &#9745; **Template Proposals**
   * &#9745; **Java Type Proposals**
3. Or simply click the **Restore Defaults** button on the bottom right.
4. Click **Apply and Close**.

---

#### Trick #3: When `Ctrl + Space` is Hijacked by Windows (The CDAC Lab Life-Saver)
On many lab computers, Windows Language Bar / Chinese / Japanese IME or Intel Graphics intercepts the `Ctrl + Space` hotkey, so Eclipse never receives the keypress!

* **Life-Saver Alternative Shortcut:** Use **`Alt + /`**!
  * Type `sysout` and press **`Alt + /`** &rarr; immediately expands to `System.out.println()`.
  * Type `main` and press **`Alt + /`** &rarr; immediately expands to `public static void main(String[] args)`.
* **How to bind Content Assist to `Alt + /` permanently:**
  1. Go to: **Window &rarr; Preferences &rarr; General &rarr; Keys**.
  2. In the search box, type `Content Assist`.
  3. Click on **Content Assist**.
  4. In the **Binding** box at the bottom, press **`Alt + /`**.
  5. In **When**, choose **In Windows** (or **Editing Java Source**).
  6. Click **Apply and Close**.

---

#### Trick #4: File Opened in Plain "Text Editor" Instead of "Java Editor"
If your `.java` file has no syntax colors and no autocomplete:
1. Look at the file in **Package Explorer**.
2. **Right Click the file &rarr; Open With &rarr; Java Editor**.

#### Trick #5: Project Build Path Error / Clean Build
If Eclipse has red exclamation marks:
1. Go to menu: **Project &rarr; Clean...**.
2. Select **Clean all projects** &rarr; Click **Clean**.

---

### 1.3 GitHub Copilot: Fix "Model Config" / "Failed to get model config" Error

If GitHub Copilot or Copilot Chat gives a **"Model config"**, **"No model configuration found"**, or **"Error fetching model metadata"** error, use these quick fixes:

#### Fix 1: Sign Out & Re-Authenticate (Fixes 80% of Cases)
Stale auth tokens prevent Copilot from downloading the latest model list:
1. Click the **Accounts** icon (bottom-left gear or profile icon in VS Code).
2. Select your GitHub account &rarr; Click **Sign Out**.
3. In the Command Palette (`Ctrl + Shift + P`), type: `Developer: Reload Window` (or restart the IDE).
4. Click the Copilot icon or prompt &rarr; Sign in to GitHub again.

#### Fix 2: Reset the Chat Model Selection
If Copilot Chat is set to a model your account/organization has disabled (e.g., Claude 3.5 Sonnet / o1):
1. In the Copilot Chat window, check the model dropdown (next to the input box).
2. Switch back to **Default** or **GPT-4o**.
3. If on an organization/enterprise plan, verify model access is turned ON under:
   * **GitHub.com &rarr; Settings &rarr; Copilot &rarr; Model Access**.

#### Fix 3: Update Copilot Extensions
GitHub frequently updates backend model configuration schemas:
1. Open the **Extensions** tab (`Ctrl + Shift + X`).
2. Search `@installed copilot`.
3. Update both **GitHub Copilot** and **GitHub Copilot Chat** to the latest versions.
   *(Tip: If the current release has a known bug, click **Switch to Pre-Release Version**).*

#### Fix 4: Clear Corrupted Copilot Local Storage Cache
If cached configuration JSON is corrupted:
1. Close VS Code completely.
2. Press `Win + R`, paste:
   ```cmd
   %APPDATA%\Code\User\globalStorage
   ```
   and press **Enter**.
3. Delete any folder named `github.copilot` or `github.copilot-chat`.
4. Reopen VS Code and sign in.

#### Fix 5: Campus / CDAC Proxy & SSL Interception
If on campus/lab Wi-Fi that intercepts SSL certificates:
1. Open VS Code Settings (`Ctrl + ,`).
2. Search `proxy strict ssl`.
3. Uncheck **Http: Proxy Strict SSL** (or test temporarily on mobile hotspot).

---

## 2. Eclipse Test-Speed Tricks: Write Your Entire Code in 5 Minutes

 evaluators look for clean, compiling code. Use Eclipse's built-in code generators to write 80% of your code with 2 clicks:

| Task | Eclipse Shortcut / Trick | Result |
| :--- | :--- | :--- |
| **Main Method** | Type `main` + `Ctrl+Space` (or `Alt+/`) + `Enter` | Generates `public static void main(String[] args)` |
| **Print Statement** | Type `syso` or `sysout` + `Ctrl+Space` (or `Alt+/`) | Generates `System.out.println();` |
| **Auto-Import All Classes** | **`Ctrl + Shift + O`** | Imports `ArrayList`, `Scanner` and removes unused imports instantly |
| **Auto-Format & Indent** | **`Ctrl + Shift + F`** | Cleans indentation instantly (evaluators love neat code) |
| **Generate Constructor** | Right Click &rarr; **Source &rarr; Generate Constructor using Fields...** | Creates parameterized constructor without typing a line! |
| **Generate toString()** | Right Click &rarr; **Source &rarr; Generate toString()...** | Generates neat object display method |
| **Override Methods** | Right Click &rarr; **Source &rarr; Override/Implement Methods...** | Generates `@Override` stubs with `super` calls |
| **For-Each Loop** | Type `foreach` + `Ctrl+Space` | Generates `for (Employee emp : empList)` |
| **Run Program** | **`Ctrl + F11`** | Immediately runs the current Java file in Console |

---

## 3. The 1 Single Predicted Question: Employee Management System (20 Marks)

This single program combines **OOPs (10 Marks)** and **ArrayList CRUD (10 Marks)** into one cohesive question:

### Mark Distribution Breakdown:
| Component | Topic | What Evaluator Looks For | Marks |
| :--- | :--- | :--- | :--- |
| **Part 1** | **OOPs Principles** | Class `Employee`, Subclass `Manager extends Employee`, `super(...)` constructor chaining, `@Override calculateTotalSalary()`, Runtime Polymorphism | **10 Marks** |
| **Part 2** | **ArrayList CRUD** | `ArrayList<Employee>`, `add()`, for-each loop display, search by `empno`, update salary, delete by `empno` | **10 Marks** |
| **Total** | | | **20 Marks** |

---

## 4. The Complete Code to Memorize / Practice

File in workspace: [`CDAC_Java_Project/src/com/cdac/exam_prep/EmployeeMasterExam.java`](file:///c:/Users/conne/Downloads/JAVACDAC/CDAC_Java_Project/src/com/cdac/exam_prep/EmployeeMasterExam.java)

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
