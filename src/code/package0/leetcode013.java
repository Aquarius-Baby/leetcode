package code.package0;

/**
 * 013 罗马数字转整数
 */
public class leetcode013 {
    public int romanToInt(String s) {
        int res = 0;
        int pre = 0;
        char[] arrays = s.toCharArray();
        for (int i = 0; i < arrays.length; i++) {
            int t = getValue(arrays[i]);
            if (pre < t) {
                res = res - pre - pre + t;
            } else {
                res = res + t;
            }
            pre = t;
        }
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
