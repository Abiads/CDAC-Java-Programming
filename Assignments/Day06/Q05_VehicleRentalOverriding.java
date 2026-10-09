class Vehicle {
    String vehicleNo;
    String brand;
    double baseRate;

    Vehicle(String vehicleNo, String brand, double baseRate) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // General rental calculation in superclass
    double calculateRental() {
        return baseRate;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle No : " + vehicleNo);
        System.out.println("Brand      : " + brand);
        System.out.println("Base Rate  : Rs. " + baseRate + " per day");
    }
}

class Car extends Vehicle {
    int numberOfDays;
    double insuranceCharge;

    Car(String vehicleNo, String brand, double baseRate, int numberOfDays, double insuranceCharge) {
        super(vehicleNo, brand, baseRate);
        this.numberOfDays = numberOfDays;
        this.insuranceCharge = insuranceCharge;
    }

    @Override
    double calculateRental() {
        // Rental amount based on number of days and insurance charge
        return (baseRate * numberOfDays) + insuranceCharge;
    }
}

class Bike extends Vehicle {
    int numberOfDays;
    double helmetCharge;

    Bike(String vehicleNo, String brand, double baseRate, int numberOfDays, double helmetCharge) {
        super(vehicleNo, brand, baseRate);
        this.numberOfDays = numberOfDays;
        this.helmetCharge = helmetCharge;
    }

    @Override
    double calculateRental() {
        // Rental amount based on number of days and helmet charge
        return (baseRate * numberOfDays) + helmetCharge;
    }
}

public class Q05_VehicleRentalOverriding {
    public static void main(String[] args) {
        Car car = new Car("MH-12-AB-1234", "Honda City", 2000.0, 3, 500.0);
        Bike bike = new Bike("MH-12-XY-9876", "Royal Enfield", 800.0, 2, 150.0);

        System.out.println("--- Car Rental Details ---");
        car.displayVehicleDetails();
        System.out.println("Number of Days   : " + car.numberOfDays);
        System.out.println("Insurance Charge : Rs. " + car.insuranceCharge);
        System.out.println("Total Rental     : Rs. " + car.calculateRental());

        System.out.println("\n--- Bike Rental Details ---");
        bike.displayVehicleDetails();
        System.out.println("Number of Days   : " + bike.numberOfDays);
        System.out.println("Helmet Charge    : Rs. " + bike.helmetCharge);
        System.out.println("Total Rental     : Rs. " + bike.calculateRental());
    }
}
