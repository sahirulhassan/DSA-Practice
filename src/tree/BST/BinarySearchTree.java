package tree.BST;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else {
            node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data == node.getData()) {
            if (node.getLeft() == null && node.getRight() == null) { // Both children are null
                return null;
            }
            if (node.getLeft() == null) { // Left child is null. Bypass the current node and return the right child.
                return node.getRight();
            }
            if (node.getRight() == null) { // Right child is null. Bypass the current node and return the left child.
                return node.getLeft();
            }
            int smallestValue = findSmallestValue(node.getRight()); // Both children are not null
            node.setData(smallestValue); // Replace the data in the node with the smallest value from the right subtree
            node.setRight(delete(node.getRight(), smallestValue)); // Delete the node with the smallest value in the right subtree
            return node;
        }
        if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
            return node;
        }
        node.setRight(delete(node.getRight(), data)); // data > node.getData()
        return node;
    }

    private int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getData() : findSmallestValue(node.getLeft());
    } // Ternary operator ?; it is a shorthand for if-else statement. If true, return node.getData(); else, return findSmallestValue(node.getLeft()).

    // We can use the following iterative approach to find the smallest value in the right subtree as well:
//    private int findSmallestValue(Node node) {
//        while (node.getLeft() != null) {
//            node = node.getLeft();
//        }
//        return node.getData();
//    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.getData()) {
            return true;
        }
        if (data < node.getData()) {
            return search(node.getLeft(), data);
        }
        return search(node.getRight(), data);
    }

    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder() {
        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public void postOrder() {
        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(root, sb, "", true);
        return sb.toString();
    }

    private void toStringHelper(Node node, StringBuilder sb, String prefix, boolean isRight) {
        if (node != null) {
            sb.append(prefix)
                    .append(isRight ? "├── " : "└── ")
                    .append(node.getData())
                    .append("\n");
            toStringHelper(node.getLeft(), sb, prefix + (isRight ? "│   " : "    "), true);
            toStringHelper(node.getRight(), sb, prefix + (isRight ? "│   " : "    "), false);
        }
    }

}