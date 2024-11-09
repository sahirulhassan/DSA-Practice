package queue;

class EmptyQueueException extends RuntimeException {
    EmptyQueueException() {
        super("Error: Queue is empty");
    }
}
