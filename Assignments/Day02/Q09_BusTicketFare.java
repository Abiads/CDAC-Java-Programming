import java.util.Scanner;

public class Q09_BusTicketFare {

    public static int calculateFare(int age) {
        if (age < 5) {
            return 0;
        } else if (age <= 12) {
            return 20;
        } else if (age <= 59) {
            return 40;
        } else {
            return 25;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter passenger name: ");
        String name = sc.next();

        System.out.print("Enter passenger age: ");
        int age = sc.nextInt();

        int fare = calculateFare(age);

        System.out.println("Passenger Name: " + name);
        System.out.println("Age: " + age);
        if (fare == 0) {
            System.out.println("Bus Fare: Free (₹0)");
        } else {
            System.out.println("Bus Fare: ₹" + fare);
        }
        sc.close();
    }
}
