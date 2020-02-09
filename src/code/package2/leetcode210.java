package code.package2;

import java.util.*;

/**
 * 210 课程表 II
 */
public class leetcode210 {
    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1},{3,2}};
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] res = new leetcode210().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 解法1：在207的解法1上进行改进，ac，但是效率不高 ，> 17%
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        int[] res = new int[numCourses];
        int size = numCourses;

        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            res[size - numCourses] = pre;
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) continue;
                if (--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        if (numCourses == 0) {
            return res;
        }
        return new int[0];
    }

    /**
     * 解法2：在207的解法2上进行改进，ac，
     */
    public int[] findOrder2(int n, int[][] pre) {
        List<Integer>[] g = new List[n];
        // g[i] 存储第i门课的后续课程
        for (int[] edge : pre) {
            int from = edge[1];
            List<Integer> neighs = g[from];
            if (neighs == null) {
                neighs = new ArrayList<>();
            }
            // 添加后续课程
            neighs.add(edge[0]);
            g[from] = neighs;
        }

        ArrayDeque<Integer> r = new ArrayDeque<>();
        int[] flags = new int[n];
        for (int i = 0; i < n; i++) {
            // 如果存在环
            if (dfs(g, r, flags, i)) {
                return new int[0];
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = r.pollFirst();
        }
        return res;
    }

    boolean dfs(List<Integer>[] g, ArrayDeque<Integer> r, int[] flags, int node) {
        if (flags[node] == 1) return true;
        if (flags[node] == -1) return false;
        flags[node] = 1;
        List<Integer> neigh = g[node];
        if (neigh != null) {
            for (int to : neigh) {
                if (dfs(g, r, flags, to)) return true;
            }
        }
        flags[node] = -1;
        // 当前课程为前置课程，放入队首
        r.addFirst(node);
        return false;
    }
}
