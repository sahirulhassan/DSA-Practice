package queue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Error: Queue is empty");
    }
}
