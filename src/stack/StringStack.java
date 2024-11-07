package stack;

import java.util.Arrays;

public class StringStack {
    final public int size;
    private int top;
    private String[] stack;

    public StringStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }
    public StringStack(String[] arr) {
        stack = arr;
        size = arr.length;
        top = size - 1;
    }

    public void push(String element) {
        if (isFull()) {
            throw new FullStackException();
        } else {
            stack[++top] = element;
        }
    }
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top--];
        }
    }
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top];
        }
    }
    public boolean isFull() {
        return top == size-1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void print() {
        System.out.println(Arrays.toString(stack));
    }
}
