package code.package0;

import java.util.Arrays;
import java.util.Map;

/**
 * 016 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class leetcode016 {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length < 3 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);// 从小到大排序
        int result = 0;
        int minError = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < minError) {
                    minError = Math.abs(target - sum);
                    result = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
}
