package leetcode.editor.cn;

// 76 最小覆盖子串
// 2021-03-04 17:43:25

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 989 👎 0


import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "aa";
        String t = "aa";
        //s = "ADOBECODEBANC", t = "ABC"
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() < t.length()) {
                return "";
            }
            Map<Character, Integer> needMap = new HashMap<>();
            for (char a : t.toCharArray()) {
                int count = needMap.getOrDefault(a, 0) + 1;
                needMap.put(a, count);
            }
            Map<Character, Integer> haveMap = new HashMap<>();

            int left = 0;
            int right = 0;
            int start = 0;
            int length = Integer.MAX_VALUE;
            int validNum = 0;

            char[] array = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                // curChar 是将移入窗口的字符
                char curChar = array[i];
                right++;
                if (needMap.containsKey(curChar)) {
                    int count = haveMap.getOrDefault(curChar, 0) + 1;
                    haveMap.put(curChar, count);
                    // 这个是被需要的
                    if (count == needMap.get(curChar)) {
                        validNum++;
                    }
                }
                // 右移窗口
                // 判断左侧窗口是否要收缩
                // 正好全部符合
                while (validNum == needMap.size()) {
                    if (right - left < length) {
                        start = left;
                        length = right - left;
                    }

                    // 最左侧的char，即将挪出去的
                    char leftChar = array[left];
                    left++;
                    if (needMap.containsKey(leftChar)) {
                        //是需要的
                        if (haveMap.get(leftChar).equals(needMap.get(leftChar))) {
                            validNum--;
                        }
                        //
                        haveMap.put(leftChar, haveMap.get(leftChar) - 1);
                    }
                }
            }
            if (length == Integer.MAX_VALUE) {
                return "";
            }
            String res = s.substring(start, start + length);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}