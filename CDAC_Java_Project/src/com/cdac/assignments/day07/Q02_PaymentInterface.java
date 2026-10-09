package com.cdac.assignments.day07;

interface Payment {
    void processPayment(double amount);
    void displayPaymentDetails();
}

class UPIPayment implements Payment {
    String transactionId;
    String upiId;
    double lastAmountPaid;

    UPIPayment(String transactionId, String upiId) {
        this.transactionId = transactionId;
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        this.lastAmountPaid = amount;
        System.out.println("Processing UPI Payment of Rs. " + amount + " for UPI ID: " + upiId);
        System.out.println("UPI Payment Successful. Transaction ID: " + transactionId);
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Payment Method : UPI");
        System.out.println("UPI ID         : " + upiId);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount Paid    : Rs. " + lastAmountPaid);
    }
}

class CardPayment implements Payment {
    String transactionId;
    String cardNumber;
    double lastAmountPaid;

    CardPayment(String transactionId, String cardNumber) {
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        this.lastAmountPaid = amount;
        System.out.println("Processing Card Payment of Rs. " + amount + " on Card: " + cardNumber);
        System.out.println("Card Payment Successful. Transaction ID: " + transactionId);
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Payment Method : Credit/Debit Card");
        System.out.println("Card Number    : " + cardNumber);
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount Paid    : Rs. " + lastAmountPaid);
    }
}

public class Q02_PaymentInterface {
    public static void main(String[] args) {
        System.out.println("--- UPI Payment Demo ---");
        Payment upi = new UPIPayment("TXN-UPI-987654", "user@upi");
        upi.processPayment(1500.0);
        upi.displayPaymentDetails();

        System.out.println("\n--- Card Payment Demo ---");
        Payment card = new CardPayment("TXN-CRD-123456", "XXXX-XXXX-XXXX-4589");
        card.processPayment(4200.0);
        card.displayPaymentDetails();
    }
}
