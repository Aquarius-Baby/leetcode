package code;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 */
public class leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList(queue);
            queue = new LinkedList<>();
            TreeNode tempNode = newQueue.peek();
            while (!newQueue.isEmpty()) {
                tempNode = newQueue.poll();
                if (null != tempNode.left) queue.add(tempNode.left);
                if (null != tempNode.right) queue.add(tempNode.right);
            }
            res.add(tempNode.val);
        }
        return res;
    }
}
