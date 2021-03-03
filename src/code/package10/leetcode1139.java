package code.package10;

/**
 * 1139 最大的以 1 为边界的正方形
 */
public class leetcode1139 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int res = largest1BorderedSquare(grid);
        System.out.println(res);
    }

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int[][][] dp = new int[m][n][2];
        if (grid[0][0] == 1) {
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
        } else {
            dp[0][0][0] = 0;
            dp[0][0][1] = 0;
        }
        // 0 左侧有多少个1 ； 1 上方有多少个1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                        dp[i][j][1] = 1;
                    } else if (j == 0) {
                        dp[i][j][0] = 1;
                        dp[i][j][1] = dp[i - 1][j][1] + 1;

                    } else {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                    }
                } else {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }
            }
        }

        int maxLength = Math.min(n, m);
        for (int length = maxLength; length > 0; length--) {
            for (int i = length - 1; i < m; i++) {
                for (int j = length - 1; j < n; j++) {
                    if (dp[i][j][0] >= length && dp[i][j][1] >= length
                            && dp[i - length + 1][j][0] >= length
                            && dp[i][j - length + 1][1] >= length) {
                        return length * length;
                    }
                }
            }
        }
        return 0;
    }
}
