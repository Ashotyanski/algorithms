package clrs.chapter8;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 1, 4, 6, 0};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void radixSort(int[] array) {
        int max = array[0];
        for (int num : array)
            if (num > max)
                max = num;
        int maxDigitNum = 1;
        while (Math.pow(10, maxDigitNum) < max)
            maxDigitNum++;
        radixSort(array, maxDigitNum);
    }

    static void radixSort(final int[] array, int maxDigitNum) {
        for (int d = 1; d <= maxDigitNum; d++) {
            countingSortSubroutine(array, d);
        }
    }

    static void countingSortSubroutine(final int[] array, int digitNum) {
        int[] C = new int[10];
        Arrays.fill(C, 0);
        for (int num : array) {
            C[getDigit(num, digitNum)]++;
        }
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int digit = getDigit(array[i], digitNum);
            result[C[digit] - 1] = array[i];
            C[digit] = C[digit] - 1;
        }
        System.arraycopy(result, 0, array, 0, result.length);
    }

    static int getDigit(int num, int digitNum) {
        return (int) ((num % Math.pow(10, digitNum) - (num % (Math.pow(10, digitNum - 1)))) / Math.pow(10, digitNum - 1));
    }
}
