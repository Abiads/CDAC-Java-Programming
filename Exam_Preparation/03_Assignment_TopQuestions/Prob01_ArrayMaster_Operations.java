import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: Core Array Manipulations (High-Probability Assignment Problem)
 * Problem 1: Master Array Operations Program
 * 
 * Combines Day 03 and Day 04 Assignment Questions:
 * - Q1: Sum and Average of Elements
 * - Q2: Min and Max Element Identification
 * - Q3: Search Element (Linear Search)
 * - Q6: Find and Display Duplicate Elements
 * ============================================================================
 */

public class Prob01_ArrayMaster_Operations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("       TARGETED EXAM PREP: ARRAY OPERATIONS      ");
        System.out.println("=================================================");

        System.out.print("Enter number of elements (size of array): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be greater than 0.");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element [" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        // 1. Display Array
        System.out.print("\nArray elements: [ ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("]");

        // 2. Sum and Average
        int sum = 0;
        int min = arr[0];
        int max = arr[0];

        for (int val : arr) {
            sum += val;
            if (val < min) {
                min = val;
            }
            if (val > max) {
                max = val;
            }
        }
        double avg = (double) sum / n;

        System.out.println("\n--- Basic Statistics ---");
        System.out.println("Sum of elements     : " + sum);
        System.out.printf("Average of elements : %.2f\n", avg);
        System.out.println("Minimum element     : " + min);
        System.out.println("Maximum element     : " + max);

        // 3. Linear Search
        System.out.print("\nEnter element to search: ");
        int target = sc.nextInt();
        int foundIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) {
            System.out.println("Element " + target + " found at index " + foundIndex);
        } else {
            System.out.println("Element " + target + " is NOT present in the array.");
        }

        // 4. Find Duplicate Elements (Day 03 Q6)
        System.out.print("\nDuplicate elements in the array: ");
        boolean hasDuplicates = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    // Check if already printed earlier
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < i; k++) {
                        if (arr[k] == arr[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        System.out.print(arr[i] + " ");
                        hasDuplicates = true;
                    }
                    break;
                }
            }
        }
        if (!hasDuplicates) {
            System.out.print("None");
        }
        System.out.println();

        sc.close();
    }
}
