package leetcode.hard;

import java.util.*;
import java.lang.*;

class _140_Word_Break_II {
    public static void main(String[] args) {
        List<String> res = new _140_Word_Break_II().wordBreak(
            // "catsanddog", Arrays.asList(new String[]{
            // "cat", "cats", "and", "sand", "dog"
            // "pineapplepenapple", Arrays.asList(new String[]{
            // "apple", "pen", "applepen", "pine", "pineapple"
            "catsandog", Arrays.asList(new String[]{
            "cats", "dog", "sand", "and", "cat"
            // "aaaaaaa", Arrays.asList(new String[]{
            // "aaaa","aa","a"
        }));

        System.out.println(res);
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        int val;

        TrieNode (int val) {
            this.children = new HashMap<>();
            this.val = val;
        }
    }

    // so what we do here is convert worDict to a trie
    // after that just iterate over original word and try to find occurrences in the trie
    // the problem here is that without memoization this shit receives a timeout
    // 
    // also while memoization is pretty straightforward, trie can be replaced with an ordinary dp (actually most submissions do this way)
    // but i am too dumb to elaborate on time complexities - dp seems to be O(s.len * wordDict.len * max(wordDict[i].len))
    // while trie is O(s.len * ???) (if you somehow read this and know the answer, go ahead and open an issue)
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode(-1);

        for (int k = 0; k < wordDict.size(); k++) {
            String w = wordDict.get(k);
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i++) {
                if (!curr.children.containsKey(w.charAt(i))) {
                    curr.children.put(w.charAt(i), new TrieNode(-1));
                }
                curr = curr.children.get(w.charAt(i));
            }
            curr.val = k;
        }

        Set<Integer>[] dp = new Set[s.length() + 1];
        dp[0] = new HashSet<>();
        List<String> res = new ArrayList<>();
        dfs(s, 0, root, root, wordDict, dp);

        collect(dp, wordDict, s.length(), new LinkedList<>(), res);
        return res;
    }

    public void collect(Set<Integer>[] dp, List<String> wordDict, int i, LinkedList<String> curr, List<String> res) {
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = curr.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            return;
        }
        if (dp[i] == null) {
            return;
        }
        for (int wordIdx : dp[i]) {
            String word = wordDict.get(wordIdx);
            curr.addFirst(word);
            collect(dp, wordDict, i - word.length(), curr, res);
            curr.removeFirst();
        }
    }

    public void dfs(String s, int icurr, TrieNode trie, TrieNode root, List<String> dict, Set<Integer>[] dp) {
        if (icurr == s.length()) {
            return;
        }
        if (trie.children.containsKey(s.charAt(icurr))) {
            TrieNode nextNode = trie.children.get(s.charAt(icurr));
            if (nextNode.val > -1) {
                String w = dict.get(nextNode.val);
                if (dp[icurr + 1] == null) {
                    dp[icurr + 1] = new HashSet<>();
                    dfs(s, icurr + 1, root, root, dict, dp);
                }
                dp[icurr + 1].add(nextNode.val);
            }
            dfs(s, icurr + 1, nextNode, root, dict, dp);
        }
    }
}