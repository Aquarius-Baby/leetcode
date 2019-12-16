package util;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> childs;      //子结点
    public boolean isLeaf;     //当前结点是否是完整字符串（是否是叶结点）
    public String val = "";

    public TrieNode() {
        this.isLeaf = false;
        this.childs = new HashMap<>();
    }

    public TrieNode(TrieNode trieNode, char s) {
        this.isLeaf = false;
        this.childs = new HashMap<>();
        this.val = trieNode.val + s;
    }


}
