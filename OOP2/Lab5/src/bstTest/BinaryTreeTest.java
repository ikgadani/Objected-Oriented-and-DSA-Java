package bstTest;

import java.io.File;
import java.util.Scanner;
import binarySearchTree.*;

public class BinaryTreeTest {
	
	/**
     * The main entry point for the BinaryTreeTest program.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        IntegerComparator comparator = new IntegerComparator();
        BinaryTree<Integer> bst = new BinaryTree<>(comparator);

        try {
            Scanner scanner = new Scanner(new File("SampleValues.txt"));
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                bst.insert(value);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Display the tree contents
        System.out.println("Tree display using pre-order traversal:");
        bst.displayPreOrder();

        System.out.println("Tree display using in-order traversal:");
        bst.displayInOrder();

        System.out.println("Tree display using post-order traversal:");
        bst.displayPostOrder();

        int[] searchValues = {26, 11, 92, 100};
        for (int searchValue : searchValues) {
            boolean found = bst.search(searchValue);
            System.out.printf("Searching for %d: %s%n", searchValue, found ? "found" : "NOT found");
        }
    }
}
