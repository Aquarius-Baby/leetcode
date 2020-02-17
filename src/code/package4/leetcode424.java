package code.package4;


public class leetcode424 {
    public static void main(String[] args) {
        String s = "AAABBC";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        int[] charCount = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c]++;
            count = Math.max(count, charCount[c]);
            if (i - left + 1 - count > k) {
                charCount[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
