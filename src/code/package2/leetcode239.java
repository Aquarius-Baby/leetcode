package code.package2;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 239 滑动窗口最大值
 */
public class leetcode239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

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
}
