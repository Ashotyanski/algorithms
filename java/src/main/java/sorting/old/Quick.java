package main.java.sorting.old;

public class Quick extends Algorithm {

    public Quick(int[] array) {
        super(array);
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();
        _Sort(0, array.length - 1);
        time = System.currentTimeMillis() - time;
        average += time;
    }

    private void _Sort(int start, int end) {
        int i = start;                          // index of left-to-right scan
        int k = end;                            // index of right-to-left scan
        int tmp;
        if (end - start >= 1)                   // check that there are at least two elements to sort
        {
            int pivot = array[start];       // set the pivot as the first element in the partition
            while (k > i)                   // while the scan indices from left and right have not met,
            {
                while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                    i++;                                    // element greater than the pivot
                while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                    k--;                                        // element not greater than the pivot
                if (k > i) {                                     // if the left seekindex is still smaller than
                    tmp = array[i];                              // the right index, swap the corresponding elements
                    array[i] = array[k];
                    array[k] = tmp;
                }
            }
            tmp = array[start];            // after the indices have crossed, swap the last element in
            array[start] = array[k];       // the left partition with the pivot
            array[k] = tmp;
            _Sort(start, k - 1); // quicksort the left partition
            _Sort(k + 1, end);   // quicksort the right partition
        }
    }
}