package com.cdac.practice.module02_exceptions;

/**
 * Demonstrates nested try-catch blocks where an outer block handles array bounds
 * and inner blocks handle numeric format conversions and arithmetic operations.
 */
public class NestedTryCatchDemo {

    public static void main(String[] args) {
        System.out.println("=== Nested Try-Catch Demonstration ===\n");

        String[][] testBatches = {
            {"100", "25"},       // Valid: 100 / 25 = 4
            {"200", "0"},        // Inner error: ArithmeticException (division by zero)
            {"300", "abc"},      // Inner error: NumberFormatException
            {"500"}              // Outer error: ArrayIndexOutOfBoundsException
        };

        for (int i = 0; i <= testBatches.length; i++) { // Intentional <= to also trigger outer loop boundary
            System.out.println("Processing Batch #" + i + ":");
            // Outer try block: handles array index access errors
            try {
                String[] batch = testBatches[i];
                String numStr = batch[0];
                String denStr = batch[1]; // Might throw ArrayIndexOutOfBoundsException for batch 3

                // Inner try block: handles number parsing and division
                try {
                    int numerator = Integer.parseInt(numStr);
                    int denominator = Integer.parseInt(denStr);
                    int quotient = numerator / denominator;
                    System.out.println("  Result: " + numerator + " / " + denominator + " = " + quotient);
                } catch (NumberFormatException nfe) {
                    System.out.println("  [Inner Catch] NumberFormatException: Input cannot be parsed to an int -> " + nfe.getMessage());
                } catch (ArithmeticException ae) {
                    System.out.println("  [Inner Catch] ArithmeticException: Cannot divide by zero -> " + ae.getMessage());
                } finally {
                    System.out.println("  [Inner Finally] Finished computation attempt for Batch #" + i);
                }

            } catch (ArrayIndexOutOfBoundsException aiobe) {
                System.out.println("  [Outer Catch] ArrayIndexOutOfBoundsException: Missing batch arguments -> " + aiobe.getMessage());
            } finally {
                System.out.println("  [Outer Finally] Completed processing for iteration " + i + "\n");
            }
        }
    }
}
