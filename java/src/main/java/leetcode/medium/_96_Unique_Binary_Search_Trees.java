package leetcode.medium;

import java.lang.*;
import java.util.*;

class _96_Unique_Binary_Search_Trees {
	public static void main(String[] args) {
		System.out.println(new _96_Unique_Binary_Search_Trees().numTrees(1));
	}

    public int numTrees(int n) {
    	int[] dp = new int[n + 1];
    	if (n == 0 || n == 1) {
    		return 1;
    	}
    	dp[0] = 1;
    	dp[1] = 1;
    	dp[2] = 2;
    	for (int i = 2; i <= n; i++) {
    		int res = 0;
    		for (int j = 1; j <= i; j++) {
    			res += dp[j - 1] * dp[i - j];
    		}
    		dp[i] = res;
    	}
    	return dp[n];
    }

    public int numTreesRec(int n) {
        int[] mem = new int[n + 1];
        mem[0] = 1;
        if (n == 0) {
        	return 1;
        }
        mem[1] = 1;
        if (n == 1) {
        	return 1; 
        }
        mem[2] = 2;
        return numTreesRec(n, mem);
    }

	public int numTreesRec(int n, int[] mem) {
		if (mem[n] > 0) {
			return mem[n];
		}
        int res = 0;
        for (int i = 1; i <= n; i++) {
        	int left = i - 1;
        	int right = n - i;
        	res += numTreesRec(left, mem) * numTreesRec(right, mem);
        }
        mem[n] = res;
        return res;
    }
}