package code;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 113 路径总和2
 * tip 深度优先搜索
 *
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class leetcode113 {

    static List<List<Integer>> res = new ArrayList<>();

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
        pathSum(root, 22);
        for (List<Integer> list : res) {
            for (Integer t : list) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        help2(root, sum, new ArrayList<>());
        return res;
    }


    public static void help2(TreeNode root, int sum, ArrayList<Integer> result) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(result));
            }
            return;
        }
        result.add(root.val);
        sum = sum - root.val;
        if (root.left != null) {
            help2(root.left, sum, result);
            result.remove(result.size() - 1);
        }
        if (root.right != null) {
            help2(root.right, sum, result);
            result.remove(result.size() - 1);
        }
    }
}
