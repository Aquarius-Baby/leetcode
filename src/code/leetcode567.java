package code;

import java.util.HashMap;

/**
 * 567 字符串的排列
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class leetcode567 {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion2(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        int length2 = s2.length();
        if (length2 < length) return false;
        HashMap<Character, Integer> s1Map = new HashMap();
        for (char t : s1.toCharArray()) {
            int count = s1Map.getOrDefault(t, 0);
            s1Map.put(t, count + 1);
        }
        char[] s2Array = s2.toCharArray();
        for (int i = 0; i <= length2 - length; i++) {
            boolean flag = check(s1Map, s2Array, i, i + length);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(HashMap<Character, Integer> s1Map, char[] s2, int start, int end) {
        HashMap<Character, Integer> map = new HashMap(s1Map);
        for (int i = start; i < end; i++) {
            if (map.containsKey(s2[i])) {
                int count = map.get(s2[i]);
                if (count == 0) {
                    return false;
                }
                map.put(s2[i], count - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }
        int count = s1.length();
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char t = s2.charAt(i);
            if (charCount[t - 'a'] > 0) {
                count--;
            }
            charCount[t - 'a']--;
            while (i - left + 1 == s1.length()) {
                if (count == 0) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                charCount[leftChar - 'a']++;
                if (charCount[leftChar - 'a'] > 0) {
                    count++;
                }
                left++;
            }
        }
        return false;
    }
}
