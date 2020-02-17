package code.package0;

/**
 * 004 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class leetcode004 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1};
        System.out.println(new leetcode004().findMedianSortedArrays3(nums1, nums2));
    }

    /**
     * 解法1：合并数组后取中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] t = new int[m + n];
        int i = 0;
        int j = 0;
        int start = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                t[start++] = nums1[i++];
            } else {
                t[start++] = nums2[j++];
            }
        }
        while (i < m) {
            t[start++] = nums1[i++];
        }
        while (j < n) {
            t[start++] = nums2[j++];
        }

        if ((m + n) % 2 == 0) {
            System.out.println(t[(m + n) / 2] + " " + t[(m + n) / 2 - 1]);
            return (double) (t[(m + n) / 2] + t[(m + n) / 2 - 1]) / 2.0;
        } else {
            return t[(m + n) / 2];
        }
    }

    /**
     * 解法2：找到第k小的数字
     *
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index = (m + n) / 2 + 1;
        double t = findK(nums1, 0, nums2, 0, index);
        if ((m + n) % 2 == 0) {
            double t2 = findK(nums1, 0, nums2, 0, index - 1);
            t = (t + t2) / 2;
        }
        return t;
    }

    private double findK(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int t1 = i+k/2-1 >= nums1.length ? Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int t2 = j+k/2-1 >= nums2.length ? Integer.MAX_VALUE : nums2[j + k / 2 - 1];
        if (t1 < t2) {
            return findK(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findK(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
    /**
     * 解法3：
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        double res = 0;
        if (nums1.length > nums2.length) {
            res = find(nums2, nums1);
        } else {
            res = find(nums1, nums2);
        }
        return res;
    }

    /**
     * 解法3-帮助类
     */
    private double find(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        // 3，4 取得是第4位       mid = 4
        // 4，4 取得是第4，5位     mid = 4
        // 4，5 取得是第5位       mid = 5
        int mid = (m + n + 1) / 2;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = mid - i;
            if (i < end && nums2[j - 1] > nums1[i]) {
                //i偏小了，需要右移
                start = i + 1;
            } else if (i > start && nums1[i - 1] > nums2[j]) {
                //i偏大了，需要左移
                end = i - 1;
            } else {
                //i刚好合适，或i已达到数组边界
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    //如果大数组的长度是奇数，中位数就是左半部分的最大值
                    return maxLeft;
                }
                //如果大数组的长度是偶数，取左侧最大值和右侧最小值的平均
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


}
