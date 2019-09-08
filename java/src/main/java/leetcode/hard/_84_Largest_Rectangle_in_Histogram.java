package leetcode.hard;

import java.util.*;
import java.lang.*;

class _84_Largest_Rectangle_in_Histogram {
	public static void main(String[] args) {
		int res = new _84_Largest_Rectangle_in_Histogram().largestRectangleArea(new int[]{
			// 2,1,5,6,2,3,2
			// 3,6,5,7,4,8,1,0
			// 5,5,7,4
			3,3,2,3
		});
		System.out.println(res);
	}

    public int largestRectangleArea(int[] heights) {
    	int hlen = heights.length;
    	if (hlen == 0) {
    		return 0;
    	}
    	int max = 0;
    	// submitted this code, but turned out only one stack may be used:
    	// if we have index, we can find corresponding height by looking up in height array (duh)
    	Stack<Integer> h = new Stack<>();
    	Stack<Integer> p = new Stack<>();
    	for (int i = 0; i < hlen; i++) {
    		int curr = heights[i];
    		int popped = 0;
    		while (!h.empty() && h.peek() > curr) {
    			int pos = p.pop();
    			int height = h.pop();
    			int s = (i - pos) * height;
    			popped = Math.max(popped, s / height);
    			max = Math.max(max, s);
    		}
    		if (h.empty() || h.peek() != curr) {
    			h.push(curr);
    			p.push(i - popped);
    		}
    	}
		while (!h.empty()) {
			int pos = p.pop();
			int height = h.pop();
			max = Math.max(max, (hlen - pos) * height);
		}
    	return max;
    }
}