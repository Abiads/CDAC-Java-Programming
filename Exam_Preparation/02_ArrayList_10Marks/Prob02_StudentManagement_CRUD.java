import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: ArrayList Custom Objects & Aggregations (10 Marks Target)
 * Problem 2: Student Management System using ArrayList
 * 
 * Based directly on Sir's classroom example (ArrayListExample.java):
 * 1. Store Student records: rollNo (sid), name (sname), marks (mark)
 * 2. Search student by roll number
 * 3. Update marks of a student
 * 4. Find the student with highest marks
 * 5. Calculate average marks of the class
 * ============================================================================
 */

class StudentRecord {
    int sid;
    String sname;
    double mark;

    public StudentRecord(int sid, String sname, double mark) {
        this.sid = sid;
        this.sname = sname;
        this.mark = mark;
    }

    public void display() {
        System.out.println("Roll No: " + sid + " | Name: " + sname + " | Marks: " + mark);
    }
}

public class Prob02_StudentManagement_CRUD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentRecord> studentList = new ArrayList<>();

        // 1. Initial Students (matching sir's pattern)
        studentList.add(new StudentRecord(101, "Aarav Sharma", 88.5));
        studentList.add(new StudentRecord(102, "Bhavna Rao", 92.0));
        studentList.add(new StudentRecord(103, "Chetan Das", 74.0));
        studentList.add(new StudentRecord(104, "Divya Singh", 95.5));

        System.out.println("=================================================");
        System.out.println("    STUDENT MANAGEMENT SYSTEM (ArrayList)        ");
        System.out.println("=================================================");

        // 2. Display all students
        System.out.println("\n--- All Students in Class ---");
        for (StudentRecord s : studentList) {
            s.display();
        }

        // 3. Search and Update Marks (Sir's favorite question)
        System.out.print("\nEnter Roll No to update marks: ");
        if (sc.hasNextInt()) {
            int rollToUpdate = sc.nextInt();
            System.out.print("Enter New Marks: ");
            double newMarks = sc.nextDouble();

            boolean found = false;
            for (StudentRecord s : studentList) {
                if (s.sid == rollToUpdate) {
                    s.mark = newMarks;
                    found = true;
                    System.out.println("Marks updated successfully for " + s.sname + "!");
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with Roll No " + rollToUpdate + " not found.");
            }
        }

        // 4. Display list after update
        System.out.println("\n--- Student List After Update ---");
        for (StudentRecord s : studentList) {
            s.display();
        }

        // 5. Aggregate: Highest Marks and Class Average (frequently asked bonus)
        if (!studentList.isEmpty()) {
            StudentRecord topper = studentList.get(0);
            double totalMarks = 0;

            for (StudentRecord s : studentList) {
                totalMarks += s.mark;
                if (s.mark > topper.mark) {
                    topper = s;
                }
            }

            double average = totalMarks / studentList.size();

            System.out.println("\n--- Class Performance Summary ---");
            System.out.println("Total Students : " + studentList.size());
            System.out.printf("Class Average  : %.2f\n", average);
            System.out.println("Class Topper   : " + topper.sname + " (Roll No: " + topper.sid + ") with " + topper.mark + " marks");
        }

        // 6. Delete a student
        System.out.print("\nEnter Roll No of student leaving class (delete): ");
        if (sc.hasNextInt()) {
            int rollToDelete = sc.nextInt();
            int deleteIndex = -1;

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).sid == rollToDelete) {
                    deleteIndex = i;
                    break;
                }
            }

            if (deleteIndex != -1) {
                StudentRecord removed = studentList.remove(deleteIndex);
                System.out.println("Student " + removed.sname + " removed from list.");
            } else {
                System.out.println("Student not found.");
            }
        }

        System.out.println("\n--- Final Student List ---");
        for (StudentRecord s : studentList) {
            s.display();
        }

        sc.close();
    }
}
