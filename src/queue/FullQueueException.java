package queue;

class FullQueueException extends RuntimeException {
    FullQueueException() {
        super("Error: Queue is full.");
    }
}