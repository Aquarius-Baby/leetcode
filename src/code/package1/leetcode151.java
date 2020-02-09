package code.package1;

/**
 * 151 翻转字符串里的单词
 */
public class leetcode151 {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(new leetcode151().reverseWords(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] array = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        int length = array.length;
        for (int i = length - 1; i >= 0; i--) {
            if (i == 0) {
                res = res.append(array[i]);
            } else {
                res = res.append(array[i]).append(" ");
            }
        }
        return res.toString();
    }

}
