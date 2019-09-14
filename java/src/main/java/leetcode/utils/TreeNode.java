package leetcode.util;

import java.util.*;
import java.lang.*;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;

	public TreeNode(int val) {
		this.val = val;
	}

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(val);
        buffer.append('\n');

        List<TreeNode> children = new ArrayList<>();
        if (this.left != null) {
        	children.add(this.left);
        }
        if (this.right != null) {
        	children.add(this.right);
        }

        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}