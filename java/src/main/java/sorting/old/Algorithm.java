package main.java.sorting.old;

public abstract class Algorithm {

    int[] array;
    protected static long average, times;
    protected long time;

    Algorithm(int[] array){
        this.array = array.clone();
        times = 0; average = 0;
    }
    public abstract void Sort();

    public void setArray(int[] array){
        this.array = array;
    }

    public void Print(){
        System.out.print("[ ");
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i]+", ");
        }
        System.out.println("]");
    }

    public void Performance(){
        System.out.println("Average sort time = " + average/times + "ms (" + times + " tests)");
    }

    public void Check(){
        System.out.println(check());
    }
    private boolean check(){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array [i+1]){
                return false;
            }
        }
        return true;
    }
}