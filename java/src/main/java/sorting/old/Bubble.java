package main.java.sorting.old;

public class Bubble extends Algorithm {

    public Bubble(int[] array) {
        super(array);
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < this.array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        time = System.currentTimeMillis()-time;
        average+= time;
    }
}
