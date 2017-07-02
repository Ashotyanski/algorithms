package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    static public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder res = new StringBuilder(8);
            if (i % 3 == 0)
                res.append("Fizz");
            if (i % 5 == 0)
                res.append("Buzz");
            if (res.length() == 0)
                res.append(String.valueOf(i));
            result.add(res.toString());
        }
        return result;
    }
}
