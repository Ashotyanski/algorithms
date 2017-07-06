package clrs.chapter8;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        double[] array = new double[]{.24, .01, .12, .84, .57, .93, .71, .69, .72, .43, .61};
        Double[] sorted = bucketSort(array);
        System.out.println(Arrays.toString(sorted));
    }

    static Double[] bucketSort(double[] array) {
        List[] lists = new List[array.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (double num : array) {
            lists[(int) ((double) array.length * num)].add(num);
        }
        for (int i = 0; i < array.length; i++) {
            insertionSort(lists[i]);
        }
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            result.addAll(lists[i]);
        }
        return result.toArray(new Double[result.size()]);
    }

    static void insertionSort(List list) {
        for (int i = 0; i < list.size(); i++) {
            int j = i - 1;
            Double current = (Double) list.get(i);
            while ((j > 0) && (Double) list.get(j) < current) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }
}
