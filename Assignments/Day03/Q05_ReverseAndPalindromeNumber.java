import java.util.Scanner;

public class Q05_ReverseAndPalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        int temp = n;
        int rev = 0;

        while (temp != 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }

        System.out.println("Original Number: " + n);
        System.out.println("Reversed Number: " + rev);

        if (n == rev) {
            System.out.println(n + " is a Palindrome Number.");
        } else {
            System.out.println(n + " is NOT a Palindrome Number.");
        }
        sc.close();
    }
}
