package code.package0;

import java.util.ArrayList;
import java.util.List;

/**
 * 051 N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */
public class leetcode051 {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new leetcode051().solveNQueens2(n);
        for (List<String> t : res) {
            for (String s : t) {
                System.out.println(s);
            }
            System.out.println("===========");
        }
    }

    /**
     * 解法1：
     *
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] placed = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                placed[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        help(res, placed, 0, n);
        return res;
    }

    private void help(List<List<String>> res, char[][] placed, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<String>();
            for (char[] t : placed) {
                temp.add(new String(t));
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 这一列是否已经存在了
            boolean exitFlag = check(placed, row, i);
            if (!exitFlag) {
                placed[row][i] = 'Q';
                help(res, placed, row + 1, n);
                placed[row][i] = '.';
            }
        }
    }

    boolean check(char[][] placed, int row, int col) {
        boolean exitFlag = false;
        int n = placed.length;
        //  同列
        for (int j = 0; j < n; j++) {
            if (j != row && 'Q' == (placed[j][col])) {
                return true;
            }
        }
        // 对角线  left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ('Q' == (placed[i][j])) {
                return true;
            }
        }
        // 对角线  left
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if ('Q' == (placed[i][j])) {
                return true;
            }
        }
        // 对角线  right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ('Q' == (placed[i][j])) {
                return true;
            }
        }
        // 对角线  left
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if ('Q' == (placed[i][j])) {
                return true;
            }
        }
        return exitFlag;
    }


    /**
     * 解法2：一个数组存储每一行Q的位置
     *
     */
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0)
            return res;
        int[] columnVal = new int[n];
        DFS_helper(n, res, 0, columnVal);
        return res;
    }

    public void DFS_helper(int nQueens, List<List<String>> res, int row, int[] columnVal) {
        if (row == nQueens) {
            List<String> unit = new ArrayList<String>();
            for (int i = 0; i < nQueens; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < nQueens; j++) {
                    if (j == columnVal[i])
                        s.append("Q");
                    else
                        s.append(".");
                }
                unit.add(s.toString());
            }
            res.add(unit);
            return;
        }
        for (int i = 0; i < nQueens; i++) {
            // row 行将Q放置在位置i
            columnVal[row] = i;
            if (isValid(row, columnVal))
                DFS_helper(nQueens, res, row + 1, columnVal);
        }
    }

    public boolean isValid(int row, int[] columnVal) {
        for (int i = 0; i < row; i++) {
            if (columnVal[row] == columnVal[i]
                    || Math.abs(columnVal[row] - columnVal[i]) == row - i)
                return false;
        }
        return true;
    }

}
