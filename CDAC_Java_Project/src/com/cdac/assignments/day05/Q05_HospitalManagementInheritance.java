package com.cdac.assignments.day05;

class Person {
    int personId;
    String personName;
    int age;

    Person(int personId, String personName, int age) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
    }

    void displayPersonDetails() {
        System.out.println("Person ID: " + personId);
        System.out.println("Person Name: " + personName);
        System.out.println("Age: " + age);
    }

    void checkAge() {
        if (age >= 18) {
            System.out.println("Status: Adult");
        } else {
            System.out.println("Status: Minor");
        }
    }
}

class Doctor extends Person {
    String specialization;
    double consultationFee;

    Doctor(int personId, String personName, int age, String specialization, double consultationFee) {
        super(personId, personName, age);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    double calculateConsultationAmount() {
        return consultationFee;
    }

    void displayDoctorDetails() {
        displayPersonDetails();
        checkAge();
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + calculateConsultationAmount());
    }
}

class Patient extends Person {
    String disease;
    int roomNumber;

    Patient(int personId, String personName, int age, String disease, int roomNumber) {
        super(personId, personName, age);
        this.disease = disease;
        this.roomNumber = roomNumber;
    }

    double calculateRoomCharge() {
        return 1500.0;
    }

    void displayPatientDetails() {
        displayPersonDetails();
        checkAge();
        System.out.println("Disease: " + disease);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Charge: " + calculateRoomCharge());
    }
}

public class Q05_HospitalManagementInheritance {
    public static void main(String[] args) {
        System.out.println("--- Doctor Details ---");
        Doctor doc = new Doctor(1, "Dr. Sneha Verma", 38, "Cardiology", 800);
        doc.displayDoctorDetails();

        System.out.println("\n--- Patient Details ---");
        Patient pat = new Patient(101, "Manoj Joshi", 45, "Fever", 204);
        pat.displayPatientDetails();
    }
}
