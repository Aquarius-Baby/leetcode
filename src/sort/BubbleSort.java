package sort;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度 o(n)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 3, 2, 7};
        new BubbleSort().bubbleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 解法1 ：先确定大的数
     */
    private void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
    }

    /**
     * 解法2：先确定小得数
     */
    private void bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                }
            }
        }
    }

    /**
     * 解法3：1基础的优化，如果一次排序中不存在交换顺序，说明已经排好序可，可以退出了
     *
     * @param nums
     */
    private void bubbleSort2(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                System.out.println(j + "---" + (j + 1));
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
