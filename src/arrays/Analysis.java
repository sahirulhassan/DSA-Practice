package arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Sorter {

    int[] originalArr;
    int len, swaps, comparisons;
    long start, end, elapsed;

    Sorter(int[] arr) {
        originalArr = arr;
        len = originalArr.length;
    }

    public int[] sorter(String algo) {
        swaps = 0;
        comparisons = 0;
        int[] arr = Arrays.copyOf(originalArr, originalArr.length);
        start = System.currentTimeMillis();
        switch (algo) {
            case "bubble":
                bubbleSort(arr);
                break;
            case "enhancedbubble":
                enhancedBubbleSort(arr);
                break;
            case "selection":
                selectionSort(arr);
                break;
            case "insertion":
                insertionSort(arr);
                break;
            case "quick":
                QuickSort quicksort = new QuickSort();
                quicksort.quickSort(arr, 0, len-1);
                break;
            case "merge":
                MergeSort mergesort = new MergeSort();
                mergesort.mergeSort(arr, 0, len-1);
                break;
            default:
                System.out.println("Enter a correct sorting algorithm!");
                break;
        }
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("Swaps: " + swaps + ", Comparisons: " + comparisons);
        System.out.println("Time Elapsed: " + elapsed + "ms");
        return arr;
    }

    private int[] bubbleSort(int[] arr) {
        for (int pass = 0; pass < len - 1; pass++) {
            for (int i = 0; i < len - pass - 1; i++) {
                comparisons++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swaps++;
                }
            }
        }
        return arr;
    }

    private int[] enhancedBubbleSort(int[] arr) {
        for (int pass = 0; pass < len - 1; pass++) {
            boolean swap = false;
            for (int i = 0; i < len - pass - 1; i++) {
                comparisons++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                    swaps++;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }

    private int[] selectionSort(int[] arr) {
        for (int i = 0; i < len-1; i++) {
            int lowestIDX = i;
            for (int j = i+1; j < len; j++) {
                comparisons++;
                if (arr[j] < arr[lowestIDX]) {
                    lowestIDX = j;
                }
            }
            if (lowestIDX != i) {
                int temp = arr[i];
                arr[i] = arr[lowestIDX];
                arr[lowestIDX] = temp;
                swaps++;
            }
        }
        return arr;
    }

    private int[] insertionSort(int[] arr) {
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                    swaps++;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return arr;
    }
    private  class QuickSort {
        private int partition(int[] arr, int low, int high) {
            int i = low;
            for (int j = low; j < high; j++) {
                //Sorting the smaller numbers to the left of the Pivot.
                comparisons++;
                if (arr[j] < arr[high]) { //arr[high] is the pivot. It can be any other element as well, but we chose the last.
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                    swaps++;
                }
            }
            //Swapping the pivot in its correct place in the order
            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;
            swaps++;
            return i;
        }

        private int[] quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pidx = partition(arr, low, high);
                quickSort(arr, low, pidx - 1);
                quickSort(arr, pidx + 1, high);
            }
            return arr;
        }
    }
    private class MergeSort {
        private int[] mergeSort(int [] arr, int low, int high) {
            if (low < high) {
                int mid = low+(high-low)/2; /* high-low/2 finds the midpoint relative to zero, but we are working with sub-arrays here, and we need to find the mid-point relative to 'low' instead of 0. For example, in an array of size 6, we have a sub array from idx 3 till 5. If we try to find the mid-point using high-low/2 it would give us (5-3)/2 -> 2/2 -> 1, which is not the correct mid-point. By using low+(high-low)/2, we get 3+(5-3)/2 -> 3+3/2 -> 3+1 -> 4, which is the correct mid-point. */
                mergeSort(arr, low, mid);
                mergeSort(arr, mid+1, high);

                merge(arr, low, mid, high);
            }
            return arr;
        }
        private int[] merge(int[] arr, int low, int mid, int high) {
            int nL = mid-low+1; //+1 because previously we included middle in the left array.
            int nR = high-mid;

            int[] lArr = new int[nL];
            int[] rArr = new int[nR];

            /*
            for (int i=0; i<nL; i++) {
                lArr[i] = arr[low+i]; // low to offset to the start of the subarray. +i to increment (as low itself does not increment)
            }
            for (int j=0; j<nR; j++) {
                rArr[j] = arr[mid+1+j]; // mid+1 to offset till ahead of mid. +j to increment (as mid+1 itself does not increment)
            } */
            //.arraycopy is the better approach but use the manual population method if Marvi complains.
            System.arraycopy(arr, low, lArr, 0, nL);
            System.arraycopy(arr, mid+1, rArr, 0, nR);

            int i=0, j=0, k=low;

            while (i<nL && j<nR) {
                comparisons++;
                if (lArr[i] <= rArr[j]) {
                    arr[k] = lArr[i];
                    i++;
                }
                else {
                    arr[k] = rArr[j];
                    j++;
                }
                swaps++;
                k++;
            }
            while (i<nL) {
                arr[k] = lArr[i];
                i++;
                k++;
                swaps++;
            }
            while (j<nR) {
                arr[k] = rArr[j];
                j++;
                k++;
                swaps++;
            }
            return arr;
        }
    }
}

public class Analysis {

    private static String userInput(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[5000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(500);
        }
        Sorter sorter = new Sorter(arr);
        for (int i = 0; i < 6; i++) {
            sorter.sorter(userInput("\nEnter the sorting Algorithm: "));
        }
    }
}