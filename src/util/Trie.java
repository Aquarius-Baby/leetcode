package util;


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
            cur.count++;
            if (cur.childs.containsKey(w)) {
                cur = cur.childs.get(w);
            } else {
                cur.childs.put(w, new TrieNode(cur, w));
                cur = cur.childs.get(w);
            }
        }
        cur.isLeaf = true;
        cur.count++;
    }

    /**
     * 判断单词是否存在
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isLeaf;
    }

    /**
     * 判断前缀开始单词是否存在
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private int count(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node.count;
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

    // 打印节点
    private void printNode(TrieNode node, int layer) {
        // 层级递进
        for (int i = 0; i < layer; i++) {
            System.out.print("\t");
        }
        // 打印
        System.out.println(node.val + " ----- prefix:" + node.prefix+" isWord:" + node.isLeaf + "  count:"+node.count);
        // 递归打印子节点
        for (Character s : node.childs.keySet()) {
            TrieNode child = node.childs.get(s);
            printNode(child, layer + 1);
        }
    }

    private void print() {
        printNode(root, 0);
    }


    public static void main(String[] args) {

        Trie root = new Trie();

        root.insert("interest");
        root.insert("interesting");
        root.insert("interested");
        root.insert("inside");
        root.insert("insert");
        root.insert("apple");
        root.insert("inter");
        root.insert("interesting");

        root.print();

        boolean isFind = root.search("inside");
        System.out.println("find inside : " + isFind);

        int count = root.count("inter");
        System.out.println("count prefix inter : " + count);

    }

}

