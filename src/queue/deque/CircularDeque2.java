package queue.deque;

import queue.EmptyQueueException;
import queue.FullQueueException;

class CircularDeque2 {
    int deque[];
    int front;
    int rear;
    int size;

    public CircularDeque2(int size) {
        front = -1;
        rear = 0;
        this.size = size;
        deque = new int[size];
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void enqueueFront(int key) {
        if (isFull()) {
            throw new FullQueueException();
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        deque[front] = key;
    }

    void enqueueRear(int key) {
        if (isFull()) {
            throw new FullQueueException();
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        }
        else {
            rear++;
        }
        deque[rear] = key;
    }

    int dequeueFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int popped = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        }
        else {
            front++;
        }
        return popped;
    }

    int dequeueRear() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int popped = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        }
        else {
            rear--;
        }
        return popped;
    }

    int peekFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return deque[front];
    }

    int peekRear() {
        if (isEmpty() || rear < 0) {
            throw new EmptyQueueException();
        }
        return deque[rear];
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int index = front;
        System.out.print("Queue Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(deque[index] + " ");
            index = (index + 1) % size;
        }
        System.out.println();
    }
}
