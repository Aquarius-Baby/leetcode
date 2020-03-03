package code.package0;

import java.util.Arrays;

/**
 * 041 缺失的第一个正数
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 */
public class leetcode041 {

    /**
     * 解法1：排序 + 遍历
     *
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < length && nums[i] <= 0) {
            i++;
        }
        int temp = 1;

        for (; i < length; i++) {
            if (temp != nums[i]) {
                return temp;
            }
            temp = temp + 1;
            while (i != length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        if (i == length) {
            int t = nums[length - 1];
            if (t < 0) {
                temp = 1;
            } else {
                temp = t + 1;
            }
        }
        return temp;
    }

    /**
     * 解法2：
     *     第一次遍历：
     *
     *     将所有符合nums[i]大于0且小于length的元素交换到其值对应的下标位置，例如2应当交换到nums[2]的位置、6应当交换到nums[6]的位置。
     *     如果nums[i]==nums[nums[i]]则不需要移动，例如nums[0]==3但是nums[3]==3就不需要移动了。
     *     交换之后再检查nums[i]是否依然需要交换，如果需要交换继续交换，直至nums[i]无需交换再继续向后遍历。
     *     第二次遍历：
     *
     *     从1开始，如果nums[i]!=i则i就是缺失的第一个正数。
     *     两次遍历结束后：
     *
     *     如果没有找到缺失的第一个正数，就检查nums[0]==length如果相等则返回length+1，否则返回length
     */
    public int firstMissingPositive2(int[] nums) {
        if (nums==null||nums.length==0)return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0&&nums[i]<nums.length&&nums[i]!=nums[nums[i]]){
                int temp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=i)return i;
        }
        if (nums[0]==nums.length)return nums.length+1;
        return nums.length;
    }
}
