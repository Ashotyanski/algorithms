package leetcode.medium;

import java.util.*;
import java.lang.*;

class _343_Integer_Break {
	public static void main(String[] args) {
		System.out.println(new _343_Integer_Break().integerBreak(58));
	}

    public int integerBreak(int n) {
    	int[] dp = new int[n + 1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= i; j++) {
    			if (i == j && n < 4) {
    				continue;
    			}
				dp[i] = Math.max(dp[i], dp[i - j] * j);
    		}
    	}
    	return dp[n];
    }

    public int integerBreakRec(int n) {
    	int[] memo = new int[n + 1];
    	memo[0] = 1;
    	memo[1] = 1;
    	memo[2] = 1;
        return integerBreakRec(n, memo);
    }

    public int integerBreakRec(int n, int[] memo) {
    	if (memo[n] > 0) {
    		return memo[n];
    	}
    	int res = 1;
    	for (int i = 1; i <= n; i++) {
    		res = Math.max(res, i * integerBreakRec(n - i, memo));
    	}
		memo[n] = res;
    	return res;
    }
}