abstract class Vehicle {
    String vehicleNo;
    String brand;
    double rentalRate;

    Vehicle(String vehicleNo, String brand, double rentalRate) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.rentalRate = rentalRate;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle No   : " + vehicleNo);
        System.out.println("Brand        : " + brand);
        System.out.println("Rental Rate  : Rs. " + rentalRate + " per day");
    }

    // Abstract method to be implemented by subclasses
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
        System.out.println("Seats        : " + numberOfSeats);
        System.out.println("Insurance    : Rs. " + insuranceCharge);
    }
}

public class Q01_VehicleAbstraction {
    public static void main(String[] args) {
        Car car = new Car("MH12-DE-4321", "Hyundai Creta", 2200.0, 5, 600.0);

        System.out.println("--- Car Details ---");
        car.displayCarDetails();

        int rentalDays = 4;
        double totalRental = car.calculateRental(rentalDays);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Total Rental : Rs. " + totalRental);
    }
}
