package primary;

import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and its processing
 * Student Name: Isha Gadani
 * Student Number: 41085940
 * Course: CST8130 - Data Structures
 * Professor: George Kriger.
 */
public class Lab1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Numbers numbers = null;

        boolean quit = false;
        while (!quit) {
            displayMainMenu();

            int choice = input.nextInt();
            input.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    numbers = new Numbers();
                    System.out.println("Default array initialized.");
                    break;
                case 2:
                    System.out.print("Enter the max size of the array: ");
                    int size = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    numbers = new Numbers(size);
                    System.out.println("Array of size " + size + " initialized.");
                    break;
                case 3:
                    if (numbers != null) {
                        System.out.print("Enter a value to add to the array: ");
                        float value = input.nextFloat();
                        input.nextLine(); // Consume the newline character
                        numbers.addValue(value);
                        System.out.println(value + " added to the array.");
                    } else {
                        System.out.println("Error: You need to initialize the array first.");
                    }
                    break;
                case 4:
                    if (numbers != null) {
                        System.out.println("Values in the array: " + numbers.toString());
                    } else {
                        System.out.println("Error: You need to initialize the array first.");
                    }
                    break;
                case 5:
                    if (numbers != null) {
                        float[] minMaxMod = numbers.findMinMax();
                        float average = numbers.calcAverage();
                        int factorialMax = numbers.getFactorialMax();

                        System.out.println("Minimum value: " + minMaxMod[0]);
                        System.out.println("Maximum value: " + minMaxMod[1]);
                        System.out.println("Max mod Min: " + minMaxMod[2]);
                        System.out.println("Average: " + average);
                        System.out.println("Factorial of Max: " + factorialMax);
                    } else {
                        System.out.println("Error: You need to initialize the array first.");
                    }
                    break;
                case 6:
                    quit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        input.close();
    }

    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display average of the values, minimum value, maximum value,");
        System.out.println("   max mod min, factorialMax");
        System.out.println("6: To Exit");
        System.out.print("> ");
    }
}
