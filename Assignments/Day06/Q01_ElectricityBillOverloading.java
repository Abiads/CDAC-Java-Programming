class ElectricityBill {
    int consumerNo;
    String consumerName;
    int unitsConsumed;

    ElectricityBill(int consumerNo, String consumerName, int unitsConsumed) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.unitsConsumed = unitsConsumed;
    }

    // Method 1: Default rate of Rs. 8 per unit
    double calculateBill() {
        return unitsConsumed * 8.0;
    }

    // Method 2: Given rate and unitsConsumed property
    double calculateBill(double rate) {
        return unitsConsumed * rate;
    }

    // Method 3: Given rate and specified units
    double calculateBill(double rate, int units) {
        return units * rate;
    }

    void displayDetails() {
        System.out.println("Consumer No    : " + consumerNo);
        System.out.println("Consumer Name  : " + consumerName);
        System.out.println("Units Consumed : " + unitsConsumed);
    }
}

public class Q01_ElectricityBillOverloading {
    public static void main(String[] args) {
        ElectricityBill bill = new ElectricityBill(101, "Rahul Sharma", 150);

        System.out.println("--- Electricity Bill Details ---");
        bill.displayDetails();

        System.out.println("\n--- Overloaded Bill Calculations ---");
        // 1. Default rate of Rs. 8/unit
        System.out.println("Bill (Default rate @ Rs. 8/unit)       : Rs. " + bill.calculateBill());

        // 2. Custom rate with consumer's unitsConsumed
        System.out.println("Bill (Custom rate @ Rs. 10.5/unit)     : Rs. " + bill.calculateBill(10.5));

        // 3. Custom rate with specified units (e.g., 200 units @ Rs. 12/unit)
        System.out.println("Bill (Specified 200 units @ Rs. 12/unit): Rs. " + bill.calculateBill(12.0, 200));
    }
}
