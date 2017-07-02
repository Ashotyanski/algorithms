package leetcode.easy;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(4,1));
    }

    static public int hammingDistance(int x, int y) {
        String xor = Integer.toBinaryString(x ^ y);
        int count = 0;
        for(int i = 0; i < xor.length(); i++){
            if(xor.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
