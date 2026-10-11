/**
 * TOPIC: Interface & Runtime Polymorphism (10 Marks OOPs Question)
 * 
 * PROBLEM STATEMENT:
 * Create an interface Payment with methods:
 * 1. void processPayment(double amount);
 * 2. void displayPaymentDetails();
 * 
 * Create two implementing classes:
 * 1. UPIPayment (transactionId, upiId)
 * 2. CardPayment (transactionId, cardNumber)
 * 
 * In main(), demonstrate polymorphic behavior by using Payment interface reference
 * to process payments for both UPI and Card.
 */

interface Payment {
    void processPayment(double amount);
    void displayPaymentDetails();
}

class UPIPayment implements Payment {
    String transactionId;
    String upiId;
    double amountPaid;

    UPIPayment(String transactionId, String upiId) {
        this.transactionId = transactionId;
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        this.amountPaid = amount;
        System.out.println("Initiating UPI transfer of Rs. " + amount + " to VPA: " + upiId);
        System.out.println(">> Payment Status: SUCCESS (Txn ID: " + transactionId + ")");
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Mode           : UPI");
        System.out.println("UPI ID         : " + upiId);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount Paid    : Rs. " + amountPaid);
    }
}

class CardPayment implements Payment {
    String transactionId;
    String cardNumber;
    double amountPaid;

    CardPayment(String transactionId, String cardNumber) {
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        this.amountPaid = amount;
        System.out.println("Routing Card charge of Rs. " + amount + " through Payment Gateway...");
        System.out.println(">> Card Authentication: SUCCESS (Txn ID: " + transactionId + ")");
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Mode           : Credit/Debit Card");
        System.out.println("Card No        : " + cardNumber);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount Paid    : Rs. " + amountPaid);
    }
}

public class Prob04_Payment_Interface {
    public static void main(String[] args) {
        System.out.println("--- 1. UPI PAYMENT VIA INTERFACE REFERENCE ---");
        // Interface Polymorphism: Super-type reference pointing to Sub-type object
        Payment p1 = new UPIPayment("TXN-UPI-5521", "student@okhdfcbank");
        p1.processPayment(3499.0);
        p1.displayPaymentDetails();

        System.out.println("\n--- 2. CARD PAYMENT VIA INTERFACE REFERENCE ---");
        Payment p2 = new CardPayment("TXN-CRD-9014", "4532-XXXX-XXXX-9921");
        p2.processPayment(12800.0);
        p2.displayPaymentDetails();
    }
}
