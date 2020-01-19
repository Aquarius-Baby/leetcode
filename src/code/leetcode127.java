package code;

import javafx.util.Pair;

import java.util.*;

/**
 * 127 单词接龙【最短长度】
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 */
public class leetcode127 {
    public static void main(String[] args) {

        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
//        List<List<String>> res = findLadders(beginWord, endWord, wordList);
//        for (List<String> list : res) {
//            for (String s : list) {
//                System.out.print(s + "  ");
//            }
//            System.out.println();
//        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                // 符合模糊匹配的，下一个被选择的单词 adjacentWord
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // 如果是我们想要的end word，直接返回level+1
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // 如果不是end word，设为已访问，放入队列中，其level+1
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}