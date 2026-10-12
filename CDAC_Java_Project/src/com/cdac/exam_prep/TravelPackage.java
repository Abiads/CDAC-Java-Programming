package com.cdac.exam_prep;


abstract class TravelPackage {

    // Instance variables
    int packageId;
    String customerName;
    String destination;
    int numberOfDays;
    int numberOfPersons;

    // Static variable shared by all objects
    static int totalPackages = 0;

    // Parameterized constructor
    TravelPackage(int packageId, String customerName,
                  String destination, int numberOfDays,
                  int numberOfPersons) {

        this.packageId = packageId;
        this.customerName = customerName;
        this.destination = destination;
        this.numberOfDays = numberOfDays;
        this.numberOfPersons = numberOfPersons;

        totalPackages++;
    }

    // Concrete method
    void displayPackageDetails() {
        System.out.println("Package ID: " + packageId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Destination: " + destination);
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Number of Persons: " + numberOfPersons);
    }

    // Abstract method
    abstract double calculateCost();
}

