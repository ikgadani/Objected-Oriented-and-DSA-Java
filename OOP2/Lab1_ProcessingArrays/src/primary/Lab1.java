package primary;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and its processing.
 * Student Name: Isha Gadani
 * Student Number: 41085940
 * Course: CST8130 - Data Structures
 * Professor: George Kriger.
 */
public class Lab1 {

    /**
     * The main method of the program.
     * 
     * @param args - The command-line arguments (not used in this program).
     */
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
                    
                case 7: // New option to load values from a file
                    try {
                        System.out.print("Enter the filename to load values from: ");
                        String filename = input.nextLine();
                        numbers = loadFromFile(filename);
                        System.out.println("Values loaded from the file.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: File not found.");
                    } catch (IOException e) {
                        System.out.println("Error: Could not read from the file.");
                    }
                    break;
                case 8: // New option to save values to a file
                    if (numbers != null) {
                        try {
                            System.out.print("Enter the filename to save values to: ");
                            String filename = input.nextLine();
                            saveToFile(numbers, filename);
                            System.out.println("Values saved to the file.");
                        } catch (IOException e) {
                            System.out.println("Error: Could not write to the file.");
                        }
                    } else {
                        System.out.println("Error: You need to initialize the array first.");
                    }
                    break;
                case 9:
                	quit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        input.close();
    }

 
    // New method to load values from a file
    public static Numbers loadFromFile(String filename) throws FileNotFoundException, IOException {
        Scanner fileScanner = new Scanner(new File(filename));
        int size = fileScanner.nextInt();
        fileScanner.nextLine(); // Consume the newline character

        Numbers numbers = new Numbers(size);

        while (fileScanner.hasNextFloat()) {
            float value = fileScanner.nextFloat();
            numbers.addValue(value);
        }

        fileScanner.close();
        return numbers;
    }

    // New method to save values to a file
    public static void saveToFile(Numbers numbers, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(numbers.getNumItems() + "\n");

        for (int i = 0; i < numbers.getNumItems(); i++) {
            writer.write(numbers.getValue(i) + "\n");
        }

        writer.close();
    }
    
    /**
     * Displays the main menu of the program.
     */
    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display average of the values, minimum value, maximum value,");
        System.out.println("   max mod min, factorialMax");
        System.out.println("6: Enter multiple values");
        System.out.println("7: Read values from file");
        System.out.println("8: Save values to file");
        System.out.println("9: To Exit");
        System.out.print("> ");
    }
}

