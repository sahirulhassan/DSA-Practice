package arrays;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

    public static void main(String[] args) {
        int n = 50; // Example input
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
