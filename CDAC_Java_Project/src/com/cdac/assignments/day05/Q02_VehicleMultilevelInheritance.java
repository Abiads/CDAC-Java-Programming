package com.cdac.assignments.day05;

import java.util.Scanner;

// Superclass
class Vehicle {
    String vehicleNo;
    String brand;
    double price;

    Vehicle(String vehicleNo, String brand, double price) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.price = price;
    }

    double calculateTax() {
        return price * 0.10; // 10% road tax
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle No     : " + vehicleNo);
        System.out.println("Brand          : " + brand);
        System.out.println("Price          : ₹" + price);
        System.out.println("Road Tax (10%) : ₹" + calculateTax());
    }
}

// Subclass demonstrating first level of inheritance
class Car extends Vehicle {
    String model;
    String fuelType;

    Car(String vehicleNo, String brand, double price, String model, String fuelType) {
        super(vehicleNo, brand, price);
        this.model = model;
        this.fuelType = fuelType;
    }

    double calculateInsurance() {
        return price * 0.05; // 5% insurance premium
    }

    void displayCarDetails() {
        displayVehicleDetails();
        System.out.println("Model          : " + model);
        System.out.println("Fuel Type      : " + fuelType);
        System.out.println("Insurance (5%) : ₹" + calculateInsurance());
    }
}

// Subclass demonstrating Multilevel Inheritance (ElectricCar -> Car -> Vehicle)
class ElectricCar extends Car {
    double batteryCapacity; // in kWh
    double chargingTime;    // in hours

    ElectricCar(String vehicleNo, String brand, double price, String model, String fuelType,
                double batteryCapacity, double chargingTime) {
        super(vehicleNo, brand, price, model, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    double calculateRange() {
        return batteryCapacity * 7.5; // ~7.5 km per kWh
    }

    void displayElectricCarDetails() {
        System.out.println("--- Electric Car Details ---");
        displayCarDetails();
        System.out.println("Battery Cap.   : " + batteryCapacity + " kWh");
        System.out.println("Charging Time  : " + chargingTime + " hours");
        System.out.println("Estimated Range: " + calculateRange() + " km");
    }
}

public class Q02_VehicleMultilevelInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Number: ");
        String vNo = sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Fuel Type: ");
        String fuelType = sc.nextLine();

        System.out.print("Enter Battery Capacity (kWh): ");
        double battery = sc.nextDouble();

        System.out.print("Enter Charging Time (hours): ");
        double time = sc.nextDouble();

        ElectricCar ev = new ElectricCar(vNo, brand, price, model, fuelType, battery, time);
        System.out.println();
        ev.displayElectricCarDetails();

        sc.close();
    }
}
