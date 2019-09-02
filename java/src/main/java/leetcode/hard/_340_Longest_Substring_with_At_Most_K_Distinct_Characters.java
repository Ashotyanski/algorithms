package leetcode.hard;

import java.util.*;

class _340_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public static void main(String[] args) {
        int res = new _340_Longest_Substring_with_At_Most_K_Distinct_Characters().lengthOfLongestSubstringKDistinct("WORLD", 4);
        System.out.println(res);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int slen = s.length();
        int maxWindow = 0;
        int curWindow = 0;
        int curChars = 0;
        for (int i = 0; i < slen; i++) {
            char curChar = s.charAt(i);
            Integer countOfChar = map.get(curChar);
            if (countOfChar != null && countOfChar > 0) {
                map.put(curChar, countOfChar + 1);
                curWindow++;
            } else {
                while (curChars >= k) {
                    char toExit = s.charAt(i - curWindow);
                    map.put(toExit, map.get(toExit) - 1);
                    if (map.get(toExit) == 0) {
                        curChars--;
                    }
                    curWindow--;
                }
                map.put(curChar, 1);
                curWindow++;
                curChars++;
            }
            if (curWindow > maxWindow) {
                maxWindow = curWindow;
            }
        }
        return maxWindow;
    }
}