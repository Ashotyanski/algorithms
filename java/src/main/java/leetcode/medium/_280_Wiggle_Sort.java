package leetcode.medium;

import java.util.Arrays;

class _280_Wiggle_Sort {
	public static void main(String[] args) {
		// int[] arr = new int[]{3, 5, 2, 1, 6, 4};
		// new _280_Wiggle_Sort().sort(arr); // answer [1, 6, 2, 5, 3, 4]
		// System.out.println(Arrays.toString(arr));

		test();
	}

	public void sort(int[] nums) {
		int nlen = nums.length;

		boolean small = true;
		for (int i = 0; i < nlen - 1; i++) {
			if (small) {
				if (nums[i] <= nums[i + 1]) {
					// good!
				} else {
					// i > i + 1
					int tmp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = tmp;
				}
			} else {
				// big
				if (nums[i] >= nums[i + 1]) {
					// good
				} else {
					int tmp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = tmp;
				}
			}
			small = !small;
		}
	}

	public static boolean check(int[] nums) {
		boolean small = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (small) {
				if (nums[i] > nums[i+1]) {
					throw new RuntimeException();
					// return false;
				}
			} else {
				if (nums[i] < nums[i + 1]) {
					throw new RuntimeException();
					// return false;
				}
			}
			small = !small;

		}
		return true;
	}

	public static void test() {
		_280_Wiggle_Sort sorter = new _280_Wiggle_Sort();

		int[] arr = null;
		
		arr = new int[]{3, 5, 2, 1, 6, 4};
		sorter.sort(arr);
		check(arr);
		arr = new int[]{1,1,1,1,1,1};
		sorter.sort(arr);
		check(arr);
		arr = new int[]{5,3};
		sorter.sort(arr);
		check(arr);
		System.out.println("good");
	}
}