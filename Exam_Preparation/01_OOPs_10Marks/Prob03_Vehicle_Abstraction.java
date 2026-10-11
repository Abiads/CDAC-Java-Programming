/**
 * TOPIC: Abstraction & Abstract Classes (10 Marks OOPs Question)
 * 
 * PROBLEM STATEMENT:
 * Create an abstract class Vehicle with vehicleNo, brand, and rentalRate.
 * Include a constructor, a concrete method displayVehicleDetails(), and an abstract method calculateRental(int days).
 * 
 * Create a subclass Car extending Vehicle with numberOfSeats and insuranceCharge.
 * Implement calculateRental(int days) as: (rentalRate * days) + insuranceCharge.
 * Provide displayCarDetails().
 * 
 * In main(), create a Car object and demonstrate calculation and output.
 */

abstract class Vehicle {
    String vehicleNo;
    String brand;
    double rentalRate;

    Vehicle(String vehicleNo, String brand, double rentalRate) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.rentalRate = rentalRate;
    }

    // Concrete method with implementation
    void displayVehicleDetails() {
        System.out.println("Vehicle No   : " + vehicleNo);
        System.out.println("Brand        : " + brand);
        System.out.println("Base Rate    : Rs. " + rentalRate + " / day");
    }

    // Abstract method: MUST be implemented by any concrete subclass
    abstract double calculateRental(int days);
}

class Car extends Vehicle {
    int numberOfSeats;
    double insuranceCharge;

    Car(String vehicleNo, String brand, double rentalRate, int numberOfSeats, double insuranceCharge) {
        super(vehicleNo, brand, rentalRate);
        this.numberOfSeats = numberOfSeats;
        this.insuranceCharge = insuranceCharge;
    }

    @Override
    double calculateRental(int days) {
        return (rentalRate * days) + insuranceCharge;
    }

    void displayCarDetails() {
        displayVehicleDetails();
        System.out.println("Seating Cap. : " + numberOfSeats + " Passengers");
        System.out.println("Insurance Fee: Rs. " + insuranceCharge);
    }
}

public class Prob03_Vehicle_Abstraction {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("          CAR RENTAL SYSTEM (ABSTRACTION)     ");
        System.out.println("==============================================");

        // Vehicle v = new Vehicle(...); // COMPILE ERROR: Cannot instantiate abstract class!
        Car car = new Car("MH12-RN-8877", "Tata Safari", 2500.0, 7, 750.0);
        car.displayCarDetails();

        int tripDays = 5;
        double totalCost = car.calculateRental(tripDays);
        System.out.println("\nRental Duration : " + tripDays + " days");
        System.out.println("Total Amount Due: Rs. " + totalCost);
        System.out.println("==============================================");
    }
}
