/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

public class Searching {
	/**
     * Performs binary search on a sorted array to find the target element.
     *
     * @param arr    The sorted array to be searched.
     * @param target The element to be searched for.
     * @param low    The lower index for the current search interval.
     * @param high   The upper index for the current search interval.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; 
            }

            if (arr[mid] > target) {
                return binarySearch(arr, target, low, mid - 1); 
            }

            return binarySearch(arr, target, mid + 1, high); 
        }

        return -1; 
    }
    /**
     * Performs linear search on an array to find the target element.
     *
     * @param arr    The array to be searched.
     * @param target The element to be searched for.
     * @param index  The current index in the array where the search begins.
     * @return The index of the target element if found, or -1 if not found.
     */
    
    public static int linearSearch(int[] arr, int target, int index) {
        if (index < arr.length) {
            if (arr[index] == target) {
                return index;
            }
            return linearSearch(arr, target, index + 1); 
        }

        return -1; 
    }
}
