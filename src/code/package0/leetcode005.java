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
        String s = "cbbd";
        System.out.println(new leetcode005().longestPalindrome(s));
    }

    /**
     * 解法1：中心扩展
     *
     * 注意：start end 位置的更新
     *
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
}
