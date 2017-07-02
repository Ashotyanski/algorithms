package clrs.chapter2;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(searchRecursive(array, 3));
    }

    private static int search(int[] array, int v) {
        int left = 0, right = array.length - 1;
        int middle = (right + left) / 2;
        while (right > left) {
            middle = (right + left) / 2;
            if (v > array[middle])
                left = middle + 1;
            else right = middle;
        }
        if (v == array[left])
            return left;
        return -1;
    }

    private static int searchRecursive(int[] array, int v) {
        return searchRecursive(array, 0, array.length, v);
    }

    private static int searchRecursive(int[] array, int left, int right, int v) {
        if (left < right) {
            int middle = (left + right) / 2;
            if (v > array[middle])
                return searchRecursive(array, middle + 1, right, v);
            else
                return searchRecursive(array, left, middle, v);
        } else if (array[left] == v) {
            return left;
        }
        return -1;
    }
}
