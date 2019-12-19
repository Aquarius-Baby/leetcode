package code;

public class t {
    public static void main(String[] args) {

        int [] nums = {7,1,5,3,6,4};
        System.out.println(test2(nums));
    }

    public static int test(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int res = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (minPrice < price) {
                res = Math.max(res, price - minPrice);
            }
            minPrice = Math.min(minPrice, price);
        }
        return res;
    }

    public static int test2(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int res = 0;
        int minPrice = prices[0];
         for (int price : prices) {
            if (minPrice < price) {
                res = res + price - minPrice;
                minPrice = price;
             }
             minPrice = Math.min(minPrice, price);
        }
        return res;
    }
}
