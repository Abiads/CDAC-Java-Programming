import java.util.Scanner;

public class Q05_CheckVotingEligibility {

    public static boolean isEligible(int age) {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        boolean eligible = isEligible(age);

        if (eligible) {
            System.out.println("The person is eligible to vote.");
        } else {
            System.out.println("The person is NOT eligible to vote.");
        }
        sc.close();
    }
}
