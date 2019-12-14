package code;

import java.util.List;

/**
 * 139 单词拆分
 * tip 动态规划
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * https://leetcode-cn.com/problems/word-break/
 */
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示i个字符组成的字符串，是否可以满足要求
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 对0～i个字符组成的字符串进行拆分，得到0～j，j+1～i，2个字符串，分别判断是否满足要求
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
