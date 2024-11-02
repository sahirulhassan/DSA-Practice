package arrays;

import java.util.Scanner;

public class Shorthand {
    public static int[] user1dArr() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers in your array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " numbers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    public static int[][] user2dArr() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the total number of columns: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element at [%d][%d]: ", i, j);
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static void arrPrinter(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void arrPrinter(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static int min(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
