package leetcode.easy;

/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.

 */
public class NumberComplement {
    public static void main(String[] args) {
        int i = 5;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(findComplement(i)));
//        findComplement(3);
    }

    static public int findComplement(int num) {
        int mask = 1;
        int i = num;
        while (i > 0) {
            i = i >> 1;
            mask = mask << 1;
        }
        mask--;
        System.out.println(Integer.toBinaryString(mask));
        return mask - num;
    }
}
