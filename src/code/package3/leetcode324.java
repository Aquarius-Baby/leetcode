package code.package3;

import java.util.Arrays;

/**
 * 324 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * <p>
 * 能用 O(n) 时间复杂度和
 * 或原地 O(1) 额外空间来实现吗？
 */
public class leetcode324 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new leetcode324().wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        int length = nums.length;
        if (length == 1) return;
        Arrays.sort(nums);
        // 前一半的个数
        int mid = length / 2;
        if (length % 2 == 1) {
            mid++;
        }
        int[] min = Arrays.copyOf(nums, mid);
        int[] max = Arrays.copyOfRange(nums, mid, length);
        if (min[mid - 1] == max[0]) {
            int i = 0;
            int minIndex = mid - 1;
            int maxIndex = length - mid - 1;
            while (minIndex >= 0 && maxIndex >= 0) {
                nums[i++] = min[minIndex--];
                nums[i++] = max[maxIndex--];
            }
            while (minIndex >= 0) {
                nums[i++] = min[minIndex--];
            }
        } else {
            int i = 0;
            int minIndex = 0;
            int maxIndex = 0;
            while (minIndex < mid && maxIndex < length - mid) {
                nums[i++] = min[minIndex++];
                nums[i++] = max[maxIndex++];
            }
            while (minIndex < mid) {
                nums[i++] = min[minIndex++];
            }
        }
    }

    /**
     * 解法2：代码更简洁些
     */
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int[] temp = Arrays.copyOf(nums, nums.length);
        int k = (nums.length + 1) / 2 - 1;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = temp[k--];
        }
        k = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = temp[k--];
        }
    }
}
