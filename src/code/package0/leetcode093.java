package code.package0;

import java.util.*;

/**
 * 093 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class leetcode093 {
    public static void main(String[] args) {
        String s = "0279245587303";
        List<String> res = new leetcode093().restoreIpAddresses(s);
        for (String t : res) {
            System.out.println(t);
        }
    }

    public List<String> restoreIpAddresses1(String s) {
        List<String> list = new ArrayList<>();
        return restoreAddresses(s, 4, list, new Stack<String>());
    }

    public List<String> restoreAddresses1(String s, int num, List<String> res, Stack<String> stack) {
        int length = s.length();
        if (num == 0) {
            if (s.length() != 0) {
                return res;
            }
            String ip = String.join(".", stack);
            res.add(ip);
            return res;
        }

        for (int i = 1; i < 4 && i <= length; i++) {
            if (i > 1 && s.charAt(0) == '0') {
                continue;
            }
            String newString = s.substring(i, length);
            String ip = s.substring(0, i);

            if (Integer.valueOf(ip) <= 255) {
                stack.push(s.substring(0, i));
                restoreAddresses1(newString, num - 1, res, stack);
                stack.pop();
            }
        }
        return res;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        return restoreAddresses(s, 0, list, new Stack<String>());
    }

    public List<String> restoreAddresses(String s, int num, List<String> res, Stack<String> stack) {
        int length = s.length();
        if (num == 3) {
            if (length<= 0 || length > 3 ||Integer.valueOf(s) > 255) {
                return res;
            }
        }

        if (num >= 4) {
            if (s.length() != 0) {
                return res;
            }
            String ip = String.join(".", stack);
            res.add(ip);
            return res;
        }

        for (int i = 1; i <= 3 && i <= length; i++) {
            if (i > 1 && s.charAt(0) == '0') {
                continue;
            }
            String newString = s.substring(i, length);
            String ip = s.substring(0, i);
            if (Integer.valueOf(ip) <= 255) {
                stack.push(ip);
                restoreAddresses(newString, num + 1, res, stack);

                stack.pop();
            }
        }
        return res;
    }
}
