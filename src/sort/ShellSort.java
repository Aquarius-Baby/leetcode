package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 3, 2, 7, 8};
        ShellSort.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSort(int[] array) {
        int temp = 0;
        int length = array.length;
        int incre = length;
        while (true) {
            // 增量减半
            incre = incre / 2;
            for (int k = 0; k < incre; k++) {    //根据增量分为若干子序列
                ///循环插入排序
                for (int i = k + incre; i < length; i += incre) {
                    //      int temp = array[i];
                    ////                    int j = i - incre;
                    ////                    while (j >= k && array[j] > temp) {
                    ////                        array[j + incre] = array[j];
                    ////                        j = j - incre;
                    ////                    }
                    ////                    j = j + incre;
                    ////                    array[j] = temp;
                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }
}
