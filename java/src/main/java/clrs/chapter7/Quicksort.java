package clrs.chapter7;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 1, 4, 6, 0};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        tailrecQuickSort(array, 0, array.length - 1);
    }

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = HoarePartition(array, start, end);
            quickSort(array, start, middle - 1);
            quickSort(array, middle + 1, end);
        }
    }

    static void tailrecQuickSort(int[] array, int start, int end) {
        while (start < end) {
            int middle = randomizedMedianPartition(array, start, end);
            tailrecQuickSort(array, start, middle - 1);
            start = middle + 1;
        }
    }

    static int HoarePartition(int[] array, int start, int end) {
        int i = end;
        int pivot = array[i];
        end--;
        while (start <= end) {
            if (array[start] > pivot) {
                start++;
                continue;
            }
            if (array[end] < pivot) {
                end--;
                continue;
            }
            int tmp = array[end];
            array[end] = array[start];
            array[start] = tmp;
            start++;
            end--;
        }
        int tmp = array[i];
        array[i] = array[start];
        array[start] = tmp;
        return start;
    }

    static int trueHoarePartition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start + 1;
        int j = end - 1;
        while (true) {
            while (array[j] > pivot) {
                j--;
            }
            while (array[i] < pivot) {
                i++;
            }
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            } else {
                return j;
            }
        }
    }

    static int randomizedMedianPartition(int[] array, int start, int end) {
        int i = random.nextInt(end - start) + start;
        if (start - end > 3) {
            int j = random.nextInt(end - start) + start;
            int k = random.nextInt(end - start) + start;
            i = j < k ? (i < j ? j : i) : (i < k ? k : i);
        }
        int tmp = array[end];
        array[end] = array[i];
        array[i] = tmp;
        return partitionDesc(array, start, end);
    }

    static int randomizedPartition(int[] array, int start, int end) {
        int i = random.nextInt(end - start) + start;
        int tmp = array[end];
        array[end] = array[i];
        array[i] = tmp;
        return partitionDesc(array, start, end);
    }

    static int partitionAsc(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
        int tmp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = tmp;
        return i + 1;
    }

    static int partitionDesc(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] > pivot) {
                i++;
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
        int tmp = array[end];
        array[end] = array[i + 1];
        array[i + 1] = tmp;
        return i + 1;
    }
}
