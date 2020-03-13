package other;


public class findBig {
    public static void main(String[] args) {
        String num = "5123";

        int k = 2;
        System.out.println(test(num, k));
    }

    public static String test(String num, int k) {
        int count = 0 ;

        String res = "";
        while(count < k ){
            res =  help(num);
            num = res;
            count++;
        }
        return res;
    }

    private static String help(String str) {
        StringBuilder res = new StringBuilder();
        int i = 1;
        for (; i < str.length(); i++) {
            if (str.charAt(i) -'0' >= str.charAt(i - 1) - '0') {
                res.append(str.charAt(i - 1));
            } else{
                break;
            }
        }
        for (; i < str.length(); i++) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
