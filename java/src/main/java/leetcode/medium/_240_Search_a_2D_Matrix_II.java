package leetcode.medium;

import java.lang.*;
import java.util.*;

class _240_Search_a_2D_Matrix_II {
	public static void main(String[] args) {
		System.out.println(new _240_Search_a_2D_Matrix_II().searchMatrix(new int[][] {
			{1,2,3},
			{5,7,9},
			{10,12,15}
		}, 10));

	}

	    public boolean searchMatrix(int[][] matrix, int k) {
		    int M = matrix.length;
		    if (M == 0) {
			    return false;
		    }
		    int N = matrix[0].length;

		    int i = 0;
		    int j = N - 1;
		    while (i <= M - 1 && j >= 0) {
			    if (matrix[i][j] < k) {
				    i++;
			    } else if(matrix[i][j] > k) {
				    j--;
			    } else {
				    return true;
			    }
		    }
		    return false;
		
	    }

}
