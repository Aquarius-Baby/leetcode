package code;

/**
 * 069 x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class leetcode069 {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (long) (low + high) / 2;
            if (mid * mid < x)
                low = (int) mid + 1;
            else if (mid * mid > x)
                high = (int) mid - 1;
            else
                return (int) mid;
        }
        //出循环时，high < low ，题目要求舍弃小数点后的位数，所以向下取整，返回此时较小的high
        return high;
    }
}
