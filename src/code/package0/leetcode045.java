package code.package0;

/**
 * 045 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class leetcode045 {
    public static void main(String[] args) {
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int count = 0; // 步数
        int maxPlace = 0; // 当前步数能达到的最远距离
        int temp = 0; // 当前位置之前，所能达到的最远距离

        for (int i = 0; i < length; i++) {
            if (maxPlace >= length - 1) break;
            if (i > maxPlace) {
                maxPlace = temp;
                count++;
            }
            temp = Math.max(temp, i + nums[i]);
        }
        return count;
    }
}
