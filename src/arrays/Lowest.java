package arrays;

import static arrays.Shorthand.*;

public class Lowest {
    public static int lowest(int[] arr) {
        int lowest = arr[0];
        for (int num : arr) {
            if (num < lowest) {
                lowest = num;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        System.out.println("Minimum number in the given array is: " + lowest(user1dArr()));
    }
}
