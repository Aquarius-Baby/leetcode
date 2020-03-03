package code.package3;

import java.util.LinkedList;

/**
 * 394 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 */
public class leetcode394 {
    public static void main(String[] args) {
        String s = "3[ac]2[bc]";
        System.out.println(new leetcode394().decodeString(s));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<String> strList = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                numList.addLast(multi);
                strList.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_num = numList.removeLast();
                for (int i = 0; i < cur_num; i++) {
                    tmp.append(res);
                }
                String pre = strList.removeLast();
                res = new StringBuilder(pre + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
