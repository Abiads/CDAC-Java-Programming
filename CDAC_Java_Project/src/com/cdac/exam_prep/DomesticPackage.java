package com.cdac.exam_prep;

public class DomesticPackage extends TravelPackage {

    public DomesticPackage(int id, String name,
            String destination, int days, int persons) {
        super(id, name, destination, days, persons);
    }

    
    public double calculateCost() {
        return numberOfDays * numberOfPersons * 1000.0;
    }
}
