package queue;

import java.util.Arrays;

public class LinearQueue {
    final public int size;
    private int[] queue;
    private int rear, front;

    public LinearQueue(int size) {
        this.size = size;
        queue = new int[size];
        rear = 0;
        front = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new FullQueueException();
        } else {
            queue[rear++] = element;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            int popped = queue[front++];
            if (isEmpty()) {
                front = rear = 0;
            }
            return popped;
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
        return front == rear;
    }

    public boolean isFull() {
        return rear == size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements: " + Arrays.toString(Arrays.copyOfRange(queue, front, rear)));
        }
    }
}