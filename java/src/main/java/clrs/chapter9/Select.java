package clrs.chapter9;

import java.util.Random;

public class Select {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 1, 4, 6, 0};
        System.out.println(randomizedSelect(array, 7));
    }

    static int randomizedSelect(int[] array, int k) {
        return randomizedSelectIterative(array, 0, array.length - 1, k);
    }

    static int randomizedSelect(int[] array, int start, int end, int k) {
        if (start == end)
            return array[start];
        int pivot = randomizedPartition(array, start, end);
        int pos = pivot - start + 1;
        if (k == pos)
            return array[pivot];
        else if (k < pos)
            return randomizedSelect(array, start, pivot - 1, k);
        else
            return randomizedSelect(array, pivot + 1, end, k - pos);
    }

    static int randomizedSelectIterative(int[] array, int start, int end, int k) {
        while (start != end) {
            int pivot = randomizedPartition(array, start, end);
            int pos = pivot - start + 1;
            if (k == pos)
                return array[pivot];
            else if (k < pos)
                end = pivot - 1;
            else {
                start = pivot + 1;
                k -= pos;
            }
        }
        return array[start];
    }

    static int randomizedPartition(int[] array, int start, int end) {
        int pivot = random.nextInt(end - start) + start;
        int tmp = array[end];
        array[end] = array[pivot];
        array[pivot] = tmp;
        int middle = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                middle++;
                tmp = array[i];
                array[i] = array[middle];
                array[middle] = tmp;
            }
        }
        tmp = array[end];
        array[end] = array[middle + 1];
        array[middle + 1] = tmp;
        return middle + 1;
    }
}
