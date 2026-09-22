package com.cdac.assignments.day02;

import java.util.Scanner;

public class Q07_TemperatureConversion {

    public static double convertTemperature(double celsius) {
        return (celsius * 9 / 5.0) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = convertTemperature(celsius);

        System.out.printf("Celsius      : %.2f °C%n", celsius);
        System.out.printf("Fahrenheit   : %.2f °F%n", fahrenheit);

        if (fahrenheit > 100) {
            System.out.println("Temperature is above 100°F.");
        } else {
            System.out.println("Temperature is not above 100°F.");
        }

        sc.close();
    }
}
