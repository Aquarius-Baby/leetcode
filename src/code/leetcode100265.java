package code;

import java.io.*;

public class leetcode100265 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().q());
    }
}

class Solution {
    public String q() throws IOException {

        Class clazz = leetcode100265.class;
//         String filePath = this.getClass().getResource("").getPath()+"/leetcode100265.class");
        File filePath = new File("/Users/wgf/code/idea/cmy/leetcode/src/code/leetcode100265.java");
        String name = System.getProperty("user.dir");
        String name2 = System.getProperty("java.class.path");
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = "";
        StringBuilder res = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            res.append(line);
        }
        return res.toString();
    }
}