package code.package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120 三角形最小路径和
 */
public class leetcode120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(list));
    }

    /**
     * 自顶向下的遍历
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) return 0;
        int[][] res = new int[size][size];

        List<Integer> temp = triangle.get(0);
        res[0][0] = temp.get(0);

        for (int i = 1; i < size; i++) {
            temp = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + temp.get(j);
                } else if (j == i) {
                    res[i][j] = res[i - 1][j - 1] + temp.get(j);
                } else {
                    res[i][j] = Math.min(res[i - 1][j], res[i - 1][j - 1]) + temp.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : res[size - 1]) {
            min = Math.min(min, num);
        }
        return min;
    }

    /**
     * 自底向上的遍历
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) return 0;
        int[] dp = new int[size + 1];

        for (int i = size - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + temp.get(j);
            }
        }

        return dp[0];
    }
}
