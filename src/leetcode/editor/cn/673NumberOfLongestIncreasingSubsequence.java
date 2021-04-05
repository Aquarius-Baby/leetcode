package leetcode.editor.cn;

// 673 最长递增子序列的个数
// 2021-03-09 19:49:54

//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 284 👎 0


import java.util.Arrays;

class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();

        int[] nums = {1,3,5,4,7};
        System.out.println(solution.findNumberOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findNumberOfLIS(int[] nums) {
            int size = nums.length;
            int[] dp = new int[size];

            Arrays.fill(dp, 1);
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        dp[j] = Math.max(dp[i], dp[j]) + 1;
                    }
                }
            }
            return dp[size - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}