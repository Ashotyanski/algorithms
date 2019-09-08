package leetcode.hard;

import java.util.*;
import java.lang.*;

class _329_Longest_Increasing_Path_in_a_Matrix {
    public static void main(String[] args) {
        int res = new _329_Longest_Increasing_Path_in_a_Matrix().longestIncreasingPath(new int[][]{
            // {9,9,4},
            // {6,6,8},
            // {2,1,1}
            // {9,9},
            // {6,6},
            // {0,1}
            {7,6,1,1},
            {2,7,6,0},
            {1,3,5,1},
            {6,6,3,2}
        });
        System.out.println(res);
    }

    // so we do dfs here, and memoize all computations, eventually we get O(nm)
    // 
    // but at the beginning i tried another idea - 
    // 1. go col-by-col
    // 2. dp down: m[i][j] = max(m[i - 1][j] + 1, m[i][j - 1] + 1)
    // 3. dp up: m[i][j] = max(m[i - 1][j] + 1, m[i][j + 1] + 1)
    // 
    // So apparently this doesn't work (for example if path is a spiral),
    // but something tells me that idea might be a solution to another question.......
    int dfs(int[][] matrix, int[][] d, int r, int c) {
        if (d[r][c] != 0) {
            return d[r][c];
        }
        int curr = matrix[r][c];

        int left = 1;
        if (r > 0 && matrix[r - 1][c] > curr) {
            left = dfs(matrix, d, r - 1, c) + 1;
        }
        int right = 1;
        if (r < matrix.length - 1 && matrix[r + 1][c] > curr) {
            right = dfs(matrix, d, r + 1, c) + 1;
        }
        int up = 1;
        if (c > 0 && matrix[r][c - 1] > curr) {
            up = dfs(matrix, d, r, c - 1) + 1;
        }
        int down = 1;
        if (c < matrix[0].length - 1 && matrix[r][c + 1] > curr) {
            down = dfs(matrix, d, r, c + 1) + 1;
        }
        int res = Math.max(Math.max(left, right), Math.max(up, down));
        d[r][c] = res;
        return res;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int d[][] = new int[n][m];
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dfs(matrix, d, i, j), max);
            }
        }
        return max;
    }
}