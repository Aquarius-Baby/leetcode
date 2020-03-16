package code;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 *
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "0110", N = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：S = "0110", N = 4
 * 输出：false
 *
 */
public class leetcode1016 {

    /**
     * 解法1：
     * 对于1～N，将其转换为二进制字符串，判断S中是否包含
     */
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; ++i) {
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }
}
