package stack;

public class FullStackException extends RuntimeException {
    public FullStackException() {
        super("Error: Stack is full.");
    }
}