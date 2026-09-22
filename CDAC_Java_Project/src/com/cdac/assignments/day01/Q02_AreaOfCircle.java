package com.cdac.assignments.day01;

/**
 * Question 2: Area and Circumference of a Circle
 * Problem: Store the radius of a circle in a variable and calculate its area and circumference.
 * Formulas:
 *   Area = Math.PI * r * r
 *   Circumference = 2 * Math.PI * r
 */
public class Q02_AreaOfCircle {

    public static void main(String[] args) {
        System.out.println("=== Question 2: Area and Circumference of a Circle ===");

        double radius = 7.5; // Radius in centimeters

        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.printf("Radius        : %.2f cm%n", radius);
        System.out.printf("Area          : %.4f sq.cm%n", area);
        System.out.printf("Circumference : %.4f cm%n", circumference);
    }
}
