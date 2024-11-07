package stack;

import java.util.Arrays;

public class CharStack {
    final public int size;
    private int top;
    private char[] stack;

    public CharStack(int size) {
        this.size = size;
        stack = new char[size];
        top = -1;
    }
    public CharStack(char[] arr) {
        stack = arr;
        size = arr.length;
        top = size - 1;
    }

    public void push(char element) {
        if (isFull()) {
            throw new FullStackException();
        } else {
            stack[++top] = element;
        }
    }
    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top--];
        }
    }
    public char peek() {
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
