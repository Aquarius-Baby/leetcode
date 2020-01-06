package code;

import java.util.HashMap;

/**
 * 003 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class leetcode003 {
    public static void main(String[] args) {
        String s = "aabbaa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        int startIndex = 0 ;
        for (int i = 0; i < length; i++) {
            char t = charArray[i];
            if (map.containsKey(t)) {
                int charIndex = map.get(t);
                if (charIndex >= startIndex) {
                    startIndex = charIndex + 1;
                 }
            }
            map.put(t, i);
            max = Math.max(max, i - startIndex + 1 );
        }
        return max;

    }
}
