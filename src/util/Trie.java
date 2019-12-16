package util;

import java.util.HashMap;

public class Trie {

    //根结点
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode cur = root;
        for (char w : charArray) {
            if (cur.childs.containsKey(w)) {
                cur = cur.childs.get(w);
            } else {
                cur.childs.put(w, new TrieNode(cur, w));
                cur = cur.childs.get(w);
            }
        }
        cur.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String word) {
        char[] charArray = word.toCharArray();
        TrieNode cur = root;

        for (char w : charArray) {
            if (cur.childs.containsKey(w)) {
                cur = cur.childs.get(w);
            } else {
                return null;
            }
        }
        return cur;
    }
}

