package code;

import util.TreeNode;

import java.util.*;

/**
 * 103 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 注意初始化语句，很少使用
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean reverse = false;
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
            if (reverse) {
                Collections.reverse(temp);
            }
            res.add(temp);
            reverse = !reverse;
        }
        return res;
    }
}
