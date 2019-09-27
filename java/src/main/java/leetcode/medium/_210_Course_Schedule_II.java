package leetcode.medium;

import java.util.*;
import java.lang.*;

class _210_Course_Schedule_II {
	public static void main(String[] args) {
		int[] res = new _210_Course_Schedule_II().findOrder(
			2, new int[][]{{1,0}}
			// 4, new int[][]{
				// {1,0},{2,0},{3,1},{3,2} 
			// }
		);
		System.out.println(Arrays.toString(res));
	}

	public boolean dfs(int n, List<Integer>[] g, List<Integer> path, int[] visited, int cur) {
		if (visited[cur] == -1) {
			return true;
		}
		if (visited[cur] == 1) {
			return false;
		}
		visited[cur] = 1;
		if (g[cur] != null) {
			for (int adj : g[cur]) {
				if (!dfs(n, g, path, visited, adj)) {
					return false;
				}
			}
		}
		path.add(cur);
		visited[cur] = -1;
		return true;
	}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
			return new int[]{};
		}
    	List<Integer>[] g = new ArrayList[numCourses];
    	for (int[] p : prerequisites) {
    		if (g[p[0]] == null) {
    			g[p[0]] = new ArrayList();
    		}
    		g[p[0]].add(p[1]);
    	}

    	int[] visited = new int[numCourses];
    	List<Integer> res = new ArrayList<>();
    	for (int i = 0; i < numCourses; i++) {
    		if (!dfs(numCourses, g, res, visited, i)) {
    			return new int[]{};
    		}
    	}
    	int[] arr = new int[res.size()];
    	for (int i = 0; i < res.size(); i++) {
    		arr[i] = res.get(i);
    	}
    	return arr;
    }
}