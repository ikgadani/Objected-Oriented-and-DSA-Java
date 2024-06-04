package bstTest;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
	 /**
     * Compares two Integer objects for ordering. This method compares the two integers
     * using their natural ordering (ascending order).
     *
     * @param o1 the first Integer object to be compared
     * @param o2 the second Integer object to be compared
     * @return a negative integer if o1 is less than o2, 0 if they are equal, or a positive integer if o1 is greater than o2
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        
        return o1.compareTo(o2);
    }
}
