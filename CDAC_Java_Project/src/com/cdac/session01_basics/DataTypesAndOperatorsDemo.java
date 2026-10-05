package com.cdac.session01_basics;

/**
 * Syllabus Session 1:
 * Primitive Data Types, Scope of Variables, Wrapper Classes, and Operators.
 */
public class DataTypesAndOperatorsDemo {

    // Static / Class variable
    static final String INSTITUTION = "CDAC ACTS Pune";

    // Instance variable
    private int sessionCounter = 1;

    public void demonstrateDataTypes() {
        System.out.println("--- 1. Primitive Types & Bit Sizes ---");
        byte b = 127;                       // 8-bit signed
        short s = 32000;                    // 16-bit signed
        int i = 2_147_483_647;              // 32-bit signed (underscores for readability)
        long l = 9_223_372_036_854_775_807L; // 64-bit signed
        float f = 3.14159f;                 // 32-bit floating point
        double d = 2.718281828459045;       // 64-bit floating point
        char c = 'J';                       // 16-bit Unicode character
        boolean flag = true;                // true or false

        System.out.println("byte: " + b + ", short: " + s + ", int: " + i + ", long: " + l);
        System.out.println("float: " + f + ", double: " + d + ", char: " + c + ", boolean: " + flag);
        System.out.println("Session counter: " + sessionCounter);

        System.out.println("\n--- 2. Wrapper Classes & Autoboxing ---");
        // Autoboxing (primitive -> object)
        Integer boxedInt = i;
        Double boxedDouble = d;
        Boolean boxedBool = flag;

        // Unboxing (object -> primitive)
        int unboxedInt = boxedInt;
        System.out.println("Boxed Integer: " + boxedInt + " -> Unboxed primitive: " + unboxedInt);
        System.out.println("Boxed Double: " + boxedDouble + ", Boxed Boolean: " + boxedBool);
        System.out.println("Integer.parseInt(\"1024\") = " + Integer.parseInt("1024"));
        System.out.println("Binary string of 42 = " + Integer.toBinaryString(42));

        System.out.println("\n--- 3. Operators & Short-Circuit Evaluation ---");
        int x = 10, y = 20;
        boolean condition = (x > 5) || (++y > 20); // Short-circuit: second operand not evaluated!
        System.out.println("Result: " + condition + ", y remained: " + y);

        // Ternary operator
        int max = (x > y) ? x : y;
        System.out.println("Max of " + x + " and " + y + " is: " + max);
    }

    public static void main(String[] args) {
        System.out.println("Institution: " + INSTITUTION);
        DataTypesAndOperatorsDemo demo = new DataTypesAndOperatorsDemo();
        demo.demonstrateDataTypes();
    }
}
