package code.package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 131 分割回文字符串
 * 回溯算法
 */
public class leetcode131 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new leetcode131().partition(s);
        for (List<String> t : res) {
            for (String temp : t) {
                System.out.print(temp + "  ");
            }
            System.out.println();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return res;
        }

        back(s, 0, s.length(), new Stack<>(), res);
        return res;
    }

    private void back(String s, int start, int length, Stack<String> stack, List<List<String>> res) {
        if (start == length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < length; i++) {
            if (!isValid(s, start, i)) continue;
            stack.add(s.substring(start, i + 1));
            back(s, i + 1, length, stack, res);
            stack.pop();
        }
    }

    private boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
