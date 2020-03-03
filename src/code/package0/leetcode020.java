package code.package0;

import java.util.Stack;

/**
 * 020 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 */
public class leetcode020 {
    public static boolean isValid(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> x = new Stack();
        for (int i = 0; i < length; i++) {
            char t = chars[i];
            if (t == '(' || t == '{' || t == '[') {
                x.push(t);
            } else {
                if (x.size() == 0) {
                    return false;
                }
                char top = x.pop();
                if (t == ')') {
                    if (top != '(') {
                        return false;
                    }
                } else if (t == '}') {
                    if (top != '{') {
                        return false;
                    }
                } else if (t == ']') {
                    if (top != '[') {
                        return false;
                    }
                }
            }
        }
        return x.size() == 0;
    }
}
