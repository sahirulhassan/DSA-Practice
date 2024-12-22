package queue.circular;

import queue.EmptyQueueException;
import queue.FullQueueException;

import java.util.Arrays;

//Circular queue using pure arithmetic.
public class CircularQueue2 {
    final public int size;
    private int[] queue;
    private int rear, front;

    public CircularQueue2(int size) {
        this.size = size;
        queue = new int[size];
        rear = -1;
        front = -1;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new FullQueueException();
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = element;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        int popped = queue[front];

        if (front == rear) { /* Reset if front encounters rear i.e. last element has been popped and instead of
        incrementing we reset it. */
            front = -1;
            rear = -1;
        } else { //if it does not then move forward as usual.
            front = (front + 1) % size;
        }

        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == (rear+1) % size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements: " + Arrays.toString(queue));
        }
    }
}
