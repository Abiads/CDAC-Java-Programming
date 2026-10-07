package com.cdac.assignments.day05;

import java.util.Scanner;

// Superclass
class Person {
    int personId;
    String personName;
    int age;

    Person(int personId, String personName, int age) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
    }

    void checkAge() {
        if (age >= 60) {
            System.out.println("Age Category   : Senior Citizen (" + age + " years)");
        } else if (age >= 18) {
            System.out.println("Age Category   : Adult (" + age + " years)");
        } else {
            System.out.println("Age Category   : Minor (" + age + " years)");
        }
    }

    void displayPersonDetails() {
        System.out.println("Person ID      : " + personId);
        System.out.println("Person Name    : " + personName);
        System.out.println("Age            : " + age);
        checkAge();
    }
}

// Subclass 1 - Doctor
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
        System.out.println("--- Doctor Details ---");
        displayPersonDetails();
        System.out.println("Specialization : " + specialization);
        System.out.println("Consultation Fee: ₹" + calculateConsultationAmount());
    }
}

// Subclass 2 - Patient
class Patient extends Person {
    String disease;
    int roomNumber;

    Patient(int personId, String personName, int age, String disease, int roomNumber) {
        super(personId, personName, age);
        this.disease = disease;
        this.roomNumber = roomNumber;
    }

    double calculateRoomCharge() {
        if (roomNumber >= 200) {
            return 2500.0;
        } else {
            return 1200.0;
        }
    }

    void displayPatientDetails() {
        System.out.println("--- Patient Details ---");
        displayPersonDetails();
        System.out.println("Disease        : " + disease);
        System.out.println("Room Number    : " + roomNumber);
        System.out.println("Room Charge/Day: ₹" + calculateRoomCharge());
    }
}

public class Q05_HospitalManagementInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter Doctor Details ===");
        System.out.print("Person ID: ");
        int dId = sc.nextInt();
        sc.nextLine();

        System.out.print("Doctor Name: ");
        String dName = sc.nextLine();

        System.out.print("Age: ");
        int dAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        System.out.print("Consultation Fee: ");
        double fee = sc.nextDouble();

        Doctor doc = new Doctor(dId, dName, dAge, spec, fee);
        System.out.println();
        doc.displayDoctorDetails();

        System.out.println("\n=== Enter Patient Details ===");
        System.out.print("Person ID: ");
        int pId = sc.nextInt();
        sc.nextLine();

        System.out.print("Patient Name: ");
        String pName = sc.nextLine();

        System.out.print("Age: ");
        int pAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Disease: ");
        String dis = sc.nextLine();

        System.out.print("Room Number: ");
        int room = sc.nextInt();

        Patient pat = new Patient(pId, pName, pAge, dis, room);
        System.out.println();
        pat.displayPatientDetails();

        sc.close();
    }
}
