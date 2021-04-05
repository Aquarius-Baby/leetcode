package leetcode.editor.cn;

// 877 石子游戏
// 2021-03-17 13:22:24

//亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 
//
// 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
// 
//
// 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。 
//
// 
//
// 示例： 
//
// 输入：[5,3,4,5]
//输出：true
//解释：
//亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
//如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是偶数。 
// 1 <= piles[i] <= 500 
// sum(piles) 是奇数。 
// 
// Related Topics 极小化极大 数学 动态规划 
// 👍 226 👎 0


class StoneGame {
    public static void main(String[] args) {
        Solution solution = new StoneGame().new Solution();
        int[] piles = {5, 3, 4, 5};
        System.out.println(solution.stoneGame(piles));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGame(int[] piles) {

            //  dp[i][j].fir = max(piles[i] + dp[i+1][j].sec, piles[j] + dp[i][j-1].s ec)
            //  dp[i][j].fir = max( 选择最左边的⽯头堆 , 选择最右边的⽯头堆 )
            //  # 解释：我作为先⼿，⾯对 piles[i...j] 时，有两种选择：
            //   # 要么我选择最左边的那⼀堆⽯头，然后⾯对 piles[i+1...j]
            //   # 但是此时轮到对⽅，相当于我变成了后⼿；
            //   # 要么我选择最右边的那⼀堆⽯头，然后⾯对 piles[i...j-1]
            //   # 但是此时轮到对⽅，相当于我变成了后⼿。
            //
            //   if 先⼿选择左边: dp[i][j].sec = dp[i+1][j].fir
            //   if 先⼿选择右边: dp[i][j].sec = dp[i][j-1].fir
            //
            //   # 解释：我作为后⼿，要等先⼿先选择，有两种情况：
            //   # 如果先⼿选择了最左边那堆，给我剩下了 piles[i+1...j]
            //   # 此时轮到我，我变成了先⼿；
            //   # 如果先⼿选择了最右边那堆，给我剩下了 piles[i...j-1]
            //   # 此时轮到我，我变成了先⼿。

            int nums = piles.length;
            int[][][] dp = new int[nums][nums][2];
            // 初始化
            for (int i = 0; i < nums; i++) {
                dp[i][i][0] = piles[i];
                dp[i][i][1] = 0;
            }

            for (int i = nums - 2; i >= 0; i--) {
                for (int j = i + 1; j < nums; j++) {
                    int left = piles[i] + dp[i + 1][j][1];
                    int right = piles[j] + dp[i][j - 1][1];
                    if (left > right) {
                        dp[i][j][0] = left;
                        dp[i][j][1] = dp[i + 1][j][0];

                    } else {
                        dp[i][j][0] = right;
                        dp[i][j][1] = dp[i][j - 1][0];
                    }
                }
            }
            return dp[0][nums - 1][0] > dp[0][nums - 1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}