package code;

import util.Trie;
import util.TrieNode;

import java.util.*;

/**
 * 212. 单词搜索 II
 * <p>
 * <p>
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = {"oath","pea","eat","rain"} and board =
 * {
 * {'o','a','a','n'},
 * {'e','t','a','e'},
 * {'i','h','k','r'},
 * {'i','f','l','v'}
 * }
 * <p>
 * 输出: {"eat","oath"}
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 */
public class leetcode212 {
    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        List<String> res = new leetcode212().findWords(board, words);
        for (String t : res) {
            System.out.println(t);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m, n;
        if ((m = board.length) == 0 || (n = board[0].length) == 0) return new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWord(trie, board, visited, i, j, m, n, "", res);
            }
        }
        return new ArrayList<>(res);
    }

    public void findWord(Trie trie, char[][] board, boolean[][] visited, int i, int j, int m, int n, String tempWord, Set<String> res) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true) {
            return;
        }
        tempWord = tempWord + board[i][j];
        TrieNode node = trie.searchPrefix(tempWord);
        if (null == node) {
            return;
        }
        if (node.isLeaf) {
            res.add(tempWord);
        }
        visited[i][j] = true;
        findWord(trie, board, visited, i + 1, j, m, n, tempWord, res);
        findWord(trie, board, visited, i - 1, j, m, n, tempWord, res);
        findWord(trie, board, visited, i, j + 1, m, n, tempWord, res);
        findWord(trie, board, visited, i, j - 1, m, n, tempWord, res);
        visited[i][j] = false;
    }
}

