package clrs.chapter2;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] array = new int[]{3, 26, 41, 52, 9, 38, 49, 57};
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(sort(array)));
//        merge(array, 0, 3, 7);
    }

    private static int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private static int[] sort(int[] array, int right, int left) {
        if (right < left) {
            int middle = (right + left) / 2;
            sort(array, right, middle);
            sort(array, middle + 1, left);
            merge(array, right, middle, left);
        }
        return array;
    }

    private static int[] merge(int[] array, int right, int middle, int left) {
        int[] R = new int[middle - right + 1];
        int[] L = new int[left - middle];
        System.arraycopy(array, right, R, 0, R.length);
        System.arraycopy(array, middle + 1, L, 0, L.length);

        int i = 0, j = 0, k = right;
        while (i < R.length && j < L.length) {
            if (R[i] < L[j]) {
                array[k] = R[i];
                i++;
            } else {
                array[k] = L[j];
                j++;
            }
            k++;
        }
        if (k != left)
            if (j != L.length) {
                System.arraycopy(L, j, array, k, L.length - j);
            } else
                System.arraycopy(R, i, array, k, R.length - i);

        return array;
    }
}
