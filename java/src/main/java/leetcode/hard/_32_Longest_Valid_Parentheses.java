package leetcode.hard;

import java.util.*;
import java.lang.*;

class _32_Longest_Valid_Parentheses {
	public static void main(String[] args) {
		int res = new _32_Longest_Valid_Parentheses().longestValidParentheses("(())(())");
		System.out.println(res);
	}

	// okay so the stack idea is hanging pretty low here, but i actually almost bruteforced the correct solution locally 
	// (although got AC after the very first submission)
	// which basically means that i dont understand the solution properly, gotta revise it later (lets see when)
    public int longestValidParentheses(String s) {
    	Stack<Integer> pos = new Stack<>();
    	Stack<Integer> counts = new Stack<>();

    	int max = 0;
    	int slen = s.length();
        if (slen == 0) {
            return max;
        }
    	for (int i = 0; i < slen; i++) {
    		char c = s.charAt(i);
    		if (c == '(') {
    			if (pos.isEmpty()) {
	    			pos.push(i);
	    			counts.push(0);				
    			}
    			max = Math.max(max, counts.peek());
    			pos.push(i);
    			counts.push(0);
    		} else {
    			if (pos.isEmpty()) {
    				//
    			} else if (pos.size() == 1) {
    				int pair = pos.pop();
    				int newCount = counts.pop();
    				max = Math.max(max, newCount);
    			} else {
    				pos.pop();
    				int newCount = counts.pop() + counts.pop() + 2;
    				counts.push(newCount);
    				max = Math.max(max, newCount);
    			}
    		}
    	}
    	if (pos.size() == 1) {
			int newCount = counts.pop();
			max = Math.max(max, newCount);
    	}
    	return max;
    }
}