class Patient {
    int patientId;
    String patientName;
    int age;

    Patient(int patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    // General treatment cost in superclass
    double calculateTreatmentCost() {
        return 500.0; // Base hospital charge
    }

    void displayPatientDetails() {
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Age          : " + age);
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
        // Treatment cost including room charges based on number of days
        return numberOfDays * roomCharge;
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
        // Treatment cost including consultation and medicine charges
        return consultationFee + medicineCost;
    }
}

public class Q04_HospitalTreatmentCostOverriding {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient(101, "Suresh Kumar", 45, 5, 2000.0);
        OutPatient outPatient = new OutPatient(102, "Sunita Rao", 32, 600.0, 1400.0);

        System.out.println("--- InPatient Details ---");
        inPatient.displayPatientDetails();
        System.out.println("Number of Days : " + inPatient.numberOfDays);
        System.out.println("Room Charge/Day: Rs. " + inPatient.roomCharge);
        System.out.println("Treatment Cost : Rs. " + inPatient.calculateTreatmentCost());

        System.out.println("\n--- OutPatient Details ---");
        outPatient.displayPatientDetails();
        System.out.println("Consultation Fee: Rs. " + outPatient.consultationFee);
        System.out.println("Medicine Cost   : Rs. " + outPatient.medicineCost);
        System.out.println("Treatment Cost  : Rs. " + outPatient.calculateTreatmentCost());
    }
}
