public class Q08_StudentMarksCLI {
    public static void main(String[] args) {
        String studentName;
        int m1, m2, m3;

        // Accepts command-line arguments: java Q08_StudentMarksCLI Ravi 80 75 90
        if (args.length >= 4) {
            studentName = args[0];
            m1 = Integer.parseInt(args[1]);
            m2 = Integer.parseInt(args[2]);
            m3 = Integer.parseInt(args[3]);
        } else {
            // Interactive fallback when run without CLI arguments
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("Enter Student Name: ");
            studentName = sc.next();
            System.out.print("Enter Mark 1: ");
            m1 = sc.nextInt();
            System.out.print("Enter Mark 2: ");
            m2 = sc.nextInt();
            System.out.print("Enter Mark 3: ");
            m3 = sc.nextInt();
            sc.close();
        }

        int total = m1 + m2 + m3;
        double average = total / 3.0;

        // Student is considered PASS only if all three subject marks are 40 or above
        String result = (m1 >= 40 && m2 >= 40 && m3 >= 40) ? "PASS" : "FAIL";

        System.out.println("Student Name: " + studentName);
        System.out.println("Mark 1: " + m1);
        System.out.println("Mark 2: " + m2);
        System.out.println("Mark 3: " + m3);
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Result: " + result);
    }
}
