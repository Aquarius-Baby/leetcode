package code.package0;

/**
 * 050 pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class leetcode050 {
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(new leetcode050().myPow(x, n));
    }

    /**
     * 解法1：
     *
     * n情况分析
     *   (1)n == 0 res = 1
     *   (2)n < 0 如果 n = MIN_VALUE , res =  1 / ( x *  pow(x, MAX_VALUE) )
     *   (3)n > 0 ， res = 1
     *          1）n 为奇数 ，先使用掉一个x，res = res * x，使 n 为偶数，继续 2）
     *          2）n 为偶数 ，x = x * x， n = n / 2
     *   res 就是答案
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1.0 / myPow(x, -n);
            }
        }
        double ans = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans ;
    }
}
