package code;

/**
 * 152 乘积最大子序列
 */
public class leetcode152 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-9,-6};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < 0){
                int t = max ;
                max = min;
                min = t;
            }
            max = Math.max(max*num, num);
            min = Math.min(min*num, num);
            result = Math.max(max,result);
        }
        return result;
    }
}
