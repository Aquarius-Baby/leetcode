package code;

/**
 * 1277 统计全为 1 的正方形子矩阵
 * <p>
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 */
public class leetcode1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] dp = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i * j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        min = Math.min(min, dp[i - 1][j - 1]);
                        dp[i][j] = min + 1;
                    }
                    sum = sum + dp[i][j];
                }
            }
        }
        return sum;
    }
}
