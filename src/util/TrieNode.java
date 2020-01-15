package util;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> childs;      //子结点
    public boolean isLeaf;     //当前结点是否是完整字符串（是否是叶结点）
    //前缀val
    public char val;
    public String prefix = "";
    //以此为前缀的单词计数
    public int count = 0;

    public TrieNode() {
        this.isLeaf = false;
        this.childs = new HashMap<>();
    }

    public TrieNode(TrieNode trieNode, char s) {
        this.isLeaf = false;
        this.childs = new HashMap<>();
        this.val = s;
        this.prefix = trieNode.prefix + s;
    }


}
