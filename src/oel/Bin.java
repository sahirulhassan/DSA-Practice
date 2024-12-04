package oel;

import java.util.NoSuchElementException;
import java.util.Stack;

class Bin {
    private Stack<Product> bin;
    private final int capacity;

    public Bin(int capacity) {
        this.capacity = capacity;
        this.bin = new Stack<>();
    }

    public boolean isFull() {
        return bin.size() == capacity;
    }

    public boolean isEmpty() {
        return bin.isEmpty();
    }

    public void addProduct(Product product) {
        if (!isFull()) {
            bin.push(product);
        } else {
            throw new IllegalStateException("OVERFLOW: Bin is full");
        }
    }

    public Product removeProduct() {
        if (!isEmpty()) {
            return bin.pop();
        } else {
            throw new NoSuchElementException("Bin is empty");
        }
    }

    public int getSize() {
        return bin.size();
    }

    @Override
    public String toString() {
        return "Bin [Products: " + bin + "]";
    }
}
