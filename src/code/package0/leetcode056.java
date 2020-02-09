package code.package0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class leetcode056 {

    public static void main(String[] args) {
        int[][] intercals = {{1, 3}, {0, 0}};
        int[][] res = merge(intercals);
        for (int[] t : res) {
            System.out.println(Arrays.toString(t));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);
        for (int i = 1; i < intervals.length; i++) {
            // start 超出了 前一个的范围   > 前一个的end
            if (intervals[i][0] <= intervals[i - 1][1]) {
                // start  取较小  end 取较大的
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                list.add(intervals[i - 1]);
            }
            if (i == intervals.length - 1) {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][]);
    }
}
