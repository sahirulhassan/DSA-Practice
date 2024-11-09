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
        if (!isFull()) {
            queue[++rear] = element;
        } else {
            throw new FullStackException();
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            return queue[front++];
        } else {
            throw new EmptyStackException();
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            throw new EmptyStackException();
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
