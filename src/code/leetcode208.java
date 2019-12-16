package code;

import util.Trie;

/**
 * 208 实现 Trie (前缀树)
 */
public class leetcode208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        boolean flag = false;
        trie.insert("apple");
        flag = trie.search("apple");   // 返回 true
        System.out.println(flag);

        flag = trie.search("app");     // 返回 false
        System.out.println(flag);

        flag = trie.startsWith("app"); // 返回 true
        System.out.println(flag);

        trie.insert("app");
        flag = trie.search("app");     // 返回 true
        System.out.println(flag);
    }
}

