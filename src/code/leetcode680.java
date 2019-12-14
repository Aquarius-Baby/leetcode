package code;

/**
 * leetcode 680 回文字符串判断
 */
public class leetcode680 {

    public static void main(String[] args) {
        String s = "aba";
        boolean res = validPalindrome(s);
        System.out.println(res);
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (help(s, i + 1, j)) return true;
        if (help(s, i, j - 1)) return true;
        return false;
    }

    public static boolean help(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
