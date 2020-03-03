package code.package0;

/**
 * 012 整数转罗马数字
 */
public class leetcode012 {
    public String intToRoman(int num) {
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] chars = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        int index = nums.length - 1;
        while(num > 0 ){
            while(num < nums[index]){
                index--;
            }
            num = num - nums[index];
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
