/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

public class SortingAlgorithms {
	
	 /**
     * Sorts an array using the Bubble Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
	public static void bubbleSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (arr[j] > arr[j + 1]) {
	                
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	            }
	        }
	    }
	}
	
	/**
     * Sorts an array using the Insertion Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    
	public static void insertionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 1; i < n; i++) {
	        int key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j--;
	        }
	        arr[j + 1] = key;
	    }
	}

	/**
     * Sorts an array using the Selection Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    
	public static void selectionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            if (arr[j] < arr[minIndex]) {
	                minIndex = j;
	            }
	        }
	        // Swap arr[i] and arr[minIndex]
	        int temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	}


	/**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
	public static void mergeSort(int[] arr) {
	    mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	        mergeSort(arr, left, mid);
	        mergeSort(arr, mid + 1, right);
	        merge(arr, left, mid, right);
	    }
	}

	private static void merge(int[] arr, int left, int mid, int right) {
	    int n1 = mid - left + 1;
	    int n2 = right - mid;

	    int[] L = new int[n1];
	    int[] R = new int[n2];

	    for (int i = 0; i < n1; i++) {
	        L[i] = arr[left + i];
	    }
	    for (int j = 0; j < n2; j++) {
	        R[j] = arr[mid + 1 + j];
	    }

	    int i = 0, j = 0;
	    int k = left;

	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i];
	            i++;
	        } else {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }

	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	/**
     * Sorts an array using the Quick Sort algorithm.
     *
     * @param arr The array to be sorted.
     */

   
	public static void quickSort(int[] arr) {
	    quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
	    if (low < high) {
	        int pivotIndex = partition(arr, low, high);
	        quickSort(arr, low, pivotIndex - 1);
	        quickSort(arr, pivotIndex + 1, high);
	    }
	}

	private static int partition(int[] arr, int low, int high) {
	    int pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    int temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    return i + 1;
	}

}
