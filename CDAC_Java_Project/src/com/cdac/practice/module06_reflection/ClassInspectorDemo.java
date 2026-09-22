package com.cdac.practice.module06_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Module 6: Java Reflection API Practice
 * Dynamically loads and inspects the internal anatomy of any class:
 * - Implemented interfaces
 * - Constructors
 * - Declared fields with types and access modifiers
 * - Declared methods with return types and parameters
 */
public class ClassInspectorDemo {

    public static void inspectClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("==================================================");
            System.out.println("CLASS INSPECTION REPORT: " + clazz.getName());
            System.out.println("==================================================");

            // Modifiers & Superclass
            System.out.println("Modifiers  : " + Modifier.toString(clazz.getModifiers()));
            System.out.println("Superclass : " + (clazz.getSuperclass() != null ? clazz.getSuperclass().getName() : "None"));

            // Implemented Interfaces
            System.out.println("\n--- Implemented Interfaces ---");
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length == 0) {
                System.out.println("  None");
            } else {
                for (Class<?> iface : interfaces) {
                    System.out.println("  -> " + iface.getName());
                }
            }

            // Declared Constructors
            System.out.println("\n--- Declared Constructors ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.printf("  %s %s(%s)%n",
                        Modifier.toString(c.getModifiers()),
                        c.getName(),
                        Arrays.toString(c.getParameterTypes()));
            }

            // Declared Fields
            System.out.println("\n--- Declared Fields ---");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("  None");
            } else {
                for (Field f : fields) {
                    System.out.printf("  %s %s %s%n",
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(),
                            f.getName());
                }
            }

            // Declared Methods (Top 10 to avoid console spam)
            System.out.println("\n--- Declared Methods ---");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("  None");
            } else {
                int displayLimit = Math.min(methods.length, 12);
                for (int i = 0; i < displayLimit; i++) {
                    Method m = methods[i];
                    System.out.printf("  %s %s %s(%s)%n",
                            Modifier.toString(m.getModifiers()),
                            m.getReturnType().getSimpleName(),
                            m.getName(),
                            Arrays.toString(m.getParameterTypes()));
                }
                if (methods.length > displayLimit) {
                    System.out.printf("  ... and %d more methods (Total: %d)%n",
                            methods.length - displayLimit, methods.length);
                }
            }

            System.out.println("==================================================");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class '" + className + "' not found. Make sure the fully qualified name is correct.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Java Reflection API - Class Inspector ===");
        System.out.print("Enter fully-qualified class name (or press Enter for 'java.util.ArrayList'): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            input = "java.util.ArrayList";
        }

        inspectClass(input);

        sc.close();
    }
}
