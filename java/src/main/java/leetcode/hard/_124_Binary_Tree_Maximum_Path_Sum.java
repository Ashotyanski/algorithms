package leetcode.hard;

import java.util.*;
import java.lang.*;
import leetcode.util.*;

class _124_Binary_Tree_Maximum_Path_Sum {
	public static void main(String[] args) {
		// TreeNode m = new TreeNode(1);
		// m.left = new TreeNode(2);
		// m.right = new TreeNode(3);

		TreeNode m = new TreeNode(-10);
		m.left = new TreeNode(-10);
		m.right = new TreeNode(-10);
		m.right.left = new TreeNode(-10);
		m.right.left.left = new TreeNode(-15);
		m.right.right = new TreeNode(10);
		m.right.right.right = new TreeNode(-7);


		int res = new _124_Binary_Tree_Maximum_Path_Sum().maxPathSum(m);
		System.out.println(res);
	}

    public int maxPathSum(TreeNode root) {
    	if (root == null) {
    		return 0;
    	} 
    	TreeNode dp = new TreeNode(0);
    	int maxRootPath = maxPathSumRec(root, dp);
    	System.out.println(root);
    	System.out.println(dp);
    	return Math.max(maxRootPath, maxNode(dp));
    }

    // boys use global vars, men plant another tree
    public int maxPathSumRec(TreeNode root, TreeNode dp) {
    	int res = root.val;
    	int left = 0;
    	if (root.left != null) {
    		dp.left = new TreeNode(Integer.MIN_VALUE);
        	left = maxPathSumRec(root.left, dp.left);
    	}
    	int right = 0;
    	if (root.right != null) {
    		dp.right = new TreeNode(Integer.MIN_VALUE);
			right = maxPathSumRec(root.right, dp.right);
	    }
	    dp.val = Math.max(res + left + right, Math.max(res, Math.max(res + left, res + right)));

	    return Math.max(res, Math.max(res + left, res + right));
    }

    public int maxNode(TreeNode root) {
    	if (root == null) {
    		return Integer.MIN_VALUE;
    	}
    	return Math.max(root.val, Math.max(maxNode(root.left), maxNode(root.right)));
    }
}