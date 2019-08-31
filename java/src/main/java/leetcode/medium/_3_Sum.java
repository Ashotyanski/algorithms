package leetcode.medium;

import java.util.*;


class _3_Sum {
	public static void main(String[] args) {
		List<List<Integer>> res = new _3_Sum().threeSum(new int[]{0,0});	
		System.out.println(res);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		// count all unique triplets, that add up to 0
		// so apparently this one is a dumb solution, one can do it easier with two pointers

		if (nums.length == 0) {
			return new ArrayList();
		}
		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		List<List<Integer>> res = new ArrayList<>();

		int prev = nums[0] - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (nums[i] == prev) {
				continue;
			}
			int prevj = prev - 1;
			for (int j = i + 1; j < nums.length; j++) {	
				if (nums[j] == prevj) {
					continue;
				}
				int k = -(nums[i] + nums[j]);
				if (k < nums[j]) {
					break;
				}
				Integer kCount = map.get(k);
				// System.out.println(kCount + " for k: " + k);
				if ((k != nums[j] && kCount != null) || (k == nums[j] && kCount > 1) &&
					(k != nums[i] && kCount != null) || (k == nums[i] && kCount > 1) &&
					(k == nums[i] && k == nums[j] && kCount > 2)
					) {
					res.add(Arrays.asList(nums[i], nums[j], k));
				}
				prevj = nums[j];
			}
			prev = nums[i];
		}
		return res;
    }
}