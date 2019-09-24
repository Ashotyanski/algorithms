package leetcode.medium;

import java.lang.*;
import java.util.*;

class _221_Maximal_Square {
    public static void main(String[] args) {
        int res = new _221_Maximal_Square().maximalSquare(new char[][] {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},

            // {'1','0','1','0','0','1','1','1','0'},
            // {'1','1','1','0','0','0','0','0','1'},
            // {'0','0','1','1','0','0','0','1','1'},
            // {'0','1','1','0','0','1','0','0','1'},
            // {'1','1','0','1','1','0','0','1','0'},
            // {'0','1','1','1','1','1','1','0','1'},
            // {'1','0','1','1','1','0','0','1','0'},
            // {'1','1','1','0','1','0','0','0','1'},
            // {'0','1','1','1','1','0','0','1','0'},
            // {'1','0','0','1','1','1','0','0','0'}

        });
        System.out.println(res);
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int up = dp[i][j - 1];
                    int left = dp[i - 1][j];
                    int min = Math.min(up, left);
                    int max = Math.max(up, left);
                    dp[i][j] = Math.min(min, dp[i- 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}