import java.util.Scanner;

public class Q02_AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();

        double area = 3.14159 * r * r;
        double circumference = 2 * 3.14159 * r;

        System.out.println("Area of Circle: " + area);
        System.out.println("Circumference of Circle: " + circumference);
        sc.close();
    }
}
