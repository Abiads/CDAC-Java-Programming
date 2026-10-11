import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: Exception Handling & Business Logic (10 Marks Target)
 * Problem 2: Electricity Bill Calculation with Custom Exception
 * 
 * Based on Day 07 Assignment Question 3 & Day 06 Overloading:
 * 1. Custom Exception: InvalidUnitsException for negative units
 * 2. Tiered Slab Calculation:
 *    - Up to 100 units   : Rs. 1.50 / unit
 *    - 101 to 200 units  : Rs. 2.50 / unit
 *    - 201 to 500 units  : Rs. 4.00 / unit
 *    - Above 500 units   : Rs. 6.50 / unit
 *    - Fixed meter charge: Rs. 50.00
 * 3. try-catch-finally block to handle both InputMismatchException and InvalidUnitsException
 * ============================================================================
 */

// Custom Checked Exception
class InvalidUnitsException extends Exception {
    public InvalidUnitsException(String message) {
        super(message);
    }
}

public class Prob02_ElectricityBill_ExceptionHandling {

    // Method to calculate bill, throws InvalidUnitsException
    public static double calculateBill(double units) throws InvalidUnitsException {
        if (units < 0) {
            throw new InvalidUnitsException("Meter units cannot be negative! Received: " + units);
        }

        double bill = 0.0;
        final double FIXED_METER_CHARGE = 50.0;

        if (units <= 100) {
            bill = units * 1.50;
        } else if (units <= 200) {
            bill = (100 * 1.50) + ((units - 100) * 2.50);
        } else if (units <= 500) {
            bill = (100 * 1.50) + (100 * 2.50) + ((units - 200) * 4.00);
        } else {
            bill = (100 * 1.50) + (100 * 2.50) + (300 * 4.00) + ((units - 500) * 6.50);
        }

        return bill + FIXED_METER_CHARGE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("     ELECTRICITY BILLING WITH EXCEPTION HANDLING ");
        System.out.println("=================================================");

        try {
            System.out.print("Enter Consumer ID: ");
            int consumerId = sc.nextInt();

            System.out.print("Enter Consumer Name: ");
            String consumerName = sc.next();

            System.out.print("Enter Units Consumed: ");
            double units = sc.nextDouble();

            double totalBill = calculateBill(units);

            System.out.println("\n--- Electricity Bill Receipt ---");
            System.out.println("Consumer ID   : " + consumerId);
            System.out.println("Consumer Name : " + consumerName);
            System.out.println("Units Consumed: " + units);
            System.out.printf("Total Payable : Rs. %.2f (Includes Rs. 50 Fixed Charge)\n", totalBill);

        } catch (InputMismatchException e) {
            System.err.println("\n[ERROR] Input Mismatch: Please enter numbers in the correct numeric format.");
        } catch (InvalidUnitsException e) {
            System.err.println("\n[ERROR] Validation Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n[ERROR] Unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("\nBilling execution completed. Closing scanner resource.");
            sc.close();
        }
    }
}
