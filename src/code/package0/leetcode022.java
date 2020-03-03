package code.package0;

import java.util.ArrayList;
import java.util.List;

/**
 * 022 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class leetcode022 {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = new leetcode022().generateParenthesis(n);
        for (String s : res)
            System.out.println(s);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] t = new char[2 * n];
        back(t, 0, n, n, res);
        return res;
    }

    public void back(char[] t, int index, int left, int right, List<String> res) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(new String(t));
            return;
        }
        if (left > 0) {
            t[index] = '(';
            back(t, index + 1, left - 1, right, res);
        }
        if (right > 0) {
            t[index] = ')';
            back(t, index + 1, left, right - 1, res);
        }
    }


}
