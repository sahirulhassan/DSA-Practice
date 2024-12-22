package tree.AVL;

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private AVLNode insert(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        }
        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else {
            node.setRight(insert(node.getRight(), data));
        }
        node.updateHeight();
        return balance(node);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private AVLNode delete(AVLNode node, int data) {
        if (node == null) {
            return null;
        }
        if (data == node.getData()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            int smallestValue = findSmallestValue(node.getRight());
            node.setData(smallestValue);
            node.setRight(delete(node.getRight(), smallestValue));
        } else if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else {
            node.setRight(delete(node.getRight(), data));
        }
        node.updateHeight();
        return balance(node);
    }

    private int findSmallestValue(AVLNode node) {
        return node.getLeft() == null ? node.getData() : findSmallestValue(node.getLeft());
    }

    private AVLNode balance(AVLNode node) {
        if (node.getBalanceFactor() > 1) { // Left heavy
            if (node.getLeft().getBalanceFactor() < 0) { // Left-right heavy
                node.setLeft(leftRotate(node.getLeft()));
            }
            return rightRotate(node); // Left-left heavy
        }
        if (node.getBalanceFactor() < -1) { // Right heavy
            if (node.getRight().getBalanceFactor() > 0) { // Right-left heavy
                node.setRight(rightRotate(node.getRight()));
            }
            return leftRotate(node); // Right-right heavy
        }
        return node;
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(AVLNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(AVLNode node, int data) {
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

    @Override
    public String toString() {
        return buildTreeString(this.root, "", true);
    }

    private String buildTreeString(AVLNode node, String prefix, boolean isRoot) {
        if (node == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        // Add the current node
        builder.append(prefix);
        if (!isRoot) {
            builder.append("|-- ");
        }
        builder.append(node.getData()).append("\n");

        // Recursively process left and right children
        if (node.getLeft() != null || node.getRight() != null) {
            String childPrefix = prefix + (isRoot ? "   " : "|   ");
            if (node.getLeft() != null) {
                builder.append(childPrefix).append("/ ").append("\n");
                builder.append(buildTreeString(node.getLeft(), childPrefix, false));
            }
            if (node.getRight() != null) {
                builder.append(childPrefix).append("\\ ").append("\n");
                builder.append(buildTreeString(node.getRight(), childPrefix, false));
            }
        }

        return builder.toString();
    }



}