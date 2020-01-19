package code;

import java.util.Arrays;

/**
 * 334 递增的三元子序列
 * <p>
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class leetcode334 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 5, 5, 2, 5, 4};
        System.out.println(increasingTriplet(nums));
    }

    /**
     * 解法1：记录nums[i]之前最小的数 one ，第二小的数 two，one < two。
     *       判断nums[i]
     *          (1) nums[i] > two ====》 return true
     *          (2) nums[i] > one ====》 two = nums[i]
     *          (3) nums[i] < one ====>  one= nums[i]
     */
    public static boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > two) {
                return true;
            } else if (num > one) {
                two = num;
            } else {
                one = num;
            }
        }
        return false;
    }

    /**
     * 解法2：
     * 利用上升子序列的解法，如果存在3个连续上升，即可返回true
     * @param nums
     * @return
     */

    public static boolean increasingTriplet2(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == 3) return true;
                }
            }
        }
        return false;
    }
}
