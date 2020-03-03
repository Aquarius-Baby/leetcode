package code.package0;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class leetcode046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        int[] t = new int[nums.length];
        find(visited, nums, res, t, 0);
        return res;
    }

    public void find(boolean[] visited, int[] nums, List<List<Integer>> res, int[] t, int index) {
        if (index >= nums.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int num : t) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                t[index] = nums[i];
                find(visited, nums, res, t, index + 1);
                visited[i] = false;
            }
        }
    }
}
