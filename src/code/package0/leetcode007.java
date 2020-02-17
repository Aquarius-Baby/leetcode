package code.package0;

/**
 * 007 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 */
public class leetcode007 {
    /**
     *解法1：
     *
     */
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > max / 10 || (ans == max / 10 && pop > max - ans * 10 ))
                return 0;
            if (ans < min / 10 || (ans == min / 10 && pop < min - ans * 10 ))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
