package stack;

class FullStackException extends RuntimeException {
    FullStackException() {
        super("Error: Stack is full.");
    }
}