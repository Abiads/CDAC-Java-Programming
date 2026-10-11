import java.util.Scanner;

/**
 * ============================================================================
 * EXAM TOPIC: Method Overloading / Compile-Time Polymorphism (10 Marks Target)
 * Problem 3: Shape Area Calculator
 * 
 * Based on Day 05 & 06 Polymorphism Assignments:
 * 1. Method Overloading Rules: Same method name, different number/types of parameters
 * 2. Overloaded methods:
 *    - double calculateArea(double radius)                  -> Circle
 *    - double calculateArea(double length, double width)    -> Rectangle
 *    - double calculateArea(float base, float height)       -> Triangle
 *    - int calculateArea(int side)                          -> Square
 * ============================================================================
 */

class AreaCalculator {

    // 1. Area of Circle: PI * r * r
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // 2. Area of Rectangle: length * width
    public double calculateArea(double length, double width) {
        return length * width;
    }

    // 3. Area of Triangle: 0.5 * base * height (using float parameters to differentiate)
    public double calculateArea(float base, float height) {
        return 0.5 * base * height;
    }

    // 4. Area of Square: side * side
    public int calculateArea(int side) {
        return side * side;
    }
}

public class Prob03_ShapeArea_MethodOverloading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AreaCalculator calc = new AreaCalculator();

        System.out.println("=================================================");
        System.out.println("   SHAPE AREA CALCULATOR (METHOD OVERLOADING)    ");
        System.out.println("=================================================");
        System.out.println("1. Area of Circle");
        System.out.println("2. Area of Rectangle");
        System.out.println("3. Area of Triangle");
        System.out.println("4. Area of Square");
        System.out.print("Select shape (1-4): ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter radius of circle: ");
                double r = sc.nextDouble();
                System.out.printf("Area of Circle: %.2f sq. units\n", calc.calculateArea(r));
                break;

            case 2:
                System.out.print("Enter length: ");
                double l = sc.nextDouble();
                System.out.print("Enter breadth: ");
                double b = sc.nextDouble();
                System.out.printf("Area of Rectangle: %.2f sq. units\n", calc.calculateArea(l, b));
                break;

            case 3:
                System.out.print("Enter base of triangle: ");
                float base = sc.nextFloat();
                System.out.print("Enter height of triangle: ");
                float height = sc.nextFloat();
                System.out.printf("Area of Triangle: %.2f sq. units\n", calc.calculateArea(base, height));
                break;

            case 4:
                System.out.print("Enter side of square: ");
                int side = sc.nextInt();
                System.out.println("Area of Square: " + calc.calculateArea(side) + " sq. units");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
