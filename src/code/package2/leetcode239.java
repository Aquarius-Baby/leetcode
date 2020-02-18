package code.package2;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 239 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 */
public class leetcode239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 解法1：滑动窗口
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque();
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        while (i < k) {
            while (queue.size() != 0 && nums[i] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i++);
        }
        int index = 0;
        res[index++] = nums[queue.peekFirst()];
        for (; i < nums.length; i++) {
            if (i - queue.getFirst() == k) {
                queue.removeFirst();
            }
            while (queue.size() != 0 && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            res[index++] = nums[queue.getFirst()];
        }
        return res;
    }

    /**
     * 解法2：暴力循环
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int t = nums[i];
            for (int j = 0; j < k; j++) {
                t = Math.max(t, nums[i + j]);
            }
            res[i] = t;
        }
        return res;
    }
}
