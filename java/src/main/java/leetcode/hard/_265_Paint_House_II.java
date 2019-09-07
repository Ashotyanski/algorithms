package leetcode.hard;

import java.util.*;
import java.lang.*;

class _265_Paint_House_II {
    public static void main(String[] args) {
        int res = new  _265_Paint_House_II().minCostII(new int[][]{
            {5},
        });
        System.out.println(res);
    }

    public int minCostII(int[][] costs) {
        int k = costs[0].length;
        int n = costs.length;

        int[][] d = new int[n + 1][k];
        for (int i = 0; i < k; i++) {
            d[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < k; j++) {
                // okay, this loop may be optimized
                // we need the lowest previous cost with different colors
                // instead of finding it in a loop, lets store the two previous lowest scores
                int minz = d[i - 1][(j + 1) % k];
                for (int z = 0; z < k; z++) {
                    if (z != j && d[i - 1][z] < minz) {
                        minz = d[i - 1][z];
                    }
                }
                d[i][j] = minz + costs[i - 1][j];
            }
        }

        int res = d[n][0];
        for (int z = 0; z < k; z++) {
            if (d[n][z] < res) {
                res = d[n][z];
            }
        }

        return res;
    }
}