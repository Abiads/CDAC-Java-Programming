import java.util.Scanner;

public class Q10_MobileDataUsage {

    public static double calculateCharge(double dataGB) {
        if (dataGB <= 1) {
            return 50;
        } else if (dataGB <= 5) {
            return 100;
        } else if (dataGB <= 10) {
            return 200;
        } else {
            return 350;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mobile number: ");
        long mobileNumber = sc.nextLong();

        System.out.print("Enter data usage in GB: ");
        double dataGB = sc.nextDouble();

        double charge = calculateCharge(dataGB);

        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Data Consumed: " + dataGB + " GB");
        System.out.println("Total Charge: ₹" + charge);
        sc.close();
    }
}
