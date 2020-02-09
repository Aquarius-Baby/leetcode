package code.package2;

/**
 * 221 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class leetcode221 {

    /**
     *
     * 矩阵中的每一个点作为正方形右下角端点所能构成最大正方形的边长，
     *      亦或是该点 左方、上方、左上方相邻端点所能构成最大正方形边长的最小值加1（该点为"1"），亦或为0（该点为0）
     * 动态转移方程：
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1 (该点为"1")
     * dp[i][j] = 0 (该点为"0")
     *
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i * j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        min = Math.min(min, dp[i - 1][j - 1]);
                        dp[i][j] = min + 1;
                    }
                    maxLength = maxLength > dp[i][j] ? maxLength : dp[i][j];
                }
            }
        }
        return maxLength * maxLength;
    }
}
