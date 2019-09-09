package leetcode.hard;

import java.util.*;
import java.lang.*;

class _76_Minimum_Window_Substring {
	public static void main(String[] args) {
		String res = new _76_Minimum_Window_Substring().minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);
	}

    public String minWindow(String s, String t) {
    	int tlen = t.length();
    	int slen = s.length();
    	if (tlen == 0 || slen == 0) {
    		return "";
    	}

    	Map<Character, Integer> map = new HashMap<>();
    	for (int i = 0; i < tlen; i++) {
    		if (map.get(t.charAt(i)) == null) {
    			map.put(t.charAt(i), 1);
    		} else {
    			map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
    		}
    	}
    	int count = 0;
    	int l = 0, r = 0;
    	int min = slen + 1;
    	String res = "";
    	while (l < slen) {
    		if (count < tlen) { // curr window doesnt contain all characters, so try to add one from the right
    			if (r == slen) {
    				break;
    			}
    			char newc = s.charAt(r);
    			if (map.containsKey(newc)) {
    				int cstate = map.get(newc);
    				if (cstate > 0) {
    					count++;
    				}
    				map.put(newc, cstate - 1);
    			}
    			r++;
    		} else { // curr window contains characters, lets shrink it from left
    			if (r - l < min) {
    				min = Math.min(min, r - l);
    				res = s.substring(l, r);
    			}
    			char exitc = s.charAt(l);
    			if (map.containsKey(exitc)) {
    				int cstate = map.get(exitc);
    				if (cstate == 0) {
    					count--;
    				}
    				map.put(exitc, cstate + 1);
    			}
    			l++;
    		}
    	}
    	return res;
    }
}