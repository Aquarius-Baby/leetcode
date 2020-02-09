package code.package0;

import java.util.Arrays;

/**
 * 43 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class leetcode043 {
    public static void main(String[] args) {
        String num1 = "5";
        String num2 = "12";
        System.out.println(multiply(num1, num2));
        System.out.println(multiply2(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();

        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];

        // 初始化两个乘数数组
        for (int i = 0; i < length1; i++) {
            arr1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < length2; i++) {
            arr2[i] = num2.charAt(i) - '0';
        }
        int maxLen = num1.length() + num2.length() + 1;
        int[] res = new int[maxLen]; // 用来存放相乘的结果，低数位放在前面
        int temp = 0;
        int extra = 0;
        int m = 0;

        // 逐位相乘，如果需要进位，则进位
        for (int j = arr2.length - 1; j >= 0; j--) {
            for (int i = arr1.length - 1; i >= 0; i--) {
                temp = arr1[i] * arr2[j];
                m = (arr1.length - 1 - i) + (arr2.length - 1 - j);     // m标记当前数位
                res[m] += temp;
                while (res[m] >= 10) {   // 循环判断进位，累加至不需要进位
                    extra = res[m] / 10;
                    res[m] = res[m] % 10;
                    m++;
                    res[m] += extra;
                }
            }
        }

        // 构造结果字符串
        StringBuffer resString = new StringBuffer("");
        for (int i = m; i >= 0; i--) {
            resString.append(res[i]);
        }
        return resString.toString();

    }

    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();

        int[] num1Array = new int[length1];
        for (int i = 0; i < length1; i++) {
            num1Array[i] = num1.charAt(i) - '0';
        }

        int[] num2Array = new int[length2];
        for (int i = 0; i < length2; i++) {
            num2Array[i] = num2.charAt(i) - '0';
        }
        int[] results = new int[length1 + length2 + 1];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                int temp = num1Array[i] * num2Array[j];
                int index = length1 - 1 - i + length2 - 1 - j;
                results[index] = results[index] + temp;
            }
        }
        int count = 0;
        for (int i = 0; i < results.length; i++) {
            while (results[i] >= 10) {
                int temp = results[i];
                count = temp / 10;
                results[i] = temp % 10;
                i++;
                results[i] = results[i] + count;
            }
        }

        StringBuilder res = new StringBuilder();
        int i = results.length - 1;
        while (results[i] == 0) {
            i--;
        }
        for (; i >= 0; i--) {
            res = res.append(results[i]);
        }
        return res.toString();

    }
}
