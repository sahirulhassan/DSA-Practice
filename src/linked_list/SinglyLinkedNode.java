package linked_list;

public class SinglyLinkedNode {
    private int data;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }
}
