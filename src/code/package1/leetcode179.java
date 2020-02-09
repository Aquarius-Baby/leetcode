package code.package1;

import java.util.Arrays;

/**
 * 179 最大数
 * <p>
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class leetcode179 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new leetcode179().largestNumber(nums));
    }

    /**
     *
     * 解法1：
     *
     * 关键是数组的排序
     * 假设（不是一般性），某一对整数 a 和 b ，
     * 我们的比较结果是 a 应该在 b 前面，这意味着 a b > b a，
     * 如果排序结果是错的，说明存在一个 c， b 在 c 前面且 c 在 a 的前面。 b c a
     * 这产生了矛盾，因为 a b > b a 和 b c > c b 意味着 a c > c a。
     * 换言之，我们的自定义比较方法保证了传递性，所以这样子排序是对的。
     *
     */
    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        if (asStrs[0].equals("0")) {
            return "0";
        }
        // String.join() 效率偏低  51% --> 96%
//        return String.join("",asStrs);
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }
        return largestNumberStr.toString();
    }

}
