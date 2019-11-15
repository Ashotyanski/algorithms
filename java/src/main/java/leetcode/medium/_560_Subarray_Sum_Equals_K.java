package leetcode.medium;

import java.lang.*;
import java.util.*;

public class  _560_Subarray_Sum_Equals_K {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;

		int n = nums.length;
		if (n  == 0) {
			return 0;
		}
		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}
			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(new _560_Subarray_Sum_Equals_K().subarraySum(new int[] {
			0,0,0,0,0,0,0,0,0,0
		}, 0));
	}
}

