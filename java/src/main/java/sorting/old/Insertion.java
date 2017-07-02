package main.java.sorting.old;

public class Insertion extends Algorithm {

    public Insertion(int[] array) {
        super(array);
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j;
            for (j = i; j > 0 && current<array[j-1] ; j--) {
                array[j] = array[j-1];
            }
            array[j] = current;
        }
        time = System.currentTimeMillis() -time;
        average+=time;
    }
}
