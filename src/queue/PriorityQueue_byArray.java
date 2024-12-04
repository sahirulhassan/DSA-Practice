package queue;

import java.util.Arrays;

public class PriorityQueue_byArray {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueue_byArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public void enqueue(int element) {
        if (size == capacity) {
            throw new IllegalStateException("Priority Queue is full!");
        }

        // Find the correct position to insert the element
        int i = size - 1;
        while (i >= 0 && queue[i] > element) {
            queue[i + 1] = queue[i]; // Shift elements to the right
            i--;
        }

        // Insert the element at the correct position
        queue[i + 1] = element;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty!");
        }
        int highestPriority = queue[0]; // Element with the highest priority
        // Shift all elements to the left
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--;
        return highestPriority;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty!");
        }
        return queue[0]; // Return the element at the front of the queue
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(queue, size));
    }
}
