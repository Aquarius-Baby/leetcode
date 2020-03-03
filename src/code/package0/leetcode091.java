package code.package0;

/**
 * 091 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 */
public class leetcode091 {
    public static void main(String[] args) {
        String s = "27";
        System.out.println(new leetcode091().numDecodings(s));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int pre = Integer.valueOf(s.substring(i - 1, i + 1));
            int cur = Integer.valueOf(s.substring(i, i + 1));
            if (cur > 0 && cur < 10) {
                dp[i + 1] += dp[i];
            }
            if (pre >= 10 && pre < 27) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public int numDecodings2(String s) {
        if (s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int index = i - 1;
            int cur = Integer.parseInt(s.substring(index, index + 1));
            int pre = Integer.parseInt(s.substring(index - 1, index + 1));
            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
            }
            if (pre >= 10 && pre <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
