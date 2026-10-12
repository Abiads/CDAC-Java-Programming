package com.cdac.exam_prep;


public class Main {
    public static void main(String[] args) {

        TravelPackage t = new DomesticPackage(
            101, "Abhay", "Goa", 3, 2
        );

        t.displayPackageDetails();

        System.out.println("Cost: " + t.calculateCost());

        System.out.println(
            "Total Packages: " + TravelPackage.totalPackages
        );
    }
}