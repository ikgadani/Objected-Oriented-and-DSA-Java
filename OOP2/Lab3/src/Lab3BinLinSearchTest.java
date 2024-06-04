/**
 * Student Name: Isha Gadani
 * Student Number: 41085940
 * Course: CST8130 - Data Structures
 * Assignment: Lab 3
 * CET-CS-Level 3
 * Professor: George Kriger
 */

import java.util.Scanner;

/**
 * Lab3BinLinSearchTest is a class that provides a menu-driven interface to test
 * the binary and linear search algorithms.
 */
public class Lab3BinLinSearchTest {
    public static void main(String[] args) {
        BinaryLinearSearch searcher = new BinaryLinearSearch();
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;

        while (true) {
            System.out.println("\nSelect your option in the menu below");
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform a recursive binary and linear search.");
            System.out.println("3. Perform iterative binary and linear search.");
            System.out.println("4. Exit.");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Option 1: Initialize and populate an array of random integers.
                        arr = searcher.generateRandomInts(32);
                        break;
                    case 2:
                        if (arr != null) {
                            // Option 2: Perform a recursive binary and linear search.
                            System.out.print("Please enter an integer value to search: ");
                            int key = scanner.nextInt();

                            // Measure the time taken for recursive binary search
                            long startTime = System.nanoTime();
                            int binaryResult = searcher.recursiveBinarySearch(arr, key, 0, arr.length - 1);
                            long endTime = System.nanoTime();
                            long elapsedTimeNano = endTime - startTime;
                            long elapsedTimeMillis = elapsedTimeNano / 1000000;

                            // Print results and timing information
                            System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
                            System.out.println("Time taken in milliseconds: " + elapsedTimeMillis);

                            // Measure the time taken for recursive linear search
                            startTime = System.nanoTime();
                            int linearResult = searcher.recursiveLinearSearch(arr, key, 0);
                            endTime = System.nanoTime();
                            elapsedTimeNano = endTime - startTime;
                            elapsedTimeMillis = elapsedTimeNano / 1000000;

                            // Print results and timing information
                            System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
                            System.out.println("Time taken in milliseconds: " + elapsedTimeMillis);
                        } else {
                            System.out.println("Please initialize the array first.");
                        }
                        break;
                    case 3:
                        if (arr != null) {
                            // Option 3: Perform iterative binary and linear search.
                            System.out.print("Please enter an integer value to search: ");
                            int key = scanner.nextInt();

                            // Measure the time taken for iterative binary search
                            long startTime = System.nanoTime();
                            int binaryResult = searcher.iterativeBinarySearch(arr, key);
                            long endTime = System.nanoTime();
                            long elapsedTimeNano = endTime - startTime;
                            long elapsedTimeMillis = elapsedTimeNano / 1000000;

                            // Print results and timing information
                            System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
                            System.out.println("Time taken in milliseconds: " + elapsedTimeMillis);

                            // Measure the time taken for iterative linear search
                            startTime = System.nanoTime();
                            int linearResult = searcher.iterativeLinearSearch(arr, key);
                            endTime = System.nanoTime();
                            elapsedTimeNano = endTime - startTime;
                            elapsedTimeMillis = elapsedTimeNano / 1000000;

                            // Print results and timing information
                            System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
                            System.out.println("Time taken in milliseconds: " + elapsedTimeMillis);
                        } else {
                            System.out.println("Please initialize the array first.");
                        }
                        break;
                    case 4:
                        // Option 4: Exit the program.
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choose a valid option (1 to 4).");
                        break;
                }
            } catch (Exception e) {
                System.out.println("*****Input Mismatch Exception*****");
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}
