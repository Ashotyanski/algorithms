package main.java.sorting.old;

public class Selection extends Algorithm {

    public Selection(int[] array) {
        super(array);
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();

        for (int i = 0; i < this.array.length - 1; i++) {
            int min = array[i];
            int num = i;
            for (int j = i+1; j < this.array.length; j++) {
                if (array[j] < min) {
                    num = j;
                    min = array[j];
                }
            }

            int tmp = array[num];
            array[num] = array[i];
            array[i] = tmp;
        }
        time = System.currentTimeMillis()-time;
        average+= time;
    }
}
