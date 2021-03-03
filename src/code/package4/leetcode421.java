package code.package4;

import java.util.HashSet;
import java.util.Set;

/**
 * 421 数组中两个数的最大异或值
 * <p>
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 * <p>
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * <p>
 * 你能在O(n)的时间解决这个问题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: [3, 10, 5, 25, 2, 8]
 * <p>
 * 输出: 28
 * <p>
 * 解释: 最大的结果是 5 ^ 25 = 28.
 */
public class leetcode421 {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maximumXOR = findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }

    // 如果 a ^ b = max 成立 ，max 表示当前得到的“最大值”，那么一定有 max ^ b = a 成立。
    // 我们可以先假设当前数位上的值为 “1”。
    // 再把当前得到的数与这个 n 个数的 前缀（因为是从高位到低位看，所以称为“前缀”）进行异或运算，放在一个哈希表中。
    // 再依次把所有 前缀 与这个假设的“最大值”进行异或以后得到的结果放到哈希表里查询一下，
    // 如果查得到，就说明这个数位上可以是“1”，否则就只能是 0
    public static int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            // 注意点1：利用 mask 保留前缀，取出每一个x的前n-i位
            mask = mask | (1 << i);
            System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 注意点2：与运算，将取出来的每一个数的前n-i位存入到集合中，以备接下来比较
                set.add(num & mask);
            }
            // 注意点3：res 为上一次比较得出的前n-i位最大的数值，利用 temp 尝试，若紧邻的下一位为1，是否有可能？

            // a 的前n-1位与 b的前n-1位进行异或 ==》a[n - 1] | b[n - 1] = res[n - 1]
            // 假设 res 的第n位=1  res | (1 << i)
            // a[n] | b[n] = res[n] ==> res[n] | a[n] = b[n]
            // 判断b[n] 是否存在，若存在，则res[n]为1，否则为1，不更新
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
