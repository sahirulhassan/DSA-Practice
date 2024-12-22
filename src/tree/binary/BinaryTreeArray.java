package tree.binary;

public class BinaryTreeArray {
    private int[] tree;
    private int size;

    public BinaryTreeArray(int capacity) {
        tree = new int[capacity];
        size = 0;
    }

    // Method to insert a node at the next available position
    public void insert(int data) {
        if (size >= tree.length) {
            System.out.println("Tree is full, cannot insert.");
            return;
        }
        tree[size++] = data;
    }

    public boolean search(int data) {
        return search(0, data);
    }
    private boolean search(int i, int data) {
        if (i >= size) {
            return false;
        }
        if (tree[i] == data) {
            return true;
        }
        if (tree[i] > data) {
            return search(2 * i + 1, data); // Search left subtree
        }
        return search(2 * i + 2, data); // Search right subtree
    }

    public boolean delete(int data) {
        return delete(0, data);
    }

    private boolean delete(int i, int data) {
        if (i >= size) { // Data not found
            return false;
        }
        if (tree[i] == data) {
            if (2 * i + 1 >= size && 2 * i + 2 >= size) { // Node has no children
                tree[i] = 0;
            }
            else if (2 * i + 1 < size && 2 * i + 2 >= size) { // Node has one child
                tree[i] = tree[2 * i + 1];
                tree[2 * i + 1] = 0;
            }
            else if (2 * i + 1 >= size && 2 * i + 2 < size) { // Node has one child
                tree[i] = tree[2 * i + 2];
                tree[2 * i + 2] = 0;
            }
            else { // Node has two children
                int min = findMin(2 * i + 2); // Find the smallest value in the right subtree
                delete(min);
                tree[i] = min;
            }
            size--;
            return true;
        }
        if (tree[i] > data) { // Search left subtree
            return delete(2 * i + 1, data); // Delete from left subtree
        }
        return delete(2 * i + 2, data); // Delete from right subtree
    }

    private int findMin(int i) {
        if (2 * i + 1 >= size) {
            return tree[i];
        }
        return findMin(2 * i + 1);
    }

    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrder(0);
        System.out.println();
    }
    private void preOrder(int i) {
        if (i < size) {
            System.out.print(tree[i] + " ");
            preOrder(2 * i + 1); // Visit left subtree
            preOrder(2 * i + 2); // Visit right subtree
        }
    }

    public void inOrder() {
        System.out.print("In-order: ");
        inOrder(0);
        System.out.println();
    }
    private void inOrder(int i) {
        if (i < size) {
            inOrder(2 * i + 1); // Visit left subtree
            System.out.print(tree[i] + " ");
            inOrder(2 * i + 2); // Visit right subtree
        }
    }

    public void postOrder() {
        System.out.print("Post-order: ");
        postOrder(0);
        System.out.println();
    }
    private void postOrder(int i) {
        if (i < size) {
            postOrder(2 * i + 1); // Visit left subtree
            postOrder(2 * i + 2); // Visit right subtree
            System.out.print(tree[i] + " ");
        }
    }

    // Method to get the left child of a node at index i
    public int getLeftChild(int i) {
        int leftChildIndex = 2 * i + 1;
        if (leftChildIndex < size) {
            return tree[leftChildIndex];
        }
        return -1;  // No left child
    }

    // Method to get the right child of a node at index i
    public int getRightChild(int i) {
        int rightChildIndex = 2 * i + 2;
        if (rightChildIndex < size) {
            return tree[rightChildIndex];
        }
        return -1;  // No right child
    }

    // Method to get the parent of a node at index i
    public int getParent(int i) {
        if (i == 0) {
            return -1;  // Root node has no parent
        }
        int parentIndex = (i - 1) / 2;
        return tree[parentIndex];
    }

    // Method to display the tree array
    public void displayTree() {
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the array-based binary tree implementation
    public static void main(String[] args) {
        BinaryTreeArray bt = new BinaryTreeArray(10);

        bt.insert(1);  // Root
        bt.insert(2);  // Left child of 1
        bt.insert(3);  // Right child of 1
        bt.insert(4);  // Left child of 2
        bt.insert(5);  // Right child of 2
        bt.insert(6);  // Left child of 3

        bt.displayTree();  // Display tree: 1 2 3 4 5 6

        // Get left and right children of node at index 1 (node 2)
        System.out.println("Left child of 2: " + bt.getLeftChild(1));  // Should print 4
        System.out.println("Right child of 2: " + bt.getRightChild(1)); // Should print 5

        // Get parent of node at index 4 (node 5)
        System.out.println("Parent of 5: " + bt.getParent(4));  // Should print 2
    }
}
