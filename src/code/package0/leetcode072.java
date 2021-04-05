package code.package0;

// 72 编辑距离
// 2021-03-09 20:18:02

//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
public class leetcode072 {
    public static void main(String[] args) {
        leetcode072 solution = new leetcode072();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));
    }


    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];
        // 注意初始化
        // s1 的 i 个字符，变为 s2 的0个字符
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        // s1 的 0 个字符，变为 s2 的 j 个字符
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        dp[0][0] = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果word1[i] != word2[j]
                    // 替换第i个, 从 i-1 到 j-1   dp[i-1][j-1] + 1
                    // 新增第j个, 从 i 到 j-1     dp[i][j - 1] + 1
                    // 删除第i个, 从 i-1 到 j     dp[i-1][j] + 1
                    int min = Math.min(dp[i - 1][j - 1], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[length1][length2];
    }
}
