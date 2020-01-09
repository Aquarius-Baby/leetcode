package code;

/**
 * 695 岛屿的最大面积
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area = dfs(i, j, m, n, grid, 0);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j, int m, int n, int[][] grid, int area) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return area;
        }
        area++;
        grid[i][j] = 0;
        area = dfs(i + 1, j, m, n, grid, area);
        area = dfs(i, j + 1, m, n, grid, area);
        area = dfs(i - 1, j, m, n, grid, area);
        area = dfs(i, j - 1, m, n, grid, area);
        return area;
    }
}
