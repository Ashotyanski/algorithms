package clrs.chapter2;


import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] unsortedArray = new int[]{5, 4, 3, 2, 1};
//        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(sortRecursive(unsortedArray)));

//        int[] A = new int[]{0, 0, 0, 1};
//        int[] B = new int[]{0, 1, 1, 1};
//        System.out.println(Arrays.toString(addBinary(A, B)));
    }

    /*
    sort an array in increasing order
     */
    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
//            for (j = i - 1; j >= 0 && current < array[j]; j--) {
//                array[j + 1] = array[j];
//            }
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }

    private static int[] sortReverse(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            int current = array[i];
            int j = i + 1;
            while (j < array.length && current > array[j]) {
                array[j - 1] = array[j];
                j++;
            }
            array[j - 1] = current;
        }
        return array;
    }

    private static int[] sortRecursive(int[] array) {
        return sortRecursive(array, array.length - 1);
    }

    private static int[] sortRecursive(int[] array, int n) {
        if (n > 0) {
            sortRecursive(array, n - 1);
            insert(array, n);
        }
        return array;
    }

    private static int[] insert(int[] array, int n) {
        int i = n - 1;
        int current = array[n];
        while (i > -1 && current < array[i]) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = current;
        return array;
    }

    private static int[] addBinary(int[] A, int[] B) {
        int[] C = new int[A.length + 1];
        for (int i = A.length - 1; i > -1; i--) {
            int sum = A[i] + B[i] + C[i + 1];
            C[i + 1] = sum % 2;
            if (sum > 1)
                C[i] = sum - 1 % 2;
        }
        if (C[0] > 1)
            C[0] = C[0] - 1 % 2;

        return C;
    }
}
