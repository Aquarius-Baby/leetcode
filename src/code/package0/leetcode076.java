package code.package0;

public class leetcode076 {
    public String minWindow(String s, String t) {
        int count = t.length();
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left = 0;
        int right = 0;
        int begin = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                count--;
            }
            map[s.charAt(right++)]--;
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    begin = left;
                }
                if (map[s.charAt(left)] == 0) {
                    count++;
                }
                map[s.charAt(left++)]++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);
    }


    public String minWindow2(String s, String t) {
        int count = t.length();
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            int index = c;
            map[index]++;
        }
        int left = 0;
        int begin = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (map[index] > 0) {
                count--;
            }
            map[index]--;
            while (count == 0) {
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    begin = left;
                }
                if (map[s.charAt(left)] >= 0) {
                    count++;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);
    }
}
