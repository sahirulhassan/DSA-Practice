package tree.AVL;

public class AVLNode {
    private int data;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        return (left == null ? 0 : left.height) - (right == null ? 0 : right.height);
    }

    public void updateHeight() {
        height = 1 + Math.max(left == null ? 0 : left.height, right == null ? 0 : right.height);
    }
}