package leetcode.medium;

import java.util.*;
import java.lang.*;

class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public static void main(String[] args) {
		System.out.println(new _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown().maxProfit(new int[] {
			// 1,2,3,0,2
			6,1,6,4,3,0,2
		}));
	}

	/*
	Yet another task to prepare to Best time to buysell III
	*/	
    public int maxProfit(int[] prices) {
    	int plen = prices.length;
    	int[] dp = new int[plen];

    	int max = 0;
    	for (int i = 1; i < plen; i++) {
    		dp[i] = dp[i - 1];
    		for (int j = i - 1; j >= 0; j--) {
    			if (j - 2 >= 0) {
    				dp[i] = Math.max(dp[i], prices[i] - prices[j] + dp[j - 2]);
    			} else {
    				dp[i] = Math.max(dp[i], prices[i] - prices[j]);
    			}
    		}
    		max = Math.max(max, dp[i]);
    	}
    	System.out.println(Arrays.toString(dp));
    	return max;
    }
}