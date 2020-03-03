package code.package1;

import util.TreeNode;

/**
 * 105 从前序与中序遍历序列构造二叉树
 */
public class leetcode105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new leetcode105().buildTree(preorder, inorder);
        System.out.print(root.val);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = help(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return root;
    }

    TreeNode help(int[] preorder, int leftStart, int leftEnd, int[] inorder, int rightStart, int rightEnd) {
        if (leftStart == leftEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftStart]);
        int i = rightStart;
        for (; i < rightEnd; i++) {
            if (preorder[leftStart] == inorder[i]) break;
        }
        // 0 1 2 [3]
        int leftNum = i - rightStart;
        // pre leftStart+1 ---> leftStart + leftNum + 1      leftStart + leftNum + 1 --->leftEnd
        // in rightStart ---> i   i + 1 ---> rightEnd
        TreeNode left = help(preorder, leftStart + 1, leftStart + leftNum + 1, inorder, rightStart, i);
        TreeNode right = help(preorder, leftStart + leftNum + 1, leftEnd, inorder, i + 1, rightEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
