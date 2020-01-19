package code;

import java.util.LinkedList;

/**
 * 207 课程表
 */
public class leetcode207 {

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {0, 1}, {1, 0}};
        System.out.println(new leetcode207().canFinish(numCourses, prerequisites));
    }

    /**
     * 解法1：入度表（广度优先遍历）
     * 1. 统计所有课程的前置课程数
     * 2. 将前置课程数为0的课程放入队列【无需前置学习，可以作为起点】
     * 3. （1）从队列中取出学习的课程 a，所需学习的课程数 -1
     * （2）将所有，将a设置为前置课程的b，前置课程数 - 1 ， if == 0 ，则b可以放入队列
     * 4. 重复 3 ，直到队列为空，不再有可以直接学习课程
     * 5. 判断最后的课程数， == 0 ，则学习完毕
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int size = prerequisites.length;
        if (size < 2) {
            return true;
        }
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
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) continue;
                if (--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }

    /**
     * 解法2：深度遍历
     *
     *
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        // 记录每一门课程的状态
        int[] flags = new int[numCourses];
        // 获得有向的链接表
        for (int[] cp : prerequisites) {
            adjacency[cp[1]][cp[0]] = 1;
        }
        // 对每一个点[课程]进行深度遍历
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    // 深度遍历，是否存在环
    // flags ： 0 未被访问； -1 之前遍历中已被访问； 1 本次遍历被访问
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        // 本门课程的深度遍历开始
        for (int j = 0; j < adjacency.length; j++) {
            // adjacency[i][j] == 1 课程之间存在条件
            // 对 课程 j 进行深度遍历
            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }


}
