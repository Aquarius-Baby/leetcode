package code.package0;

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
                dp[i + 1] += dp[i-1];
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
