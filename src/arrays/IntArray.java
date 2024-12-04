package arrays;

import java.util.Arrays;

public class IntArray {
    private final int[] array;
    private int size;

    public IntArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }
    public IntArray(int[] array) {
        this.array = array;
        size = array.length;
    }

    public void insert(int element, int index) {
        if (size == array.length) {
            System.out.println("Array is full. Cannot insert.");
            return;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void overwrite(int element, int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        array[index] = element;
    }

    public void delete(int index) {
        if (size == 0) {
            System.out.println("Array is empty. Cannot delete.");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(array, size)));
    }
}