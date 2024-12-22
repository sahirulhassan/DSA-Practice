package tree.AVL;

public class Test {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        System.out.println(tree.search(5));
        System.out.println(tree.search(10));
        System.out.println(tree);
    }
}
