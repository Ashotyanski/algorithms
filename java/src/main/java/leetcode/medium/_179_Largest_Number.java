package leetcode.medium;

import java.lang.*;
import java.util.*;

class _179_Largest_Number {
    public static void main(String[] args) {
        String res = new _179_Largest_Number().largestNumber(new int[]{
            // 10,2
            // 128,12
            // 3,30,34,5,9
            // 30,3,
            // 12, 121
            // 0,10
            8248,824
        });
        System.out.println(res);
    }

    // dumbest question ever
    // gotta be super motivated to actually debug this instead of randomly changing everything
    public String largestNumber(int[] nums) {

        List<Integer> arr = new ArrayList<>(nums.length);
        for (int n: nums) {
            arr.add(n);
        }

        arr.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer a1, Integer b1) {
                // return a.compareTo(b);
                // int a = a1.intValue();
                // int b = b1.intValue();

                System.out.println(a1);
                System.out.println(b1);

                String a = String.valueOf(a1);
                String b = String.valueOf(b1);

                int slen = Math.min(a.length(), b.length());
                int i = 0;
                for (; i < slen; i++) {
                    char ai = a.charAt(i);
                    char bi = b.charAt(i);
                    if (ai < bi) {
                        return 1;
                    } else if (ai > bi) {
                        return -1;
                    }
                }

                if (i < b.length()) {
                    System.out.println("B rem");
                    // int first = i - 1;
                    int first = 0;
                    int j = 0;
                    for (; i + j < b.length(); j++) {
                        if (b.charAt(first) > b.charAt(i + j)) {
                            return -1;
                        } else if (b.charAt(first) < b.charAt(i + j)) {
                            return 1;
                        }
                    }
                    if (b.charAt(i - 1) < b.charAt(i + j - 1)) {
                        return 1;
                    } else if (b.charAt(i - 1) > b.charAt(i + j - 1)) {
                        return -1;
                    }
                } else if (i < a.length()) {
                    System.out.println("A rem");
                    // int first = i - 1;
                    int first = 0;

                    int j = 0;
                    for (; i + j < a.length(); j++) {
                        if (a.charAt(first) > a.charAt(i + j)) {
                            return 1;
                        } else if (a.charAt(first) < a.charAt(i + j)) {
                            return -1;
                        }
                    }
                    if (a.charAt(i - 1) < a.charAt(i + j - 1)) {
                        return -1;
                    } else if (a.charAt(i - 1) > a.charAt(i + j - 1)) {
                        return 1;
                    }

                }
                return 0;
            }
        });
        if (arr.get(0) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }

    // 301, 302
    // 302301

    // 30, 301
    // 30301

}