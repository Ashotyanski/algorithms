package main.java.sorting.old;

public class DoubleSelection extends Algorithm {

    public DoubleSelection(int[] array) {
        super(array);
    }

    @Override
    public void Sort() {
        times++;
        time = System.currentTimeMillis();
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            int dummy_index = i;
            int dummy = array[dummy_index];
            for (int k = i; k < j+1; k++) {
                if(array[k]>dummy){
                    dummy = array[k];
                    dummy_index = k;
                }
            }
            int tmp = array[dummy_index];
            array[dummy_index] = array[j];
            array[j] = tmp;
            j--;

            dummy_index = j;
            dummy = array[dummy_index];
            for(int k = j; k > i-1; k--){
                if(array[k]< dummy){
                    dummy = array[k];
                    dummy_index = k;
                }
            }
            tmp = array[dummy_index];
            array[dummy_index] = array[i];
            array[i] = tmp;
            i++;

        }
        time =  System.currentTimeMillis()-time;
        average+=time;
    }
}
