package leetcode.editor.cn;

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


import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}