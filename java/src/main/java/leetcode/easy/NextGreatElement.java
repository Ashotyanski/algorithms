package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    private static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}
