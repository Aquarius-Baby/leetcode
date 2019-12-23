package code;

/**
 * 221 最大正方形
 */
public class leetcode211 {

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
