package queue;

import java.util.Arrays;

//Circular queue using clear logic.
public class CircularQueue {
    final public int size;
    private int[] queue;
    private int rear, front, elements;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        rear = -1;
        front = 0;
        elements = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new FullQueueException();
        }
        if (rear == size - 1) { /*resetting to -1 when rear reaches last index. We can also use (rear+1)%size */
            rear = -1;
        }
        queue[++rear] = element;
        elements++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (front == size) { /*resetting to zero when rear reaches last index. We can also use (front+1)%size */
            front = 0;
        }

        int popped = queue[front++];
        elements--;

        if (isEmpty()) { // Reset if queue becomes empty
            front = 0;
            rear = -1;
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
        return elements == 0;
    }

    public boolean isFull() {
        return elements == size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements: " + Arrays.toString(queue));
        }
    }
}
