package leetcode.medium;

import java.lang.*;
import java.util.*;

public class _498_Diagonal_Traverse {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new _498_Diagonal_Traverse().diagonalsOrder(new int[][]{
			{1,2,3},
			{4,5,6},
			//{7,8,9}
		})));
	}

	int[] diagonalsOrder(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		int res[] = new int[M * N];

		int x = 0;
		int y = 0;
		boolean up = true;
		int i = 0;
		while (y < M && x < N) {
			if (up) {
				res[i++] = matrix[y][x];
				if (x == N - 1) {
					up = !up;
					y++;
				} else if (y == 0) {
					up = !up;
					x++;
				} else {
					x++;
					y--;
				}
			} else {
				res[i++] = matrix[y][x];
				if (y == M - 1) {
					up = !up;
					x++;
				} else if (x == 0) {
					up = !up;
					y++;
				} else {
					x--;
					y++;
				}
			}
		}
		return res;
	}
}
