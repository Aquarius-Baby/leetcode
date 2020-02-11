package sort;

/**
 * 基数排序
 */
public class RadixSort {
    /**
     *
     * @param A 原数组
     * @param temp 临时数组
     * @param n 序列的数字个数
     * @param k 最大的位数2
     * @param r 基数10
     * @param cnt 存储bin[i]的个数
     */
    public static void RadixSort(int A[], int temp[], int n, int k, int r, int cnt[]) {
        for (int i = 0, rtok = 1; i < k; i++, rtok = rtok * r) {
            //初始化
            for (int j = 0; j < r; j++) {
                cnt[j] = 0;
            }
            //计算每个箱子的数字个数
            for (int j = 0; j < n; j++) {
                cnt[(A[j] / rtok) % r]++;
            }
            //cnt[j]的个数修改为前j个箱子一共有几个数字
            for (int j = 1; j < r; j++) {
                cnt[j] = cnt[j - 1] + cnt[j];
            }
            for (int j = n - 1; j >= 0; j--) {      //重点理解
                cnt[(A[j] / rtok) % r]--;
                temp[cnt[(A[j] / rtok) % r]] = A[j];
            }
            for (int j = 0; j < n; j++) {
                A[j] = temp[j];
            }
        }
    }
}
