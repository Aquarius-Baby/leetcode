package code.package10;

public class leetcode1011 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        int res = new leetcode1011().shipWithinDays2(weights, D);
        System.out.println(res);
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int num : weights) {
            right += num;
            left = left > num ? left : num;
        }
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) / 2;
            int day = 0;
            int sum = 1;
            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] > mid) {
                    day++;
                    sum = weights[i];
                } else if (sum + weights[i] == mid) {
                    day++;
                    sum = 0;
                } else {
                    sum += weights[i];
                }
            }
            if (day > D) {
                left = mid;
            } else if (day < D) {
                right = mid;
            } else {
                min = min > mid ? mid : min;
                left++;
                right--;
            }
        }
        return min;
    }

    public int shipWithinDays2(int[] weights, int D) {
        int lo = 0;
        int hi = 0;
        for (int num : weights) {
            hi += num;
            lo = lo > num ? lo : num;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] weights, int D, int K) {
        int cur = K; // cur 表示当前船的可用承载量
        for (int weight : weights) {
            if (weight > K) return false;
            if (cur < weight) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0; // 能否在D天内运完
    }
}
