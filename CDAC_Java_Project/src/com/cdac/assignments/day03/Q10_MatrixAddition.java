package com.cdac.assignments.day03;

import java.util.Scanner;

public class Q10_MatrixAddition {

    public static int[][] addMatrices(int[][] a, int[][] b, int rows, int cols) {
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%6d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] a = new int[rows][cols];
        int[][] b = new int[rows][cols];

        System.out.println("\nEnter elements for Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("A[%d][%d]: ", i, j);
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter elements for Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("B[%d][%d]: ", i, j);
                b[i][j] = sc.nextInt();
            }
        }

        int[][] result = addMatrices(a, b, rows, cols);

        System.out.println("\n--- Matrix A ---");
        printMatrix(a);

        System.out.println("\n--- Matrix B ---");
        printMatrix(b);

        System.out.println("\n--- Resultant Matrix (A + B) ---");
        printMatrix(result);

        sc.close();
    }
}
