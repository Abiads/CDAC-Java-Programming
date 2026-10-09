import java.util.Scanner;

public class Q06_FindDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Duplicate elements:");
        for (int i = 0; i < n; i++) {
            // Check if already printed earlier
            boolean alreadySeen = false;
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    alreadySeen = true;
                    break;
                }
            }
            if (alreadySeen) {
                continue;
            }

            // Check if it appears later in the array
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    break;
                }
            }
        }

        sc.close();
    }
}
