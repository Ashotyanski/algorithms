package clrs.chapter8;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
//        int[] array = new int[]{2, 5, 3, 1, 4, 6, 0};
        int[] array = new int[]{6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
        int[] sorted = countingSort(array);
        System.out.println(Arrays.toString(sorted));
    }

    static int[] countingSort(int[] array) {
        int[] B = new int[array.length];
        countingSort(array, B, array.length);
        return B;
    }

    static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        Arrays.fill(C, 0);
        for (int i = 0; i < k; i++) {
            C[A[i]] += 1;
        }
        for (int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]] -= 1;
        }
    }
}
