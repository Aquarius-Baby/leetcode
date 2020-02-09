package code.package0;

/**
 * 062 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class leetcode062 {
    static int res;

    public static void main(String[] args) {
        new leetcode062().uniquePaths(23, 12);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        // n 行 m列
        boolean[][] visit = new boolean[n][m];
        res = 0;
        back(0, 0, n, m, visit);
        return res;
    }

    public void back(int row, int col, int n, int m, boolean[][] visited) {
        if (row >= n || col >= m || visited[row][col] == true) {
            return;
        }
        if (row == n - 1 && col == m - 1) {
            res = res + 1;
            return;
        }
        visited[row][col] = true;
        back(row, col + 1, n, m, visited);
        back(row + 1, col, n, m, visited);
        visited[row][col] = false;
    }
}
