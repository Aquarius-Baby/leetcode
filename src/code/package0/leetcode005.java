package code.package0;

/**
 * 005 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class leetcode005 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new leetcode005().longestPalindrome(s));
        System.out.println(new leetcode005().longestPalindrome2(s));
    }

    /**
     * 解法1：中心扩展
     * <p>
     * 注意：start end 位置的更新
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0)
            return s;
        char[] arrays = s.toCharArray();
        int length = 0;
        int start = 0;
        for (int i = 0; i < arrays.length; i++) {
            int t1 = find(arrays, i, i);
            if (t1 > length) {
                length = t1;
                start = i - length / 2;
            }
            int t2 = find(arrays, i, i + 1);
            if (t2 > length) {
                length = t2;
                start = i - length / 2 + 1;
            }
        }
        return s.substring(start, start + length);
    }

    private int find(char[] arrays, int i, int j) {
        while (i >= 0 && j < arrays.length) {
            if (arrays[i] != arrays[j]) {
                break;
            }
            i--;
            j++;
        }
        return (j - i - 1);
    }

    /**
     * 解法2：动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        char[] array = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (array[i] == array[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
