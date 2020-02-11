package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        new RadixSort().radixSort(nums, 3);
        Arrays.toString(nums);
    }

    // d表示最大的数有多少位
    public void radixSort(int[] number, int d) {
        int k = 0;
        int n = 1;
        //控制键值排序依据在哪一位
        int m = 1;
        //数组的第一维表示可能的余数0-9
        int[][] temp = new int[10][number.length];
        //数组orderp[i]用来表示该位是i的数的个数
        int[] order = new int[10];
        while (m <= d) {
            // 将nums中的数，按照控制键值进行排序
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            // 按顺序放入nums中
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
