package arrays;

import static arrays.Shorthand.max;
import static arrays.Shorthand.min;

public class ExtraSorters {
    public static class RadixSort {
        private static void countSort(int[] arr, int exp) { // modified count sort for Radix Sort.
            int n = arr.length;
            int[] sortedArr = new int[n];
            int[] counter = new int[10];
            for (int num : arr) {
                int digit = (num / exp) % 10;
                counter[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                counter[i] += counter[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                sortedArr[counter[arr[i]] - 1] = arr[i];
                counter[arr[i]]--;
            }
            System.arraycopy(sortedArr, 0, arr, 0, n);
        }

        public static int[] radixSort(int[] arr) {
            int max = max(arr);
            for (int exp = 1; max / exp > 0; exp *= 10) {
                countSort(arr, exp);
            }
            return arr;
        }
    }
    public static class CountSort {
        public static int[] countSort_Stable(int[] arr) {
            int n = arr.length;
            int max = max(arr);
            int min = min(arr);
            int[] counter = new int[max - min + 1]; // this gives us the total range of elements in the array, min, max included.
            int[] sorted = new int[n];
            for (int num : arr) {
                counter[num - min] ++; // - min shifts all elements to the right in case there are negative numbers.
            }
            for (int i = 1; i < counter.length; i++) {
                counter[i] += counter[i-1];
            }
            for (int i = n - 1; i >= 0; i--) {
                sorted[counter[arr[i] - min] - 1] = arr[i];
                counter[arr[i] - min] --; // if we remove all - min from this code, this code will stop working for negative values.
            }
            return sorted;
        }

        public static int[] countSort_Unstable(int[] arr) {
            // finding the highest value in the array
            int highest = max(arr);
            // creating an auxiliary array where the index represents the element and the value at that index represents the count of occurrences of that element.
            int[] counter = new int[highest + 1];
            for (int num : arr) {
                counter[num]++;
            }
            // rebuilding the sorted array
            int idx = 0; // target array index
            for (int i = 0; i < counter.length; i++) { //traversal through the counter array
                while (counter[i] > 0) {
                    arr[idx] = i; // placing one occurrence of the respective number
                    idx++; // advancing one index ahead
                    counter[i]--; //deducting from counter
                }
            }
            return arr;
        }

    }
}
