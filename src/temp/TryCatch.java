package temp;

public class TryCatch {
    public static void main(String[] args) {
        int res = test();
        System.out.println("res: " + res);
    }

    public static int test() {
        int res = 0;
        try {
            res = 1;
            return res;
        } catch (Exception e) {
            res = -1;
            return res;
        } finally {
            res = 2;
//            return res; // 返回2
        }
    }
}
