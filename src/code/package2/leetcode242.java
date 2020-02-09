package code.package2;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class leetcode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char temp : cs) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);
            } else {
                return false;
            }
        }
        for (char temp : map.keySet()) {
            if (map.get(temp) != 0) {
                return false;
            }
        }
        return true;
    }
}
