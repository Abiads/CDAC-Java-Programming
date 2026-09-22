package com.cdac.practice.module04_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record Student(int id, String name, double score, String gender) {}

public class StudentGradeAnalyzerDemo {

    public static void main(String[] args) {
        System.out.println("=== Student Grade Analyzer using Java Streams ===\n");

        List<Student> students = Arrays.asList(
            new Student(101, "Aarav", 88.5, "Male"),
            new Student(102, "Diya", 94.0, "Female"),
            new Student(103, "Rohan", 67.0, "Male"),
            new Student(104, "Ananya", 79.5, "Female"),
            new Student(105, "Kabir", 58.0, "Male"),
            new Student(106, "Meera", 91.0, "Female"),
            new Student(107, "Vikram", 74.0, "Male")
        );

        System.out.println("All Students:");
        students.forEach(s -> System.out.printf("  ID: %d | Name: %-8s | Score: %5.1f | Gender: %s%n",
                s.id(), s.name(), s.score(), s.gender()));

        // 1. Filter students with score > 75
        System.out.println("\n1. High Achievers (Score > 75):");
        List<Student> highAchievers = students.stream()
                .filter(s -> s.score() > 75.0)
                .toList();
        highAchievers.forEach(s -> System.out.printf("  -> %s (Score: %.1f)%n", s.name(), s.score()));

        // 2. Find the student with the highest score
        System.out.println("\n2. Top Performer:");
        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::score));
        topStudent.ifPresent(s -> System.out.printf("  -> %s with score: %.1f%n", s.name(), s.score()));

        // 3. Calculate average score
        System.out.println("\n3. Class Average Score:");
        double avgScore = students.stream()
                .mapToDouble(Student::score)
                .average()
                .orElse(0.0);
        System.out.printf("  -> Average: %.2f / 100%n", avgScore);

        // 4. Group students by gender
        System.out.println("\n4. Grouped by Gender:");
        Map<String, List<Student>> byGender = students.stream()
                .collect(Collectors.groupingBy(Student::gender));

        byGender.forEach((gender, list) -> {
            System.out.println("  " + gender + " (" + list.size() + "):");
            list.forEach(s -> System.out.printf("     - %s (%.1f)%n", s.name(), s.score()));
        });
    }
}
