package temp;

public class findNum {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 1, 3, 4, 1};
        int res = singleNumber(nums, nums.length);
        System.out.println(res);
    }

    static int singleNumber(int A[], int n) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < n; i++) {
            two |= one & A[i];//要在更新ones前面更新twos
            one ^= A[i];
            three = one & two;//ones和twos中都为1即出现了3次
            one &= ~three;//抹去出现了3次的bits
            two &= ~three;
        }
        return one;
    }
}
