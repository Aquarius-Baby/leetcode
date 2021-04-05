package leetcode.editor.cn;

// 123 买卖股票的最佳时机 III
// 2021-03-03 19:56:27

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 691 👎 0


class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][3][2];
            dp[0][0][0] = 0;
            dp[0][0][1] = Integer.MIN_VALUE;
            dp[0][1][0] = 0;
            dp[0][1][1] = Integer.MIN_VALUE;
            dp[0][2][0] = 0;
            dp[0][2][1] = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {

                dp[i + 1][2][0] = Math.max(dp[i][2][0], dp[i][2][1] + prices[i]);
                dp[i + 1][2][1] = Math.max(dp[i][2][1], dp[i][1][0] - prices[i]);

                dp[i + 1][1][0] = Math.max(dp[i][1][0], dp[i][1][1] + prices[i]);
                dp[i + 1][1][1] = Math.max(dp[i][1][1], -prices[i]);

                System.out.println(
                        String.format("%s :[1][0] %s  [1][1] %s [2][0] %s [2][1] %s",
                                i, dp[i + 1][1][0], dp[i + 1][1][1], dp[i + 1][2][0], dp[i + 1][2][0]));
            }
            return dp[n][2][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}