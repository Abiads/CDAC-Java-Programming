/**
 * TOPIC: Hierarchical Inheritance & Method Overriding (10 Marks OOPs Question)
 * 
 * PROBLEM STATEMENT:
 * Create a superclass Patient with patientId, patientName, and age.
 * Provide a method calculateTreatmentCost() with general base calculation.
 * 
 * Create two subclasses:
 * 1. InPatient (numberOfDays, roomCharge) -> overrides calculateTreatmentCost() = numberOfDays * roomCharge.
 * 2. OutPatient (consultationFee, medicineCost) -> overrides calculateTreatmentCost() = consultationFee + medicineCost.
 * 
 * In main(), create objects for both InPatient and OutPatient and display their details and total treatment costs.
 */

class Patient {
    int patientId;
    String patientName;
    int age;

    Patient(int patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    double calculateTreatmentCost() {
        return 500.0; // Base registration charge
    }

    void displayPatientDetails() {
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Patient Name   : " + patientName);
        System.out.println("Age            : " + age);
    }
}

class InPatient extends Patient {
    int numberOfDays;
    double roomCharge;

    InPatient(int patientId, String patientName, int age, int numberOfDays, double roomCharge) {
        super(patientId, patientName, age);
        this.numberOfDays = numberOfDays;
        this.roomCharge = roomCharge;
    }

    @Override
    double calculateTreatmentCost() {
        // Room charge per day times number of days
        return numberOfDays * roomCharge;
    }

    void displayInPatientDetails() {
        displayPatientDetails();
        System.out.println("Patient Type   : In-Patient (Admitted)");
        System.out.println("Days Stayed    : " + numberOfDays);
        System.out.println("Room Rate/Day  : Rs. " + roomCharge);
        System.out.println("Total Bill     : Rs. " + calculateTreatmentCost());
    }
}

class OutPatient extends Patient {
    double consultationFee;
    double medicineCost;

    OutPatient(int patientId, String patientName, int age, double consultationFee, double medicineCost) {
        super(patientId, patientName, age);
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
    }

    @Override
    double calculateTreatmentCost() {
        // Consultation fee plus medicines
        return consultationFee + medicineCost;
    }

    void displayOutPatientDetails() {
        displayPatientDetails();
        System.out.println("Patient Type   : Out-Patient (OPD)");
        System.out.println("Consultation   : Rs. " + consultationFee);
        System.out.println("Medicines      : Rs. " + medicineCost);
        System.out.println("Total Bill     : Rs. " + calculateTreatmentCost());
    }
}

public class Prob05_HospitalManagement_Overriding {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("          HOSPITAL TREATMENT COST SYSTEM        ");
        System.out.println("================================================");

        InPatient ip = new InPatient(101, "Suresh Kumar", 48, 4, 1800.0);
        ip.displayInPatientDetails();

        System.out.println("\n------------------------------------------------");

        OutPatient op = new OutPatient(202, "Meena Kumari", 32, 600.0, 1450.0);
        op.displayOutPatientDetails();

        System.out.println("================================================");
    }
}
