package arrays;

import java.util.Arrays;

public class IntArrayList {
    private int[] array;
    private int size;

    public IntArrayList(int capacity) {
        array = new int[capacity];
        size = 0;
    }
    public IntArrayList(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        size = array.length;
    }

    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
        resize();
    }

    public void insert(int element) {
        array[size] = element;
        size++;
        resize();
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
        resize();
    }

    private void resize() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        } else if (size < array.length / 2) { // Shrink
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(array, size)));
    }
}