package com.cdac.session03_oop;

/**
 * Syllabus Sessions 3 & 4:
 * Class Inheritance, Abstract Classes, Interfaces, Polymorphism,
 * Object Casting, Virtual Methods, and Method Overriding.
 */
public class InheritanceAndPolymorphismDemo {

    // Interface
    public interface Printable {
        void printDetails();
    }

    // Abstract Class
    public static abstract class Shape implements Printable {
        protected String color;

        public Shape(String color) {
            this.color = color;
        }

        // Abstract method
        public abstract double calculateArea();

        // Concrete method
        public String getColor() {
            return color;
        }
    }

    // Concrete Subclass 1
    public static class Circle extends Shape {
        private final double radius;

        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void printDetails() {
            System.out.printf("Circle [Color: %s, Radius: %.2f, Area: %.2f]%n", color, radius, calculateArea());
        }
    }

    // Concrete Subclass 2
    public static class Rectangle extends Shape {
        private final double length;
        private final double width;

        public Rectangle(String color, double length, double width) {
            super(color);
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }

        @Override
        public void printDetails() {
            System.out.printf("Rectangle [Color: %s, Length: %.2f, Width: %.2f, Area: %.2f]%n", color, length, width, calculateArea());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== CDAC Sessions 3 & 4: Inheritance & Polymorphism ===");

        // Dynamic Method Dispatch (Polymorphic array)
        Shape[] shapes = new Shape[] {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Circle("Green", 2.5)
        };

        for (Shape s : shapes) {
            // Virtual method invocation: calls the actual subclass implementation
            s.printDetails();

            // Java 17 Pattern Matching for instanceof
            if (s instanceof Circle c) {
                System.out.println("   -> Specific Circle area: " + c.calculateArea());
            }
        }
    }
}
