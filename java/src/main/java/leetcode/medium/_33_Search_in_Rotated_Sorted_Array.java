package leetcode.medium;

import java.util.Arrays;

class _33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int res = new _33_Search_in_Rotated_Sorted_Array().search(new int[]{9,7}, 7);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        // find pivot
        int l = 0, r = nums.length - 1;

        int finalL = l, finalR = r;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[l] > nums[m]) {
                if (nums[m - 1] > nums[m]) {
                    if (nums[0] <= target && nums[m - 1] >= target) {
                        finalL = 0;
                        finalR = m - 1;
                    } else {
                        finalL = m;
                        finalR = nums.length - 1;
                    }
                    System.out.println("Pivot found (l)");
                    break;
                }
                r = m - 1;
            } else if (nums[m] > nums[r]) {
                if (nums[m] > nums[m + 1]) {
                    System.out.println("Pivot found (r)");
                    if (nums[0] <= target && nums[m] >= target) {
                        finalL = 0;
                        finalR = m;
                    } else {
                        finalL = m + 1;
                        finalR = nums.length - 1;
                    }
                    break;
                }
                l = m + 1;
            } else {
                System.out.println("Sorted");
                finalL = l;
                finalR = r;
                break;
            }
        }
        // l r - is an sorted subarray
        System.out.println(l + ", " + r);
        System.out.println(finalL + ", " + finalR);


        // bsearch on one of the sides
        int res = Arrays.binarySearch(nums, finalL, finalR + 1, target);
        return res < 0 ? -1 : res;
    }
}