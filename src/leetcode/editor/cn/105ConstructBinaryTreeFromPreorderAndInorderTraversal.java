package leetcode.editor.cn;

// 105 从前序与中序遍历序列构造二叉树
// 2021-02-24 10:21:36

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 887 👎 0


import util.TreeNode;

import java.util.HashMap;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> inMap = new HashMap();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            TreeNode root = help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
            return root;
        }

        public TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
            // 递归结束条件
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            // 找到左右的开始结束
            int inorderRootIndex = inMap.get(preorder[preStart]);
            int leftLength = inorderRootIndex - inStart;

            TreeNode left = help(preorder, preStart + 1, preStart + leftLength, inorder, inStart, inorderRootIndex - 1, inMap);
            TreeNode right = help(preorder, preStart + leftLength + 1, preEnd, inorder, inorderRootIndex + 1, inEnd, inMap);
            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}