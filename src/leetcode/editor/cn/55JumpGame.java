package leetcode.editor.cn;

// 55 跳跃游戏
// 2020-09-02 10:21:22

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 797 👎 0


class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        int[] nums2 = {0};
        System.out.println(solution.canJump(nums));
        System.out.println(solution.canJump(nums1));
        System.out.println(solution.canJump(nums2));
    }

    //
    // 方法1：
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            //  1. max 存储当前能到的最大的位置
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                // 2. 判断当前位置是否超出能到的最大的位置
                if (i > max) {
                    return false;
                }
                // 3. 更新能到的醉倒位置
                max = Math.max(max, i + nums[i]);
            }
            // 4. 判断最大能到的位置下标
            // 注意：此处判断容易出错。
            // max 是能到的数组最大位置的下标，nums最大的下标是 length - 1
            return max >= nums.length - 1 ? true : false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}