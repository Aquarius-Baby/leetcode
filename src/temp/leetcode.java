package temp;


import com.sun.deploy.util.StringUtils;

public class leetcode {
    public static void main(String[] args) {
        String s = "aa";
        boolean flag = isPalindrome(s);
        System.out.println(flag);

    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String t = s.toLowerCase();
        char[] arrays = t.toCharArray();
        int i = 0;
        int j = arrays.length - 1;

        while (i <= j) {
            if (!Character.isLowerCase(arrays[i]) && !Character.isDigit(arrays[i])) {
                i++;
                continue;
            }
            if (!Character.isLowerCase(arrays[j]) && !Character.isDigit(arrays[j])) {
                j--;
                continue;
            }
            if (arrays[i] != arrays[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;


    }
}
