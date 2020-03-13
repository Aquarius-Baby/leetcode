package programer;

public class t1 {

    public static void main(String[] args) {
        String str = "A1BC21C";
        String strlps = "121";
        String res = new t1().getPalindrome1(str);
        String res2 = new t1().getPalindrome2(str, strlps);
        System.out.println(res);
        System.out.println(res2);
    }

    public String getPalindrome1(String str) {
        if (str.length() < 1) {
            return str;
        }
        int[][] dp = getDp(str);
        int len = str.length();
        int changeLength = dp[0][len - 1];
        char[] temp = new char[len + changeLength];
        int i = 0;
        int j = len - 1;

        int resLeft = 0;
        int resRight = len + changeLength - 1;

        char[] chars = str.toCharArray();
        while (i <= j) {
            //不需要新添加字符
            if (chars[i] == chars[j]) {
                temp[resLeft++] = chars[i++];
                temp[resRight--] = chars[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                // 表明 从位置i到j-1的操作次数(在左侧添加字符)，< 从 i+1到j的操作次数(在右侧添加字符)
                // 所以，在左侧新添加与位置j相同的字符
                temp[resLeft++] = chars[j];
                temp[resRight--] = chars[j--];
            } else {
                // 在右侧新添加，与左侧位置i相同的字符
                temp[resLeft++] = chars[i];
                temp[resRight--] = chars[i++];
            }
        }
        String res = new String(temp);
        return res;
    }

    public int[][] getDp(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];
        char[] chars = str.toCharArray();
        // 对于位置i的字符，计算从位置j（j < i）到 i 最少的操作次数
        for (int i = 1; i < length; i++) {
            // 计算i-1到i的操作次数
            dp[i - 1][i] = chars[i - 1] == chars[i] ? 0 : 1;
            // 计算从第0位开始，到第i位的操作次数
            for (int j = i - 2; j > -1; j--) {
                // 如果位置j的元素与i相同，则不需要操作，[j][i] = [j+1][i-1]
                // 如果字符不相同，则考虑在左侧添加一个字符[j][i-1] 或者在右侧添加一个字符[j+1][i]
                if (chars[i] == chars[j]) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else {
                    dp[j][i] = Math.min(dp[j + 1][i], dp[j][i - 1]) + 1;
                }
            }
        }
        return dp;
    }

    /**
     * 进阶版
     * @param str
     * @param strlps
     * @return
     */
    String getPalindrome2(String str, String strlps) {
        if (str.length() < 1 || str == "")
            return "";
        int len1 = str.length();
        int len2 = strlps.length();
        char[] strc = str.toCharArray();
        char[] strlpsc = strlps.toCharArray();
        char[] res = new char[2 * len1 - len2];

        int strl = 0;
        int strr = len1 - 1;

        int lpsl = 0;
        int lpsr = len2 - 1;

        int resl = 0;
        int resr = 2 * len1 - len2 - 1;

        int tmpl = 0;
        int tmpr = 0;

        while (lpsl <= lpsr) {
            tmpl = strl;
            tmpr = strr;
            // 找到s1中左侧与s2中左侧一样的字符位置 strl
            while (strc[strl] != strlpsc[lpsl])
                strl++;
            // 找到s1中右侧与s2中右侧一样的字符位置 strr
            while (strc[strr] != strlpsc[lpsr])
                strr--;
            set(res, resl, resr, strc, tmpl, strl, strr, tmpr);
            resl += strl - tmpl + tmpr - strr;
            resr -= strl - tmpl + tmpr - strr;
            res[resl++] = strc[strl++];
            res[resr--] = strc[strr--];
            lpsl++;
            lpsr--;
        }
        String resF = new String(res);
        return resF;
    }

    /**
     *
     * @param res 存储结果的字符
     * @param resl 结果的左侧index
     * @param resr 结果的右侧index
     * @param str  s1的字符数组
     * @param ls   s1中左侧需要放入的字符
     * @param le   s1中右侧需要放入的字符
     * @param rs   s2中左侧字符
     * @param re   s2中右侧字符
     */
    public void set(char[] res, int resl, int resr, char[] str, int ls, int le, int rs, int re) {
        for (int i = ls; i < le; i++) {
            res[resl++] = str[i];
            res[resr--] = str[i];
        }
        for (int i = re; i > rs; i--) {
            res[resl++] = str[i];
            res[resr--] = str[i];
        }
    }
}
