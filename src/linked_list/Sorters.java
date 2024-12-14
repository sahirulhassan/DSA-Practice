package linked_list;

public class Sorters {
    DoublyLinkedList originalList;
    int len, swaps, comparisons;
    long start, end, elapsed;

    public Sorters(DoublyLinkedList list) {
        originalList = list;
        len = originalList.getSize();
    }

    public DoublyLinkedList sorter(String algo) {
        swaps = 0;
        comparisons = 0;
        DoublyLinkedList list = originalList;
        start = System.currentTimeMillis();
        switch (algo) {
            case "bubble":
                bubbleSort(originalList);
                break;
            case "selection":
                selectionSort(list);
                break;
            case "insertion":
                insertionSort(list);
                break;
            case "quick":
                quickSort(list);
                break;
            case "merge":
                list = mergeSort(list); // mergeSort is not an in-place sorting algorithm
                break;
            default:
                System.out.println("Enter a correct sorting algorithm!");
                break;
        }
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("Swaps: " + swaps + ", Comparisons: " + comparisons);
        System.out.println("Time Elapsed: " + elapsed + "ms");
        return list;
    }

    private void bubbleSort(DoublyLinkedList list) {
        for (int i = 0; i < len - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < len - i - 1; j++) {
                comparisons++;
                if (list.get(j) > list.get(j + 1)) {
                    swaps++;
                    list.swap(j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    private void selectionSort(DoublyLinkedList list) {
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                comparisons++;
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }
            if (min != i) {
                swaps++;
                list.swap(i, min);
            }
        }
    }

    private void insertionSort(DoublyLinkedList list) {
        for (int i = 1; i < len; i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                comparisons++;
                swaps++;
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    private void quickSort(DoublyLinkedList list) {
        quickSortHelper(list, 0, len - 1);
    }

    private void quickSortHelper(DoublyLinkedList list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }

    private int partition(DoublyLinkedList list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (list.get(j) <= pivot) {
                i++;
                swaps++;
                list.swap(i, j);
            }
        }
        swaps++;
        list.swap(i + 1, high);
        return i + 1;
    }

    private DoublyLinkedList mergeSort(DoublyLinkedList list) {
        if (list.getSize() <= 1) {
            return list;
        }
        int mid = list.getSize() / 2;
        DoublyLinkedList left = new DoublyLinkedList();
        DoublyLinkedList right = new DoublyLinkedList();

        DoublyLinkedNode current = list.getHead();
        for (int i = 0; i < mid; i++) {
            left.append(current.getData());
            current = current.getNext();
        }
        while (current != null) {
            right.append(current.getData());
            current = current.getNext();
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private DoublyLinkedList merge(DoublyLinkedList left, DoublyLinkedList right) {
        DoublyLinkedList sorted = new DoublyLinkedList();
        while (!left.isEmpty() && !right.isEmpty()) {
            comparisons++;
            if (left.getHead().getData() <= right.getHead().getData()) {
                sorted.append(left.deleteHead());
            } else {
                sorted.append(right.deleteHead());
            }
        }
        while (!left.isEmpty()) {
            sorted.append(left.deleteHead());
        }
        while (!right.isEmpty()) {
            sorted.append(right.deleteHead());
        }
        return sorted;
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(5);
        list.append(3);
        list.append(8);
        list.append(1);
        list.append(2);
        list.append(7);
        list.append(6);
        list.append(4);
        list.append(9);
        list.append(0);
        Sorters sorter = new Sorters(list);
        list = sorter.sorter("merge");
        System.out.println(list);
    }
}