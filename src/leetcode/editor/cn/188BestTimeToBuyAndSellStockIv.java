package leetcode.editor.cn;

// 188 买卖股票的最佳时机 IV
// 2021-03-03 16:35:10

//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 453 👎 0


class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();

        int[] prices = {2, 4, 1};
        int res = solution.maxProfit(2, prices);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int days = prices.length;
            // 可以不停的买入卖出
            if(k > days/2){
                int maxProfit = 0;
                for (int i = 1; i < days; i++) {
                    if (prices[i] > prices[i - 1]) {
                        maxProfit += prices[i] - prices[i - 1];
                    }
                }
                return maxProfit;
            }

            int[][][] dp = new int[days + 1][k + 1][2];

            for (int i = 0; i <= k; i++) {
                dp[0][i][0] = 0;
                dp[0][i][1] = Integer.MIN_VALUE;
            }

            for (int i = 0; i <= days; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Integer.MIN_VALUE;
            }

            for (int i = 0; i < days; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                    dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - prices[i]);
                }
            }
            return dp[days][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}