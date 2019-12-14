package code;

import util.TreeNode;


/**
 * leetcode 112 路径总和
 * tip 深度优先搜索
 *
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class leetcode112 {

    public static void main(String[] args) {
/**
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 */
        int[] nums = {5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 1};
        TreeNode root = TreeNode.getTreeNode(nums);
        boolean res = hasPathSum(root, 22);
        System.out.println(res);

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        boolean flag = help(root, sum);
        return flag;
    }

    public static boolean help(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        boolean flag = false;
        if (root.left != null) {
            flag = help(root.left, sum - root.val);
        }
        if (flag) {
            return true;
        }
        if (root.right != null) {
            flag = help(root.right, sum - root.val);
        }
        return flag;
    }
}
