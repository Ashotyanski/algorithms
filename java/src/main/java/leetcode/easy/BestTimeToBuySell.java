package leetcode.easy;

import java.util.*;
import java.lang.*;

class BestTimeToBuySell {
	public static void main(String[] args) {
		System.out.println(new BestTimeToBuySell().maxProfit(new int[]{
			7,1,5,3,6,4
		}));
	}

	/**
	Did this one to prepare to "Best time to buy-sell III", but still can't figure out how to do it
	*/
	int maxProfit(int[] prices) {
		int plen = prices.length;
		int[] profits = new int[plen];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < plen; i++) {
			if (prices[i] <= min) {
				min = prices[i];
				if (i > 0) {
					profits[i] = profits[i - 1];
				}
			} else {
				profits[i] = Math.max(profits[i - 1], prices[i] - min);
			}
		}
		return profits[plen - 1];
	}
}