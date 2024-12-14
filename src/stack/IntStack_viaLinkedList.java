package stack;

import linked_list.SinglyLinkedList;

public class IntStack_viaLinkedList {
    private final SinglyLinkedList stack;

    public IntStack_viaLinkedList() {
        stack = new SinglyLinkedList();
    }

    public void push(int data) {
        stack.prepend(data);
    }

    public int pop() {
        if (stack.getHead() == null) {
            throw new IllegalArgumentException("Stack is empty.");
        }

        int data = stack.getHead().getData();
        stack.setHead(stack.getHead().getNext());
        return data;
    }

    public int peek() {
        if (stack.getHead() == null) {
            throw new IllegalArgumentException("Stack is empty.");
        }

        return stack.getHead().getData();
    }

    public boolean isEmpty() {
        return stack.getHead() == null;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
