/**
 * Student Name: Isha Gadani
 * Student Number: 41085940
 * Course: CST8130 - Data Structures
 * Assignment: Lab 3
 * CET-CS-Level 3
 * Professor: George Kriger
 */

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * BinaryLinearSearch is a class that provides methods for performing binary and linear search
 * operations on an array of integers.
 */
public class BinaryLinearSearch {
    private SecureRandom random;
    private int[] randomArr;

    /**
     * Initializes a BinaryLinearSearch object with a SecureRandom instance.
     */
    public BinaryLinearSearch() {
        random = new SecureRandom();
    }

    /**
     * Performs an iterative binary search on a sorted array to find a key.
     *
     * @param arr The sorted array of integers to search.
     * @param key The integer to search for in the array.
     * @return The index of the key if found, or -1 if not found.
     */
    public int iterativeBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Number " + key + " found at index " + mid + ": Iterative Binary Search");
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Performs a recursive binary search on a sorted array to find a key.
     *
     * @param arr  The sorted array of integers to search.
     * @param key  The integer to search for in the array.
     * @param low  The lowest index of the current search range.
     * @param high The highest index of the current search range.
     * @return The index of the key if found, or -1 if not found.
     */
    public int recursiveBinarySearch(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Number " + key + " found at index " + mid + ": Recursive Binary Search");
                return mid;
            } else if (arr[mid] < key) {
                return recursiveBinarySearch(arr, key, mid + 1, high);
            } else {
                return recursiveBinarySearch(arr, key, low, mid - 1);
            }
        }

        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Generates an array of random integers between 11 and 100 (exclusive), prints the
     * unsorted and sorted arrays, and returns a clone of the sorted array.
     *
     * @param size The size of the array to generate.
     * @return A clone of the sorted array of random integers.
     */
    public int[] generateRandomInts(int size) {
        randomArr = new int[size];
        for (int i = 0; i < size; i++) {
            randomArr[i] = random.nextInt(90) + 11; // Generates random integers between 11 and 100 (exclusive)
        }
        System.out.println("Unsorted array: " + Arrays.toString(randomArr));
        Arrays.sort(randomArr);
        System.out.println("Sorted array: " + Arrays.toString(randomArr));
        return randomArr.clone();
    }

    /**
     * Displays elements of an array, with line breaks after every 8 elements.
     *
     * @param arr The array of integers to display.
     */
    public void remainingElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Performs an iterative linear search on an array to find a key.
     *
     * @param arr The array of integers to search.
     * @param key The integer to search for in the array.
     * @return The index of the key if found, or -1 if not found.
     */
    public int iterativeLinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Number " + key + " found at index " + i + ": Iterative Linear Search");
                return i;
            }
        }
        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Performs a recursive linear search on an array to find a key.
     *
     * @param arr   The array of integers to search.
     * @param key   The integer to search for in the array.
     * @param index The current index being checked during the recursive search.
     * @return The index of the key if found, or -1 if not found.
     */
    public int recursiveLinearSearch(int[] arr, int key, int index) {
        if (index >= arr.length) {
            System.out.println("Number " + key + " was not found.");
            return -1;
        }
        if (arr[index] == key) {
            System.out.println("Number " + key + " found at index " + index + ": Recursive Linear Search");
            return index;
        }
        return recursiveLinearSearch(arr, key, index + 1);
    }
}
