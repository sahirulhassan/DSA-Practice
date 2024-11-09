package stack;

class EmptyStackException extends RuntimeException {
    EmptyStackException() {
        super("Error: Stack is empty");
    }
}
