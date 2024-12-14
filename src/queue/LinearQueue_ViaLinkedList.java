package queue;

import linked_list.SinglyLinkedList;

public class LinearQueue_ViaLinkedList {
    private final SinglyLinkedList queue;

    public LinearQueue_ViaLinkedList() {
        queue = new SinglyLinkedList();
    }

    public void enqueue(int data) {
        queue.append(data);
    }

    public int dequeue() {
        if (queue.getHead() == null) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        int data = queue.getHead().getData();
        queue.setHead(queue.getHead().getNext());
        return data;
    }

    public int peek() {
        if (queue.getHead() == null) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return queue.getHead().getData();
    }

    public boolean isEmpty() {
        return queue.getHead() == null;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
