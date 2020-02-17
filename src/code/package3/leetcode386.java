package code.package3;

import java.util.ArrayList;
import java.util.List;

/**
 * 386 字典序排数
 * <p>
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n = 13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class leetcode386 {
    public static void main(String[] args) {
        int n = 13;
        List<Integer> res = new leetcode386().lexicalOrder(n);
        for(Integer i : res){
            System.out.println(i);
        }
    }

    /**
     * 解法1：
     * 对于前缀 prefix，
     * 找到他的下一位，prefix * 10 + （0～9） < n
     * 1                                2  3  4 5 。。。。
     * 10     11     12    13    14？
     * 100?  110？  120？  130？  140
     *
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        find(0, n, res);
        return res;
    }

    private void find(int cur, int n, List<Integer> res) {
        int t = cur * 10;
        for (int i = 0; i < 10; i++) {
            if (cur == 0 && i == 0) continue;
            int next = t + i;
            if (next <= n) {
                res.add(next);
                find(next, n, res);
            }else{
                return;
            }
        }
    }
}
