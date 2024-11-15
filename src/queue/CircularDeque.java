package queue;

public class CircularDeque {
    private final int[] deque;
    private int front;
    private int rear;
    private int noOfElements;
    private final int size;

    public CircularDeque(int size) {
        this.size = size;
        this.deque = new int[size];
        this.noOfElements = 0;
    }

    public boolean isFull() {
        return noOfElements == size;
    }

    public boolean isEmpty() {
        return noOfElements == 0;
    }

    public void enqueueFront(int data) {
        if (isFull()) {
            throw new FullQueueException();
        }
        if (isEmpty()) {
            rear = front = 0; //can be any other number, since we are wrapping.
        } else {
            front = (front - 1 + size) % size;
        }
        deque[front] = data;
        noOfElements++;
    }

    public void enqueueRear(int element) {
        if (isFull()) {
            throw new FullQueueException();
        }
        if (isEmpty()) {
            rear = front = 0; //can be any other number, since we are wrapping.
        } else {
            rear = (rear + 1) % size;
        }
        deque[rear] = element;
        noOfElements++;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int data = deque[front];
        front = (front + 1) % size;
        noOfElements--;
        return data;
    }

    public int dequeueRear() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int data = deque[rear];
        rear = (rear - 1 + size) % size;
        noOfElements--;
        return data;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return deque[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return deque[rear];
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int index = front;
        System.out.print("Queue Elements: ");
        for (int i = 0; i < noOfElements; i++) {
            System.out.print(deque[index] + " ");
            index = (index + 1) % size;
        }
        System.out.println();
    }
}