package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 3, 2, 7};
        new InsertionSort().insertionSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            // 找到第一个比插入数要小的index，将数插入index+1的位置
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            j++;
            nums[j] = temp;
        }
    }

    private void insertionSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 找到第一个比插入数要小的index，将数插入index+1的位置
            for (int j = i; j > 0; j--) {
                System.out.println((j - 1) + "---" + j);
                if (nums[j - 1] > nums[j]) {
                    int t = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = t;
                } else {
                    break;
                }
            }
        }
    }
}
