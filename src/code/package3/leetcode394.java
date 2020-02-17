package code.package3;

import java.util.LinkedList;

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
