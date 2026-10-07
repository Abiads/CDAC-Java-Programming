package com.cdac.assignments.day05;

class Vehicle {
    String vehicleNo;
    String brand;
    double price;

    Vehicle(String vehicleNo, String brand, double price) {
        this.vehicleNo = vehicleNo;
        this.brand = brand;
        this.price = price;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }

    double calculateTax() {
        return price * 0.10;
    }
}

class Car extends Vehicle {
    String model;
    String fuelType;

    Car(String vehicleNo, String brand, double price, String model, String fuelType) {
        super(vehicleNo, brand, price);
        this.model = model;
        this.fuelType = fuelType;
    }

    void displayCarDetails() {
        displayVehicleDetails();
        System.out.println("Model: " + model);
        System.out.println("Fuel Type: " + fuelType);
    }

    double calculateInsurance() {
        return price * 0.05;
    }
}

class ElectricCar extends Car {
    double batteryCapacity;
    double chargingTime;

    ElectricCar(String vehicleNo, String brand, double price, String model, String fuelType, double batteryCapacity, double chargingTime) {
        super(vehicleNo, brand, price, model, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    double calculateRange() {
        return batteryCapacity * 6;
    }

    void displayElectricCarDetails() {
        displayCarDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Time: " + chargingTime + " hours");
        System.out.println("Estimated Range: " + calculateRange() + " km");
        System.out.println("Road Tax: " + calculateTax());
        System.out.println("Insurance: " + calculateInsurance());
    }
}

public class Q02_VehicleMultilevelInheritance {
    public static void main(String[] args) {
        ElectricCar ev = new ElectricCar("MH12AB1234", "Tata", 1400000, "Nexon EV", "Electric", 40.5, 6.0);
        ev.displayElectricCarDetails();
    }
}
