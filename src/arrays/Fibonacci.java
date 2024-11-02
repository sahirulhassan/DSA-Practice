package arrays;

public class Fibonacci {
    int count = 2;
    void fibonacci_recur1(int prev1, int prev2) {
            if(count <= 19) {
                int newFibo = prev1 + prev2;
                System.out.println(count + ": " + newFibo);
                prev1 = prev2;
                prev2 = newFibo;
                count ++;
                fibonacci_recur1(prev1, prev2);
            }
    }
    int fibonacci_recur2(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibonacci_recur2(n - 1) + fibonacci_recur2(n - 2);
        }
    }
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();

        System.out.println("0: 0");
        System.out.println("1: 1");
        obj.fibonacci_recur1(0, 1);

        System.out.println("\n19: " + obj.fibonacci_recur2(19));
    }
}