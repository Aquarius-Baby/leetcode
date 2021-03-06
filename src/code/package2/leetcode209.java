package code.package2;

/**
 * 209 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
