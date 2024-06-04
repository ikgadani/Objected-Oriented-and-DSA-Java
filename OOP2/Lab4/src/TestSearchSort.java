/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class TestSearchSort {
	
    public static void main(String[] args) {
        int[] randomArr = null; 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Select your option in the menu below:");
            System.out.println("1: Initialize and populate an array of 1000 random integers.");
            System.out.println("2: Perform recursive binary search.");
            System.out.println("3: Perform recursive linear search.");
            System.out.println("4: Sort the array -> Go to submenu");
            System.out.println("5: Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    randomArr = genRandomInts(1000, 120, 1000);
                    System.out.println("Array of randomly generated integers:");
                    System.out.println(Arrays.toString(randomArr));
                    break;
                case 2:
                	Arrays.sort(randomArr);
                    if (randomArr != null) {
                        int target = scanner.nextInt();
                        int index = Searching.binarySearch(randomArr, target, 0, randomArr.length - 1);
                        System.out.println(Arrays.toString(randomArr));
                        if (index != -1) {
                            System.out.println(target + " was found at index position " + index + ": Recursive Binary Search.");
                        } else {
                            System.out.println(target + " was not found.");
                        }
                    } else {
                        System.out.println("Array is not initialized. Please initialize it first.");
                    }
                    break;
                case 3:
                	Arrays.sort(randomArr);
                    if (randomArr != null) {
                        int target = scanner.nextInt(); 
                        int index = Searching.linearSearch(randomArr, target, 0);
                        System.out.println(Arrays.toString(randomArr));
                        if (index != -1) {
                            System.out.println(target + " was found at index position " + index + ": Recursive Linear Search.");
                        } else {
                            System.out.println(target + " was not found.");
                        }
                    } else {
                        System.out.println("Array is not initialized. Please initialize it first.");
                    }
                    break;
                case 4:
                    if (randomArr != null) {
                        showSortingSubMenu(randomArr);
                    } else {
                        System.out.println("Array is not initialized. Please initialize it first.");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Generates an array of random integers within a specified range.
     *
     * @param size The size of the array to generate.
     * @param min  The minimum value for the random integers.
     * @param max  The maximum value for the random integers.
     * @return An array of random integers.
     */
    public static int[] genRandomInts(int size, int min, int max) {
        SecureRandom random = new SecureRandom();
        int[] randomArr = new int[size];
        for (int i = 0; i < size; i++) {
            randomArr[i] = random.nextInt(max - min) + min;
        }
        return randomArr;
    }
    
    /**
     * Displays a submenu for selecting a sorting algorithm to sort the data array.
     *
     * @param arr The array to be sorted.
     */
    public static void showSortingSubMenu(int[] arr) {
    	Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select a sorting algorithm to sort the data array");
            System.out.println("B. Bubble Sort");
            System.out.println("I. Insertion Sort");
            System.out.println("S. Selection Sort");
            System.out.println("M. Merge Sort");
            System.out.println("Q. Quick Sort");
            System.out.println("R. Return to Main Menu");
            
            
            char option = scanner.next().charAt(0); 

            switch (option) {
                case 'B':
                    int[] bubbleArray = Arrays.copyOf(arr, arr.length);
                    long bubbleStartTime = System.nanoTime();
                    SortingAlgorithms.bubbleSort(bubbleArray);
                    long bubbleEndTime = System.nanoTime();
                    long bubbleElapsedTimeInMilliseconds = (bubbleEndTime - bubbleStartTime) / 1000000;
                    System.out.println(Arrays.toString(bubbleArray));
                    System.out.println("Bubble Sort: Simple sorting algorithm - O(n^2) Complexity - ");
                    System.out.println("Time taken in nanoseconds: " + (bubbleEndTime - bubbleStartTime));
                    System.out.println("Time taken in milliseconds: " + bubbleElapsedTimeInMilliseconds);
                    break;
                case 'I':
                    int[] insertArray = Arrays.copyOf(arr, arr.length);
                    long insertStartTime = System.nanoTime();
                    SortingAlgorithms.insertionSort(insertArray);
                    long insertEndTime = System.nanoTime();
                    long insertElapsedTimeInMilliseconds = (insertEndTime - insertStartTime) / 1000000;
                    System.out.println(Arrays.toString(insertArray));
                    System.out.println("Insertion Sort: Simple sorting algorithm - O(n^2) Complexity - ");
                    System.out.println("Time taken in nanoseconds: " + (insertEndTime - insertStartTime));
                    System.out.println("Time taken in milliseconds: " + insertElapsedTimeInMilliseconds);
                    break;
                case 'S':
                    int[] selectArray = Arrays.copyOf(arr, arr.length);
                    long selectStartTime = System.nanoTime();
                    SortingAlgorithms.selectionSort(selectArray);
                    long selectEndTime = System.nanoTime();
                    long selectElapsedTimeInMilliseconds = (selectEndTime - selectStartTime) / 1000000;
                    System.out.println(Arrays.toString(selectArray));
                    System.out.println("Selection Sort: Simple sorting algorithm - O(n^2) Complexity - ");
                    System.out.println("Time taken in nanoseconds: " + (selectEndTime - selectStartTime));
                    System.out.println("Time taken in milliseconds: " + selectElapsedTimeInMilliseconds);
                    break;
                case 'M':
                    int[] mergeArray = Arrays.copyOf(arr, arr.length);
                    long mergeStartTime = System.nanoTime();
                    SortingAlgorithms.mergeSort(mergeArray);
                    long mergeEndTime = System.nanoTime();
                    long mergeElapsedTimeInMilliseconds = (mergeEndTime - mergeStartTime) / 1000000;
                    System.out.println(Arrays.toString(mergeArray));
                    System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - ");
                    System.out.println("Time taken in nanoseconds: " + (mergeEndTime - mergeStartTime));
                    System.out.println("Time taken in milliseconds: " + mergeElapsedTimeInMilliseconds);
                    break;
                case 'Q':
                    int[] quickArray = Arrays.copyOf(arr, arr.length);
                    long quickStartTime = System.nanoTime();
                    SortingAlgorithms.quickSort(quickArray);
                    long quickEndTime = System.nanoTime();
                    long quickElapsedTimeInMilliseconds = (quickEndTime - quickStartTime) / 1000000;
                    System.out.println(Arrays.toString(quickArray));
                    System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - ");
                    System.out.println("Time taken in nanoseconds: " + (quickEndTime - quickStartTime));
                    System.out.println("Time taken in milliseconds: " + quickElapsedTimeInMilliseconds);
                    break;
                case 'R':
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}
