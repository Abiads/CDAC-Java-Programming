package com.cdac.session01_basics;

/**
 * Syllabus Session 1:
 * Introduction to JVM Architecture, Memory Model, and System Properties.
 */
public class JVMArchitectureOverview {

    public static void main(String[] args) {
        System.out.println("=== CDAC Session 1: JVM Architecture & Runtime Environment ===");

        // Inspecting Runtime & Memory Details
        Runtime runtime = Runtime.getRuntime();
        long maxMemoryMB = runtime.maxMemory() / (1024 * 1024);
        long totalMemoryMB = runtime.totalMemory() / (1024 * 1024);
        long freeMemoryMB = runtime.freeMemory() / (1024 * 1024);
        int availableProcessors = runtime.availableProcessors();

        System.out.println("Available CPU Cores       : " + availableProcessors);
        System.out.println("Max Heap Memory (Xmx)     : " + maxMemoryMB + " MB");
        System.out.println("Total Allocated Memory    : " + totalMemoryMB + " MB");
        System.out.println("Free Memory in Heap       : " + freeMemoryMB + " MB");

        // System Properties
        System.out.println("\n--- Java Runtime Properties ---");
        System.out.println("Java Version              : " + System.getProperty("java.version"));
        System.out.println("Java Vendor               : " + System.getProperty("java.vendor"));
        System.out.println("Java Home Directory       : " + System.getProperty("java.home"));
        System.out.println("Operating System          : " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ")");
        System.out.println("User Working Directory    : " + System.getProperty("user.dir"));

        System.out.println("\n[INFO] JVM successfully loaded and verified bytecode execution.");
    }
}
