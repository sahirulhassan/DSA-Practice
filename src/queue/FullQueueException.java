package queue;

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("Error: Queue is full.");
    }
}