package main.java.sorting.old;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class TestArrays {
    public static final int[] RANDOM = new int[0];
    public static int[] getRandom(String input){
        int[] ints  = new int[10000];
        try(Scanner scanner = new Scanner(new File(input))) {
            for (int i = 0; i<ints.length; i++) {
                ints[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ints;
    }
}