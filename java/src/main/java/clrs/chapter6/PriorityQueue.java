package clrs.chapter6;

import java.util.Arrays;

import static clrs.chapter6.Heap.buildMaxHeap;

public class PriorityQueue {
    public static void main(String[] args) {
        int[] heap = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        buildMaxHeap(heap);
        System.out.println(Arrays.toString(heap));
        Heap.maxHeapInsert(heap, 10);
    }

    private static int heapMaximum(int[] heap) {
        return heap[0];
    }

    private static int extractHeapMaximum(int[] heap) {
        int max = heap[0];
        heap[0] = heap[heap.length - 1];

        int[] resultHeap = new int[heap.length - 1];
        System.arraycopy(heap, 0, resultHeap, 0, heap.length - 1);

        Heap.maxHeapifyIterative(resultHeap, resultHeap.length, 0);

        System.out.println(Arrays.toString(resultHeap));
        return max;
    }


    private static void heapDelete(int[] heap, int i) {

    }
}
