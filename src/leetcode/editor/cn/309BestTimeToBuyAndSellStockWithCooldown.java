package leetcode.editor.cn;

// 309 最佳买卖股票时机含冷冻期
// 2021-03-03 16:35:14

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 692 👎 0


class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();

        int[] prices = {1, 2, 3, 0, 2};
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int days = prices.length;
            if (days == 0) {
                return 0;
            }
            // 可以不停的买入卖出
            int[][] dp = new int[days + 1][2];
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;

            dp[1][0] = 0;
            dp[1][1] = -prices[0];
            for (int i = 1; i < days; i++) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i - 1][0] - prices[i]);
            }
            return dp[days][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}