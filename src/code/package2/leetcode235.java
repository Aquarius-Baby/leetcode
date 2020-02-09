package code.package2;

import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 235 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class leetcode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> ancestor = new HashMap();
        getAncestorMap(ancestor, root);
        ancestor.put(root, null);
        TreeNode childNode = p;
        Set<TreeNode> set = new HashSet<>();
        // 注意， p q可能是对方的祖先，所以需要将自己加入

        while (childNode != null) {
            set.add(childNode);
            childNode = ancestor.get(childNode);
        }
        TreeNode res = q;
        while (!set.contains(res)) {
            res = ancestor.get(res);
        }
        return res;
    }

    public void getAncestorMap(HashMap<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            getAncestorMap(map, root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            getAncestorMap(map, root.right);
        }
    }
}
