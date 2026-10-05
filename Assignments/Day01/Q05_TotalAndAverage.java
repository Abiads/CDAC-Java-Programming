import java.util.Scanner;

public class Q05_TotalAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks for subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter marks for subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter marks for subject 3: ");
        int m3 = sc.nextInt();

        int total = m1 + m2 + m3;
        double average = total / 3.0;

        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        sc.close();
    }
}
