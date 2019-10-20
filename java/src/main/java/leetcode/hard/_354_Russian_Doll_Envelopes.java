package leetcode.hard;

import java.util.*;
import java.lang.*;

class _354_Russian_Doll_Envelopes {
	public static void main(String[] args) {
		System.out.println(new _354_Russian_Doll_Envelopes().maxEnvelopes(new int[][] {
			// {5,4}, {6,4}, {6,7}, {2,3}
			{1,10}, {2,11}, {1,12}, {100,100}, {10,1}, {11, 2}, {12, 3}
		}));		
	}

    /**
    I've seen this one in CTCI, meh (this version is slightly easier)
    Don't know if I could solve this on a real interview
    */
    public int maxEnvelopes(int[][] envelopes) {
    	int elen = envelopes.length;
    	List<int[]> arr = new ArrayList<>();
    	for (int i = 0; i < elen; i++) {
    		arr.add(envelopes[i]);
    	}
    	arr.sort(new Comparator<int[]>() {
    		public int compare(int[] a, int[] b) {
    			if (a[0] == b[0]) {
    				return Integer.compare(a[1], b[1]);
    			}
    			return Integer.compare(a[0], b[0]);
    		}
    	});
    	int max = 0;
    	int[] dp = new int[elen];
    	for (int i = 0; i < elen; i++) {
    		dp[i] = 1;
    		for (int j = i - 1; j >= 0; j--) {
    			if (arr.get(j)[0] < arr.get(i)[0] && arr.get(j)[1] < arr.get(i)[1]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
    			}
    		}
    		max = Math.max(dp[i], max);
    	}
    	return max;
    }
}