package com.cdac.assignments.day04;

import java.util.Scanner;

public class MovieTicket {
    String customerName;
    String movieName;
    int numberOfTickets;
    double ticketPrice;
    double totalAmount;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        customerName = sc.next();
        System.out.print("Enter Movie Name: ");
        movieName = sc.next();
        System.out.print("Enter Number of Tickets: ");
        numberOfTickets = sc.nextInt();
        System.out.print("Enter Ticket Price: ");
        ticketPrice = sc.nextDouble();
        sc.close();
    }

    public void calculateAmount() {
        totalAmount = numberOfTickets * ticketPrice;
    }

    public void display() {
        System.out.println("\n--- Movie Ticket Booking Details ---");
        System.out.println("Customer Name     : " + customerName);
        System.out.println("Movie Name        : " + movieName);
        System.out.println("Number of Tickets : " + numberOfTickets);
        System.out.println("Ticket Price      : ₹" + ticketPrice);
        System.out.println("Total Amount      : ₹" + totalAmount);
    }
}
