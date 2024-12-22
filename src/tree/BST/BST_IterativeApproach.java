package tree.BST;

public class BST_IterativeApproach {
    private Node root;

    public BST_IterativeApproach() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (data < parent.getData()) {
            parent.setLeft(new Node(data));
        } else {
            parent.setRight(new Node(data));
        }
        return root;
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getData()) {
                return true;
            }
            if (key < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) { // Tree is empty
            return null;
        }
        Node current = root;
        Node parent = null;
        while (current != null && current.getData() != key) { // Search for the key
            parent = current;
            if (key < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (current == null) { // Key not found
            return root;
        }
        if (current.getLeft() == null && current.getRight() == null) { // Node to be deleted is a leaf node
            if (current != root) { // Node to be deleted is not the root
                if (parent.getLeft() == current) { // Node to be deleted is a left child
                    parent.setLeft(null); // Actual deletion.
                } else { // Node to be deleted is a right child
                    parent.setRight(null); // Actual deletion.
                }
            } else { // Node to be deleted is the root
                root = null;
            }
        } else if (current.getLeft() == null) { // Node to be deleted has only right child
            if (current != root) { // Node to be deleted is not the root
                if (parent.getLeft() == current) { // Node to be deleted is a left child
                    parent.setLeft(current.getRight()); // Bypass the current node and return the right child.
                } else { // Node to be deleted is a right child
                    parent.setRight(current.getRight()); // Bypass the current node and return the right child.
                }
            } else { // Node to be deleted is the root
                root = root.getRight();
            }
        } else if (current.getRight() == null) { // Node to be deleted has only left child
            if (current != root) { // Node to be deleted is not the root
                if (parent.getLeft() == current) { // Node to be deleted is a left child
                    parent.setLeft(current.getLeft()); // Bypass the current node and return the left child.
                } else { // Node to be deleted is a right child
                    parent.setRight(current.getLeft()); // Bypass the current node and return the left child.
                }
            } else { // Node to be deleted is the root
                root = root.getLeft();
            }
        } else { // Node to be deleted has both left and right children
            Node successor = getSuccessor(current); // get the smallest element in the right subtree.
            if (current != root) {  // Node to be deleted is not the root
                if (parent.getLeft() == current) { // Node to be deleted is a left child
                    parent.setLeft(successor); // Connect the parent of the node to be deleted to the successor.
                } else { // Node to be deleted is a right child
                    parent.setRight(successor); // Connect the parent of the node to be deleted to the successor.
                }
            } else { // Node to be deleted is the root
                root = successor;
            }
            successor.setLeft(current.getLeft()); // Connect the left child of the node to be deleted to the successor.
        }
        return root;
    }

    private Node getSuccessor(Node node) {
        Node current = node.getRight();
        Node parent = node;
        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }
        if (current != node.getRight()) { // Successor is not the right child of the node to be deleted, which
            // dictates that leftmost child of the right subtree (successor) of the node to be deleted may have a right
            // child of its own which needs to be connected to the parent of the successor.
            parent.setLeft(current.getRight());
            current.setRight(node.getRight());
        }
        return current;
    }
}
