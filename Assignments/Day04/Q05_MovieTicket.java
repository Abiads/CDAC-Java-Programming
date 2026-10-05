import java.util.Scanner;

class MovieTicket {
    String customerName;
    String movieName;
    int numberOfTickets;
    double ticketPrice;
    double totalAmount;

    void read() {
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

    void calculateAmount() {
        totalAmount = numberOfTickets * ticketPrice;
    }

    void display() {
        System.out.println("\n--- Movie Ticket Booking Details ---");
        System.out.println("Customer Name     : " + customerName);
        System.out.println("Movie Name        : " + movieName);
        System.out.println("Number of Tickets : " + numberOfTickets);
        System.out.println("Ticket Price      : ₹" + ticketPrice);
        System.out.println("Total Amount      : ₹" + totalAmount);
    }
}

public class Q05_MovieTicket {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        mt.read();
        mt.calculateAmount();
        mt.display();
    }
}
