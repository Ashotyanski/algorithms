package main.java.sorting.old;

import java.util.*;

public class Main {

    public static void main(String ... args) {
        System.out.println("\nWhich algorithm you want to choose? (algorithm the corresponding number)");
        System.out.println("\n1: Bubble | 2: Selection | 3: Quick | 4: DoubleSelection | 5: Merge | 6: Insertion" );
        System.out.println();
        Scanner scan = new Scanner(System.in);

        Algorithm algorithm = null;
        int[] array = TestArrays.getRandom(args[0]);//randomArray();
        //int[] array = randomArray();

        try{
            switch (Integer.parseInt(scan.next())){
                case 1 :{
                    algorithm = new Bubble(array);
                    break;
                }
                case 2 :{
                    algorithm = new Selection(array);
                    break;
                }
                case 3 :{
                    algorithm = new Quick(array);
                    break;
                }
                case 4 :{
                    algorithm = new DoubleSelection(array);
                    break;
                }
                case 5:{
                    algorithm = new Merge(array);
                    break;
                }
                case 6:{
                    algorithm = new Insertion(array);
                    break;
                }
                default:{
                    System.out.println("Number is not enlisted, choose the correct one");
                    System.exit(0);
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Format error!");
            System.exit(0);
        }

        for (int i = 0; i < 10; i++) {
            //algorithm.Print();
            algorithm.Sort();
            //algorithm.Print();
            algorithm.Check();
            //algorithm.setArray(randomArray());
            algorithm.setArray(TestArrays.getRandom(args[0]));
        }
        algorithm.Performance();

    }

    static int[] randomArray(){
        int[] randomArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100000);
        }

        return randomArray;
    }
}
