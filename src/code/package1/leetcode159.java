package code.package1;

import java.util.HashMap;

public class leetcode159 {
    public static void main(String[] args) {
        String s = "ecebbaaa";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) return s.length();

        char first = ' ';
        char second = ' ';
        char expire = ' ';
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first == ' ') {
                first = c;
            } else if (second == ' ' && first != c) {
                second = c;
            } else if (second != c) {
                expire = first;
                first = second;
                second = c;
            }
            map.put(c, i);
            if (map.size() > 2) {
                int index = map.get(expire);
                left = index + 1;
                map.remove(expire);
            }
            if (i - left + 1 >= maxLength) {
                maxLength = i - left + 1;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int[] hash = new int[128];
        int diff = 0;
        int left = 0, right = 0, ans = 0;
        for (; right < s.length(); right++) {
            if (hash[s.charAt(right)] == 0) {
                diff++;
            }
            hash[s.charAt(right)]++;
            while (diff > 2) {
                hash[s.charAt(left)]--;
                if (hash[s.charAt(left)] == 0) {
                    diff--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
