package code.package3;

public class leetcode340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() < k) return s.length();
        int[] counts = new int[128];
        int maxLength = 0;
        int diff = 0;
        int left = 0;
        char[] arrays = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (counts[arrays[i]] == 0) {
                diff++;
            }
            counts[arrays[i]]++;
            while (diff > k) {
                counts[arrays[left]]--;
                if (counts[arrays[left]] == 0) {
                    diff--;
                }
                left++;
            }
            if (i - left + 1 >= maxLength) {
                maxLength = i - left + 1;
            }
        }
        return maxLength;
    }
}
