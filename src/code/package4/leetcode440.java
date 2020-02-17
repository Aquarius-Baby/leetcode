package code.package4;

import java.util.ArrayList;
import java.util.List;

/**
 * 440 字典序的第K小数字
 * <p>
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * <p>
 * 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * n: 13   k: 2
 * <p>
 * 输出:
 * 10
 * <p>
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */
public class leetcode440 {
    public static void main(String[] args) {
        int n = 13;
        int res = new leetcode440().findKthNumber(n, 3);
        System.out.println(res);
    }

    /**
     * 解法1：
     * 前缀为prefix，假设为1
     * 1                                2  3  4 5 。。。。
     * 10     11     12    13    14？
     * 100?  110？  120？  130？  140
     */
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k = k - 1;
        while (k > 0) {
            int step = getSteps(n, cur, cur + 1);
            if (step <= k) {
                cur = cur + 1;
                k = k - step;
            } else {
                cur = cur * 10;
                k = k - 1;
            }
        }
        return cur;
    }

    private int getSteps(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n ) {
            step += Math.min(n + 1, n2) - n1;
            n1 = n1 * 10;
            n2 = n2 * 10;
        }
        return step;
    }
}
