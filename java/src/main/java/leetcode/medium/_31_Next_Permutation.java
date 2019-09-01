package leetcode.medium;

import java.util.*;

class _31_Next_Permutation {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        new _31_Next_Permutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int nlen = nums.length;
        int dec = nlen;
        for (int i = nlen - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                dec = i - 1;
                break;
            }
        }
        System.out.println(dec);
        if (dec < nlen) {
            int toSwap = dec;
            for (int i = dec + 1; i < nlen; i++) {
                if (nums[dec] < nums[i] && (toSwap == dec || nums[i] <= nums[toSwap])) {
                    toSwap = i;
                }
            }
            System.out.println(toSwap);

            int tmp = nums[toSwap];
            nums[toSwap] = nums[dec];
            nums[dec] = tmp;
        } else {
            dec = -1;
        }
        for (int i = 1; i < (nlen - dec - 1) / 2; i++) {
            int tmp = nums[dec + i];
            nums[dec + i] = nums[nlen - i];
            nums[nlen - i] = tmp;
        }
    }
}