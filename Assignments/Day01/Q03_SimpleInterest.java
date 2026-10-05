import java.util.Scanner;

public class Q03_SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double p = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double r = sc.nextDouble();

        System.out.print("Enter Time in years: ");
        double t = sc.nextDouble();

        double si = (p * r * t) / 100;
        double amount = p + si;

        System.out.println("Simple Interest: " + si);
        System.out.println("Total Amount: " + amount);
        sc.close();
    }
}
