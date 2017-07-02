package clrs.chapter6;

import clrs.utils.SwapUtils;

import java.util.Arrays;

public class DHeap {
    private static int d = 5;

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] sort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            SwapUtils.exchange(array, 0, i);
            maxHeapify(array, i, 0);
        }
        return array;
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / d; i >= 0; i--) {
            maxHeapify(array, array.length, i);
        }
    }

    private static void maxHeapify(int[] array, int heapsize, int i) {
        int largest = i;
        while (true) {
            int firstChild = firstChild(i);

            for (int child = firstChild; child < firstChild + d && child < heapsize; child++) {
                if (array[child] > array[largest])
                    largest = child;
            }

            if (largest != i) {
                SwapUtils.exchange(array, i, largest);
                i = largest;
            } else
                break;
        }
    }

    private static void heapIncreaseKey(int[] heap, int i, int key) {
        if (heap[i] > key)
            throw new RuntimeException("New key is smaller than the previous");
        while (heap[parent(i)] < key) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = key;
    }

    private static int firstChild(int i) {
        return i * d + 1;
    }

    private static int parent(int i) {
        return (i - 1) % d;
    }
}
