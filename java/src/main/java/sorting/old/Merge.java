package main.java.sorting.old;


public class Merge extends Algorithm {

    private int[] helper;
    public Merge(int[] array) {
        super(array);
        helper = new int[array.length];
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();
        _Sort(0,array.length-1);
        time = System.currentTimeMillis() - time;
        average+= time;

    }
    private void _Sort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            _Sort(low, middle);
            // Sort the right side of the array
            _Sort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }

    }
}
