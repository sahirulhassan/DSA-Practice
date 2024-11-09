package queue;

import stack.FullStackException;
import java.util.Arrays;
import java.util.EmptyStackException;

public class LinearQueue {
    final public int size;
    private int[] queue;
    private int rear, front;

    public LinearQueue(int size) {
        this.size = size;
        queue = new int[size];
        rear = -1;
        front = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new FullStackException();
        } else {
            queue[++rear] = element;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return queue[front++];
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return queue[front];
        }
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements: " + Arrays.toString(Arrays.copyOfRange(queue, front, rear + 1)));
        }
    }
}