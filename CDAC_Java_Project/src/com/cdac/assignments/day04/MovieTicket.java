package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Assignment 4 - Problem 5: Movie Ticket Booking
 *
 * Requirements:
 * - Data members: Customer Name, Movie Name, Number of Tickets, Ticket Price
 * - Methods:
 *     read() - to read customer and ticket details
 *     calculateAmount() - to calculate total ticket amount (Formula: Total Amount = Number of Tickets × Ticket Price)
 *     display() - to display booking details and total amount
 * - Create an object and display booking details.
 */
public class MovieTicket {

    private String customerName;
    private String movieName;
    private int numberOfTickets;
    private double ticketPrice;
    private double totalAmount;

    // Default Constructor
    public MovieTicket() {
    }

    // Parameterized Constructor
    public MovieTicket(String customerName, String movieName, int numberOfTickets, double ticketPrice) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.numberOfTickets = Math.max(numberOfTickets, 0);
        this.ticketPrice = Math.max(ticketPrice, 0.0);
        this.totalAmount = calculateAmount();
    }

    // Interactive read method using Scanner
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Enter Movie Ticket Booking Details -----");
        System.out.print("Enter Customer Name: ");
        this.customerName = sc.nextLine();

        System.out.print("Enter Movie Name: ");
        this.movieName = sc.nextLine();

        System.out.print("Enter Number of Tickets: ");
        this.numberOfTickets = sc.nextInt();

        System.out.print("Enter Ticket Price (₹): ");
        this.ticketPrice = sc.nextDouble();

        this.totalAmount = calculateAmount();
    }

    // Programmatic read method
    public void read(String customerName, String movieName, int numberOfTickets, double ticketPrice) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.numberOfTickets = Math.max(numberOfTickets, 0);
        this.ticketPrice = Math.max(ticketPrice, 0.0);
        this.totalAmount = calculateAmount();
    }

    // Method to calculate total ticket amount
    public double calculateAmount() {
        this.totalAmount = this.numberOfTickets * this.ticketPrice;
        return this.totalAmount;
    }

    // Method to display booking details and total amount
    public void display() {
        System.out.println("\n========== Movie Ticket Booking Summary ==========");
        System.out.println("Customer Name     : " + customerName);
        System.out.println("Movie Title       : " + movieName);
        System.out.println("Seats Booked      : " + numberOfTickets);
        System.out.printf("Price Per Ticket  : ₹%.2f%n", ticketPrice);
        System.out.println("--------------------------------------------------");
        System.out.printf("Total Amount Due  : ₹%.2f%n", totalAmount);
        System.out.println("==================================================");
    }

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public int getNumberOfTickets() { return numberOfTickets; }
    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }

    public double getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }

    public double getTotalAmount() { return totalAmount; }

    // Standalone runner for testing
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.read("Rohit Verma", "Inception (IMAX)", 4, 380.0);
        ticket.display();
    }
}
