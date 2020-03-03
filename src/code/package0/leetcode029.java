package code.package0;

/**
 * 029 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 */
public class leetcode029 {
    public static void main(String[] args) {
        int m = -2147483648;
        int n = 2;
        System.out.println(new leetcode029().divide(m, n));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        long m = dividend > 0 ? dividend : -((long)dividend);
        long n = divisor > 0 ? divisor : -((long)divisor);
        int count = (int) findCount(m, n);
        return flag ? count : -count;
    }

    private long findCount(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long t = b;
        while (t + t <= a ) {
            count = count + count;
            t = t + t;
        }
        return count + findCount(a - t, b);
    }
}
