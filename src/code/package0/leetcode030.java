package code.package0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 */
public class leetcode030 {
    /** 解法1：
        每一个单词的长度一致，先统计数组中的单词情况及其个数
        对s进行判断
            以第i个字符为起点，
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList();
        }
        int sLen = s.length();
        int wLen = words.length;
        int length = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for (String a : words) {
            if (wordsMap.containsKey(a)) {
                wordsMap.put(a, wordsMap.get(a) + 1);
            } else {
                wordsMap.put(a, 1);
            }
        }
        Map<String, Integer> curMap;
        for (int i = 0; i + wLen * length <= sLen; i = i + 1) {
            curMap = new HashMap<String, Integer>(wordsMap);
            for (int j = 0; j < wLen; j++) {
                String temp = s.substring(i + j * length, i + j * length + length);
                if (curMap.containsKey(temp)) {
                    int count = curMap.get(temp);
                    if (count == 1) {
                        curMap.remove(temp);
                    } else {
                        curMap.put(temp, count - 1);
                    }
                    if (curMap.isEmpty()) {
                        list.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
