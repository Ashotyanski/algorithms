package leetcode.medium;

import java.util.*;
import java.lang.*;

class _207_Course_Schedule {
	public static void main(String[] args) {
		boolean res = new _207_Course_Schedule().canFinish(
			2, new int[][]{
				{1,0},{0,1}
			}
			// 3, new int[][]{
				// {0,1},{0, 2},{2, 1}
			// }
		);
		System.out.println(res);
	}

	// spent nearly two hours trying to solve with union-find 
	// finally gave up and solved with dfs in like 10 minutes
	// now i see that it is actually possible to solve this with union-find-by-rank
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer, List<Integer>> g = new HashMap<>();

    	for (int i = 0; i < prerequisites.length; i++) {
    		if (g.get(prerequisites[i][0]) == null) {
    			g.put(prerequisites[i][0], new ArrayList<>());
    		}
    		g.get(prerequisites[i][0]).add(prerequisites[i][1]);
    	}

    	int[] mask = new int[numCourses];
    	for (int i = 0; i < numCourses; i++) {
    		if (!dfs(g, mask, i)) {
    			return false;
    		}
    	}
    	return true;
    }

    boolean dfs(Map<Integer, List<Integer>> g, int[] mask, int curr) {
    	if (mask[curr] == -1) { // black
    		return true;
    	} else if (mask[curr] == 1) { // grey
    		return false;
    	} else { // white
    		if (g.get(curr) != null) {
	    		mask[curr] = 1;
	    		for (int i : g.get(curr)) {
		    		if (!dfs(g, mask, i)) {
		    			return false;
		    		}
	    		}
    		}
    		mask[curr] = -1;
	    	return true;
    	}
    }
}