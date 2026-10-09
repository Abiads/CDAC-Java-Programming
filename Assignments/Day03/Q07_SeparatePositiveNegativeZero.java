import java.util.Scanner;

public class Q07_SeparatePositiveNegativeZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print Positive numbers
        System.out.print("Positive numbers: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        // Print Negative numbers
        System.out.print("Negative numbers: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        // Count Zero values
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }
        System.out.println("Zero values: " + zeroCount);

        sc.close();
    }
}
