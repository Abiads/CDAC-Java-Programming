package com.cdac.assignments.day01;

/**
 * Question 9: Voting Eligibility
 * Problem: Accept a person's age and check whether the person is eligible to vote.
 * Rule:
 *   Age >= 18 -> Eligible
 *   Age < 18  -> Not Eligible
 */
public class Q09_VotingEligibility {

    public static void checkVotingEligibility(int age) {
        System.out.print("Age: " + age + " -> ");
        if (age >= 18) {
            System.out.println("Eligible to vote.");
        } else if (age >= 0) {
            int yearsLeft = 18 - age;
            System.out.println("Not eligible to vote. (Wait " + yearsLeft + " more year(s))");
        } else {
            System.out.println("Invalid age entered!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 9: Voting Eligibility Checker ===");

        checkVotingEligibility(21);
        checkVotingEligibility(16);
        checkVotingEligibility(18);
        checkVotingEligibility(-5);
    }
}
