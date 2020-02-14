package code.package0;

import java.util.HashMap;

/**
 * 003 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class leetcode003 {
    public static void main(String[] args) {
        String s = "abcaedabf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 解法1：
     * 记录每一个字符出现的index
     * (1) 根据第i个位置的字符，对子串的startIndex进行更新
     *         查找之前是否出现过
     *             1）出现过：更新startIndex = lastIndex + 1 ；
     *             2）未出现过：不做处理
     * (2) 计算最新子串的长度为： length = i- startIndex + 1
     * (3) 更新最长的长度 maxLenghth = Math.max(maxLenghth, length)
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        int startIndex = 0;
        int realStart = 0;
        for (int i = 0; i < length; i++) {
            char t = charArray[i];
            if (map.containsKey(t)) {
                int charIndex = map.get(t);
                if (charIndex >= startIndex) {
                    startIndex = charIndex + 1;
                }
            }
            map.put(t, i);
            max = Math.max(max, i - startIndex + 1);
            // 如果需要返回的是字串
            if (max <= i - startIndex + 1) {
                realStart = startIndex;
            }
        }
        System.out.println(s.substring(realStart, realStart + max));
        return max;
    }
}
