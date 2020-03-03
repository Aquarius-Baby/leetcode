package code.package3;

/**
 * 329 矩阵中的最长递增路径
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 */
public class leetcode329 {

    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        int[][] nums = {{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        int res = new leetcode329().longestIncreasingPath(nums);
        System.out.println(res);
    }

    /**
     * 解法1：
     * cache[i][j]，记录的是matrix[i][j]作为起点，最长的递增路径长度。
     * 依次向左，右，上，下，位置为[row][col]进行判断，
     * 如果matrix[i][j] < matrix[row][col],
     * (1) cache[row][col] != 0 表示该处已经进行过判断
     * 则，tempMax = Math.max(tempMax,cache[row][col])
     * (2) cache[row][col] == 0 则需要先对该处进行递归，返回最长路径。
     * 4个方向都经过判断后，cache[i][j] = tempMax + 1;
     */
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row < 1) return 0;
        int col = matrix[0].length;
        int ans = 0;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, cache));
            }
        }
        return ans;
    }

    private int dfs(int x, int y, int[][] mat, int[][] cache) {
        if (cache[x][y] != 0) return cache[x][y];
        int tempMax = 0;
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && mat[x][y] < mat[i][j]) {
                tempMax = Math.max(tempMax, dfs(i, j, mat, cache));
            }
        }
        return cache[x][y] = tempMax + 1;
    }
}
