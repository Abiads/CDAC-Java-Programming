package com.cdac.assignments.day02;

import java.util.Scanner;

public class Q05_CheckVotingEligibility {

    public static boolean isEligible(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        boolean eligible = isEligible(age);

        if (eligible) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        sc.close();
    }
}
