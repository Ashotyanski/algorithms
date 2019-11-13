package leetcode.easy;

import java.lang.*;
import java.util.*;

class  _566_Reshape_the_Matrix{
    public int[][] matrixReshape(int[][] nums, int r, int c) {
	    int M = nums.length;
	    if (M == 0) {
		    return null;
	    }
	    int N = nums[0].length;
	    if (r * c != M * N) {
		    return nums;
	    }
	    int[][] res = new int[r][c];
	    for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
			    int cumul = i * N + j;
			    int _i = cumul / c;
			    int _j = cumul % c;
			    res[_i][_j] = nums[i][j];
		    }
	    } 
	    return res;
    }

    public static void main(String[] args) {
	    print(new _566_Reshape_the_Matrix().matrixReshape(new int[][] {
		    
		  {1,2},{3,4},{5,6}
	    }, 2, 3));
    }
	public static void print(int [][] mat) {
		if (mat == null) {
			System.out.println("Null");
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(" " + mat[i][j]);
			}
			System.out.println();
		}
	}

}
