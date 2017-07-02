package clrs.chapter6;

import clrs.utils.SwapUtils;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
//        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
        int[] array = new int[]{6, 5, 4, 3, 2, 1, 0, -1};
//        buildMaxHeap(array);
//        System.out.println(Arrays.toString((array)));
        System.out.println(Arrays.toString(sortDecreasing(array)));
    }

    private static int[] sortDecreasing(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            SwapUtils.exchange(array, i, 0);
            maxHeapifyIterative(array, i, 0);
        }
        return array;
    }

    static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapifyIterative(array, array.length, i);
        }
    }


    static void maxHeapifyIterative(int[] array, int heapsize, int i) {
        while (true) {
            int left = left(i);
            int right = right(i);
            int largest = i;
            if (left < heapsize && array[largest] < array[left]) {
                largest = left;
            }
            if (right < heapsize && array[largest] < array[right]) {
                largest = right;
            }
            if (largest != i) {
                SwapUtils.exchange(array, i, largest);
                i = largest;
            } else
                break;
        }
    }

    // modified with insertion sort
    private static void heapIncreaseKey(int[] heap, int i, int key) {
        if (key < heap[i])
            throw new RuntimeException("New key is smaller than previous");

        while (i > 0 && heap[parent(i)] < key) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = key;
    }

    static void maxHeapInsert(int[] heap, int key) {
        int[] resultHeap = new int[heap.length + 1];
        System.arraycopy(heap, 0, resultHeap, 0, heap.length);
        resultHeap[resultHeap.length - 1] = Integer.MIN_VALUE;

        heapIncreaseKey(resultHeap, resultHeap.length - 1, key);
        System.out.println(Arrays.toString(resultHeap));
    }

    static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return 2 * i;
    }

    private static int right(int i) {
        return 2 * i + 1;
    }
}
