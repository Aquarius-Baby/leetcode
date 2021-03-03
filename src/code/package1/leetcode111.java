package code.package1;

import util.TreeNode;

import java.util.LinkedList;

/**
 * @Author: cmy
 * @Date: Created in  2021/3/3 2:30 下午
 * @Description:
 */

// 111 二叉树的最小深度
// 2021-03-01 20:48:15

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 460 👎 0

public class leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int step = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        list.add(root);
        //
        while (list.size() > 0) {
            TreeNode t = list.pop();
            if (t.left == null && t.right == null) {
                return step;
            }
            if (t.left != null) {
                list2.add(t.left);
            }
            if (t.right != null) {
                list2.add(t.right);
            }
            if (list.size() == 0) {
                list.addAll(list2);
                list2 = new LinkedList<>();
                step++;
            }
        }
        return step;
    }
}
