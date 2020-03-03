package code.package0;

import java.util.ArrayList;
import java.util.List;

/**
 * 017 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class leetcode017 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        help(res, "", digits, 0);
        return res;
    }

    private void help(List<String> res, String t, String digits, int index) {
        if (index == digits.length()) {
            res.add(t);
            return;
        }
        char[] c = getMapping(digits.charAt(index));
        for (int i = 0; i < c.length; i++) {
            help(res, t + c[i], digits, index + 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        char[] t = new char[digits.length()];
        help2(res, t, digits, 0);
        return res;
    }

    // 将传递的结果由String 修改为char[],结果： 5 --> 100 %
    private void help2(List<String> res, char[] t, String digits, int index) {
        if (index == digits.length()) {
            res.add(new String(t));
            return;
        }
        char[] c = getMapping(digits.charAt(index));
        for (int i = 0; i < c.length; i++) {
            t[index] = c[i];
            help2(res, t, digits, index + 1);
        }
    }

    private char[] getMapping(char i) {
        switch (i) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }
}
