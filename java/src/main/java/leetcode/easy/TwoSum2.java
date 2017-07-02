package leetcode.easy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TwoSum2 {
    public static void main(String[] args) {
//        int[] numbers = new int[]{2, 3, 4};
//        int[] numbers = new int[]{5, 25, 75};
        int[] numbers = new int[]{0, 2, 3, 9, 20, 30};
//        int[] numbers = new int[]{-1, 0};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
