package leetcode.hard;

import java.lang.*;
import java.util.*;

class _315_Count_of_Smaller_Numbers_After_Self {
    public static void main(String[] args) {
        List<Integer> res = new _315_Count_of_Smaller_Numbers_After_Self().countSmaller(new int[]{
            10, 2, 0, 1
        });
        System.out.println(res);
    }

    static class TreeNode {
        TreeNode left, right;
        int val, count = 1;

        TreeNode(int val) {
            this.val = val;
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(50);
            print(buffer, "", "");
            return buffer.toString();
        }


        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(val).append("(").append(count).append(")");

            buffer.append('\n');

            List<TreeNode> children = new ArrayList<>();
            if (this.right != null) {
                right.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");    
            } else {
                buffer.append(childrenPrefix + "├── ");
                buffer.append("null\n");

            }
            if (this.left != null) {
                left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            } else {
                buffer.append(childrenPrefix + "└── ");
                buffer.append("null\n");
            }
        }
    }

    // the idea here is to run backwards and use bst to find what we need
    // one should remember about repetetive elements
    // 
    // this one is also unbalanced variant - balancing the tree may improve perf
    public List<Integer> countSmaller(int[] nums) {
        int nlen = nums.length;
        LinkedList<Integer> res = new LinkedList<>();   
        if (nlen == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[nlen - 1]);
        res.addFirst(0);
        for (int i = nlen - 2; i >= 0; i--) {
            res.addFirst(insert(root, nums[i]));
        }
        // System.out.println(root);
        return res;
    }

    int insert(TreeNode node, int n) {
        if (node.val == n) {
            node.count++;
            return node.left == null ? 0 : node.left.count;
        } else if (node.val < n) {
            node.count++;
            int left = node.left == null ? 0 : node.left.count;
            if (node.right == null) {
                node.right = new TreeNode(n);
                return node.count - 1;
            } else {
                return insert(node.right, n) + (node.count - node.right.count);
            }
        } else {
            node.count++;
            if (node.left == null) {
                node.left = new TreeNode(n);
                return 0;
            } else {
                return insert(node.left, n);
            }            
        }
    }
}
