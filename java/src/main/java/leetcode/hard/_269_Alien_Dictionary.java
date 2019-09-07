package leetcode.hard;

import java.lang.*;
import java.util.*;

class _269_Alien_Dictionary {
    public static void main(String[] args) {
        String res = new _269_Alien_Dictionary().alienOrder(new String[]{
            // "wrt","wrf","er","ett","rftt"
            // "z", "x", "z"
            // "ca", "ccb", "ccc"
            // "ca", "cb"
            "ca", "cbdd"
        });    
        System.out.println(res);
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> lessThan = new HashMap<>();
        int wlen = words.length;

        Set<Character> charset = new HashSet<>();
        for (int i = 0; i < wlen - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int w1len = w1.length();
            int w2len = w2.length();
            for (int j = 0; j < w1len && j < w2len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                charset.add(c1);
                charset.add(c2);
                if (lessThan.get(c1) == null) {
                    lessThan.put(c1, new HashSet<>());
                }
                if (lessThan.get(c2) == null) {
                    lessThan.put(c2, new HashSet<>());
                }
                if (c1 != c2) {
                    // if (lessThan.get(c2).contains(c1)) {
                        // return "";
                    // }
                    lessThan.get(c1).add(c2);

                    break;
                }
            }

            if (w1len != w2len) {
                int b = w1len < w2len ? w1len : w2len;
                int e = w1len > w2len ? w1len : w2len;
                String w = w1len > w2len ? w1 : w2;
                for (int j = b; j < e; j++) {
                    char c1 = w.charAt(j);
                    charset.add(c1);
                    if (lessThan.get(c1) == null) {
                        lessThan.put(c1, new HashSet<>());
                    }
                }
            }
        }

        // kahn algorithm for topsort
        for (Set<Character> s : lessThan.values()) {
            for (Character c : s) {
                charset.remove(c);
            }
        }
        //System.out.println(lessThan);
        //System.out.println(charset);
        Map<Character, Integer> biggerCount = new HashMap<>();
        for (Set<Character> s : lessThan.values()) {
            for (Character c : s) {
                if (biggerCount.get(c) == null) {
                    biggerCount.put(c, 1);
                } else {
                    biggerCount.put(c, biggerCount.get(c) + 1);
                }
            }
        }

        PriorityQueue<Character> q = new PriorityQueue(charset);
        StringBuilder sb = new StringBuilder("");
        while (q.peek() != null) {
            Character n = q.poll();
            sb.append(n);
            for (Character m : lessThan.get(n)) {
                if (biggerCount.get(m) == 1) {
                    q.add(m);
                }
                biggerCount.put(m, biggerCount.get(m) - 1);
            }
        }
        for (int i : biggerCount.values()) {
            if (i > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}






























