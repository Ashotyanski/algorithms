package leetcode.medium;

import java.util.*;
import java.lang.*;

class _50_Pow {
    public static void main(String[] args) {
        double res = new _50_Pow().myPow(2.100, 2147483647);
        System.out.println(res);
    }

    // dont have time to think about [concise] sign/fraction handling techniques
    // the main idea is to cut the complexity to logn
    public double myPow(double x, int n) {
        double acc = Math.abs(x);
        double res = 1;
        long nabs = Math.abs((long) n);
        while (nabs > 0) {
            if ((nabs & 1) == 1) {
                res *= acc;
            }
            acc *= acc;
            nabs >>= 1;
        }
        int sign = 1;
        if (x < 0 && n % 2 == 1) {
            sign = -1;
        }
        if (n < 0) {
            return sign / (double) res;
        }
        return res * sign;
    }
}