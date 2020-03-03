package code.package0;

import java.util.Arrays;

/**
 * 031 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class leetcode031 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1};
        new leetcode031().nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) {
            index--;
        }
        // 逆序
        if (index == 0) {
            swap(nums, 0, nums.length - 1);
        } else {
            swap(nums, index, nums.length - 1);
            // 在index ， length-1中，找到第一个比index-1大的数，交换位置
            for (int j = index; j < nums.length; j++) {
                if (nums[j] > nums[index - 1]) {
                    // swap and break
                    int t = nums[index - 1];
                    nums[index - 1] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }
        // index 是第一个 > 前一哥数字的位置 [1,2,3,6,4,2] index = 3
    }

    public void swap(int[] nums, int begin, int end) {
        int temp;
        while (begin <= end) {
            temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }

}
