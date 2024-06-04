package rallyPkg;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic min-heap implementation using an ArrayList for Rally programming challenges.
 *
 * @param <T> the type of elements stored in the heap, must extend Comparable for comparison.
 */
public class RallyHeap<T extends Comparable<T>> {
    private List<T> heap;

    /**
     * Constructs an empty RallyHeap.
     */
    public RallyHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Inserts an element into the heap and maintains the heap property.
     *
     * @param element the element to be inserted.
     */
    public void insert(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    /**
     * Extracts and returns the minimum element from the heap.
     *
     * @return the minimum element, or null if the heap is empty.
     */
    public T extractMin() {
        if (heap.isEmpty()) {
            return null;
        }

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    /**
     * Maintains the heap property by moving the element up the heap until the property is satisfied.
     *
     * @param index the index of the element to be moved up.
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Maintains the heap property by moving the element down the heap until the property is satisfied.
     *
     * @param index the index of the element to be moved down.
     */
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param i the index of the first element.
     * @param j the index of the second element.
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
