package com.cdac.assignments.day01;

/**
 * Question 4: Temperature Conversion
 * Problem: Convert temperature from Celsius to Fahrenheit.
 * Formula:
 *   Fahrenheit = (Celsius * 9.0 / 5.0) + 32.0
 */
public class Q04_TemperatureConversion {

    public static void main(String[] args) {
        System.out.println("=== Question 4: Temperature Conversion ===");

        double celsius = 37.0; // Normal human body temperature in Celsius

        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;

        System.out.printf("Temperature in Celsius    : %.2f °C%n", celsius);
        System.out.printf("Temperature in Fahrenheit : %.2f °F%n", fahrenheit);

        // Also demonstrate freezing and boiling points
        double freezingC = 0.0;
        double boilingC = 100.0;
        System.out.printf("Freezing Point: %.1f °C -> %.1f °F%n", freezingC, (freezingC * 9 / 5) + 32);
        System.out.printf("Boiling Point : %.1f °C -> %.1f °F%n", boilingC, (boilingC * 9 / 5) + 32);
    }
}
