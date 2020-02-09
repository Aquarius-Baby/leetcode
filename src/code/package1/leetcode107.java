package code.package1;

import util.TreeNode;

import java.util.*;

/**
 * 107 二叉树的层次遍历 II
 */
public class leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList<>(queue);
            queue = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            while (!newQueue.isEmpty()) {
                TreeNode node = newQueue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}
