package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(a, first, middle, temp);//左半部分排好序
            mergeSort(a, middle + 1, last, temp);//右半部分排好序
            mergeArray(a, first, middle, last, temp); //合并左右部分
        }
    }

    public static void mergeArray(int a[], int first, int middle, int end, int temp[]) {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int n = end;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                k++;
                i++;
            } else {
                temp[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= m) {
            temp[k] = a[i];
            k++;
            i++;
        }
        while (j <= n) {
            temp[k] = a[j];
            k++;
            j++;
        }
        for (int index = 0; index < k; index++) {
            a[first + index] = temp[index];
        }
    }
}
