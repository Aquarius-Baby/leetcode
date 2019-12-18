package code;

/**
 * 97 字符串交错
 * tip 动态规划
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 */
public class leetcode097 {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean flag = new leetcode097().isInterleave(s1, s2, s3);
        System.out.println(flag);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null) {
            if (s1 != null || s2 != null) return false;
            return true;
        }
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        // s1 的前m个字符，s2 的前n个字符， 组成 s3的前 m+n-1 个字符
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else if (i == 0) {
                    // 注意角标问题 第j个字符的位置为 j-1
                    dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
