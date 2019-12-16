package code;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * tip 树
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class leetcode230 {

    public static void main(String[] args) {
        //root = [3,1,4,null,2], k = 1
        int[] nums = {5, 3, 6, 2, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 1};
        TreeNode root = TreeNode.getTreeNode(nums);
        int res = new leetcode230().kthSmallest(root, 3);
        System.out.println(res);

    }

    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        help(root, k, list);
        return list.get(k - 1);
    }

    private void help(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        help(root.left, k, list);
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        help(root.right, k, list);
    }
}
