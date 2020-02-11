package sort;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 9, 3, 7};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        quickSortHelp(nums, left, right);
    }

    private void quickSortHelp(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = nums[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，找到第一个比key小的值，位置为j
            while (nums[j] >= key && i < j) {
                j--;
            }
            // 将右侧比key小的数放到左边
            if (i < j) {
                nums[i] = nums[j];
            }
            //i向右移，直到遇到比key大的值
            while (nums[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = key;
        quickSortHelp(nums, left, i - 1);
        quickSortHelp(nums, i + 1, right);
    }
}