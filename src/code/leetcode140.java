package code;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * 140 单词拆分2
 * tip 动态规划 回溯算法
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * https://leetcode-cn.com/problems/word-break/
 */
public class leetcode140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> res = new leetcode140().wordBreak(s, Arrays.asList(wordDict));
        for (String t : res) {
            System.out.println(t);
        }
    }

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
//        LinkedList<String> initial = new LinkedList<>();
//        initial.add("");
//        dp[0] = initial;
//        for (int i = 1; i <= s.length(); i++) {
//            LinkedList<String> list = new LinkedList<>();
//            for (int j = 0; j < i; j++) {
//                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
//                    list.stream().collect()
//                    for (String l : dp[j]) {
//                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
//                    }
//                }
//            }
//            dp[i] = list;
//        }
//        return dp[s.length()];
//
//    }
public List<String> wordBreak(String s, List<String> wordDict) {
    List<String>[] v = new List[s.length() + 1];
    HashSet<String> set = new HashSet<>(wordDict);
    return recursive(v, 0, s, set);
}

    public List<String> recursive(List<String>[] v, int start, String s, HashSet<String> wordDict){
        if(v[start] == null) v[start] = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if(v[i+1] != null && v[i+1].isEmpty()) continue;
            String curStr = s.substring(start, i + 1);
            if (wordDict.contains(curStr)) {
                if(i + 1 != s.length()) {
                    if (v[i + 1] == null)
                        v[i + 1] = recursive(v, i + 1, s, wordDict);
                    for (String temp : v[i + 1]) {
                        v[start].add(curStr + " " + temp);
                    }
                }
                else v[start].add(curStr);
            }
        }
        return v[start];
    }
}
