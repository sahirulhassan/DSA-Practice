package stack;

import java.util.Arrays;

public class IntStack {
    final public int size;
    private int top;
    private int[] stack;

    public IntStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    public IntStack(int[] arr) {
        stack = arr;
        size = arr.length;
        top = size - 1;
    }

    public void push(int element) {
        if (isFull()) {
            throw new FullStackException();
        } else {
            stack[++top] = element;
        }
    }
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int popped = stack[top];
            stack[top] = 0;
            top--;
            return popped;
        }
    }
    public int peek() {
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
