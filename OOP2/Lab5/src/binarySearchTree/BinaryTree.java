package binarySearchTree;


import java.util.Comparator;
/**
 * This class represents a binary search tree (BST) data structure. A binary search tree is a
 * hierarchical data structure that allows for efficient insertion, deletion, and retrieval of
 * elements.
 *
 * @param <T> the type of data stored in the binary search tree
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private Comparator<T> comparator;
    
    
    /**
     * Constructs a new binary search tree with the specified comparator.
     *
     * @param comparator the comparator used to compare elements in the tree
     */
    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    /**
     * Inserts a new element into the binary search tree.
     *
     * @param data the data to be inserted
     */
    public void insert(T data) {
        if (root == null) {
            root = new BinaryTreeNode<>(data, comparator);
        } else {
            root.insert(data);
        }
    }

    /**
     * Performs a pre-order traversal of the binary search tree and displays the elements.
     */
    public void displayPreOrder() {
        if (root != null) {
            root.displayPreOrder();
        }
        System.out.println(); 
    }

    /**
     * Performs an in-order traversal of the binary search tree and displays the elements.
     */
    public void displayInOrder() {
        if (root != null) {
            root.displayInOrder();
        }
        System.out.println(); 
    }

    /**
     * Performs a post-order traversal of the binary search tree and displays the elements.
     */
    public void displayPostOrder() {
        if (root != null) {
            root.displayPostOrder();
        }
        System.out.println(); 
    }
    
    /**
     * Searches for a specific element in the binary search tree.
     *
     * @param searchData the data to be searched for
     * @return true if the element is found, false otherwise
     */
    public boolean search(T searchData) {
        return root != null && root.search(searchData);
    }
}
