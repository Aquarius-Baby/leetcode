package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 3, 2, 7};
        new SelectionSort().selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     */
    private void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
            }
        }
    }
}
