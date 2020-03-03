package code.package0;


/**
 * 052 N皇后的解
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class leetcode052 {

    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] columnVal = new int[n];
        count = 0 ;
        DFS_helper(n, 0, columnVal);
        return count;
    }

    public void DFS_helper(int nQueens, int row, int[] columnVal) {
        if (row == nQueens) {
            count = count + 1;
        } else {
            for (int i = 0; i < nQueens; i++) {
                // row 行将Q放在位置 i
                columnVal[row] = i;
                if (isValid(row, columnVal))
                    DFS_helper(nQueens, row + 1, columnVal);
            }
        }
    }

    public boolean isValid(int row, int[] columnVal) {
        // 对row之前的每一行进行判断
        for (int i = 0; i < row; i++) {
            //判断是否放在同一列上 ： columnVal[row] == columnVal[i]
            // 是否在对角线上，如果是，行、列的差值 的绝对值相等 ：Math.abs(columnVal[row] - columnVal[i]) == row - i
            if (columnVal[row] == columnVal[i]
                    || Math.abs(columnVal[row] - columnVal[i]) == row - i)
                return false;
        }
        return true;
    }
}
