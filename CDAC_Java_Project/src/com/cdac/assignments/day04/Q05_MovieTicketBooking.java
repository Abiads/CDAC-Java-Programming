package com.cdac.assignments.day04;

import java.util.Scanner;

/**
 * Runner class for Assignment 4 - Problem 5: Movie Ticket Booking
 *
 * Requirements:
 * "Create an object and display booking details."
 */
public class Q05_MovieTicketBooking {

    public static void main(String[] args) {
        System.out.println("=== Day 04 - Assignment 5: Movie Ticket Booking ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Run with interactive user input? (y/n, default n for demo): ");
        String choice = sc.hasNextLine() ? sc.nextLine().trim() : "n";

        MovieTicket ticket = new MovieTicket();

        if (choice.equalsIgnoreCase("y")) {
            ticket.read();
        } else {
            System.out.println("Running with sample data...");
            ticket.read("Deepika Padukone", "Interstellar: 10th Anniversary Re-release", 3, 450.0);
        }

        ticket.calculateAmount();
        ticket.display();
    }
}
