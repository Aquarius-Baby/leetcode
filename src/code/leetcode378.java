package code;

import java.util.PriorityQueue;

/**
 * 378 有序矩阵中第K小的元素
 */
public class leetcode378 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {6, 7, 12},
                {11, 14, 14}
        };
        int k = 5;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int n = matrix.length;
        if (k == n * n) return matrix[n - 1][n - 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                queue.add(matrix[i][j]);
            }
        }
        int count = 0;
        int res = 0;
        while (count < k) {
            res = queue.poll();
        }
        return res;
    }
}
