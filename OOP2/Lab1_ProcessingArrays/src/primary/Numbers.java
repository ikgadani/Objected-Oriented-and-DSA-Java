package primary;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and its processing.
 * Student Name: Isha Gadani
 * Student Number: 41085940
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Professor: George Kriger
 */
public class Numbers {
    
    private Float[] numbers; // Stores Float values.
    private int numItems;   // Store the number of items currently in the array.

    /**
     * Default Constructor - initializes the array of size 5.
     */
    public Numbers() {
        numbers = new Float[5];
        numItems = 0;
    }

    /**
     * Constructor that initializes the numbers array.
     * 
     * @param size - Max size of the numbers array
     */
    public Numbers(int size) {
        numbers = new Float[size];
        numItems = 0;
    }

    /**
     * Adds a value to the array.
     * 
     * @param value - The value to add to the array
     */
    public void addValue(Float value) {
        // Check if the array is full and needs to be resized
        if (numItems == numbers.length) {
            resizeArray();
        }

        numbers[numItems++] = value;
    }

    /**
     * Calculates the average of all the values in the numbers array.
     * 
     * @return float value that represents the average
     */
    public float calcAverage() {
        if (numItems == 0) {
            return 0.0f; // Avoid division by zero
        }

        float sum = 0.0f;
        for (int i = 0; i < numItems; i++) {
            sum += numbers[i];
        }

        return sum / numItems;
    }

    /**
     * Finds and returns the minimum and maximum values in the array,
     * along with the result of MaxValue modulo MinValue.
     * 
     * @return an array of three float values: [min, max, max mod min]
     */
    public float[] findMinMax() {
        if (numItems == 0) {
            return new float[] { 0.0f, 0.0f, 0.0f };
        }

        float min = numbers[0];
        float max = numbers[0];

        for (int i = 1; i < numItems; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        float maxModMin = max % min;
        return new float[] { min, max, maxModMin };
    }

    /**
     * Finds the maximum value in the array, drops the decimal part,
     * and returns the factorial of the integer part.
     * 
     * @return the factorial of the integer part of MaxValue
     */
    public int getFactorialMax() {
        if (numItems == 0) {
            return 0; // Handle the case when the array is empty
        }

        float max = numbers[0];
        for (int i = 1; i < numItems; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        int maxIntPart = (int) max; // Drop decimal part
        return calculateFactorial(maxIntPart);
    }

    // Helper method to calculate factorial
    private int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    /**
     * Returns a string representation of the values in the array.
     * 
     * @return a comma-separated string of values
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numItems; i++) {
            result.append(numbers[i]);
            if (i < numItems - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    // Helper method to resize the array when it's full
    private void resizeArray() {
        int newSize = numbers.length * 2;
        Float[] newArray = new Float[newSize];
        System.arraycopy(numbers, 0, newArray, 0, numItems);
        numbers = newArray;
    }

    public int getNumItems() {
        return numItems;
    }
    
    public Float getValue(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return numbers[index];
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
}