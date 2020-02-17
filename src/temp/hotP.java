package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class hotP {
    public static void main(String[] args) {

        Integer totalAmount = 1000;//红包金额  分
        Integer totalPeopleNum = 10;//红包个数
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        while (list.size() < totalPeopleNum - 1) {
            int i = random.nextInt(totalAmount) + 1;//最低1分钱
            if (list.indexOf(i) < 0) {//非重复切割添加到集合
                list.add(i);
            }
        }
        Collections.sort(list);
        int flag = 0;
        int fl = 0;
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i) - flag;
            flag = list.get(i);
            fl += temp;
            double t = (double) temp / 1000;
            sum += t;
            System.out.println("红包切割金额" + t);
        }
        //最后一个红包
//        list.add(totalAmount - fl);
//        System.out.println("红包切割金额" + AmountUtil.div(AmountUtil.sub(totalAmount, fl), 100));
        double t = (double)(totalAmount - fl) / 1000;
        sum += t;
        System.out.println("红包切割金额" + t);

//        System.out.println(fl + AmountUtil.sub(totalAmount, fl));
        System.out.println(sum);
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
