package leetcode.hard;

import java.util.*;
import java.lang.*;

public class _97_Interleaving_String {
	public static void main(String[] args) {
		System.out.println(new _97_Interleaving_String().isInterleave(
			// "aabcc", "dbbca", "aadbbbaccc"
			// "a", "", "a"
			"aaaa", "", "aaaa"
			)
		);
	}

	/**
	Yay 360 noscope ac
	*/
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (s3.length() != m + n) {
			return false;
		}

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				// check upper path
				if (i > 0 && dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					dp[i][j] = true;
				} 

				// check left path
				if (j > 0 && dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
    }
}