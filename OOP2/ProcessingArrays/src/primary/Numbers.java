package primary;

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

    private int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

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

    private void resizeArray() {
        int newSize = numbers.length * 2;
        Float[] newArray = new Float[newSize];
        System.arraycopy(numbers, 0, newArray, 0, numItems);
        numbers = newArray;
    }
}
