package temp;

import util.TreeNode;

public class leetcode {
    public static void main(String[] args) {
        int[] array = {10, 5, 15, 1, 8, Integer.MIN_VALUE, 7};
//        int[] array = {3,Integer.MIN_VALUE,1,2};
        TreeNode root = TreeNode.getTreeNode(array);
        System.out.println(new leetcode().largestBSTSubtree(root));
    }

    static int preVal = Integer.MIN_VALUE;
    static int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        //深度优先搜索 判定每个子树是否是BST
        if (root == null) return 0;
        //每次判定是否是BST之前要初始化变量
        res = 0;
        help(root);
        return res;
    }

    public void help(TreeNode root){
        if (root == null) return ;
        //每次判定是否是BST之前要初始化变量
        preVal = Integer.MIN_VALUE;
        if (isBST(root)) {
            res = Math.max(res, getCount(root));
        }
        help(root.left);
        help(root.right);
    }

    //获取当前树的节点个数
    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return getCount(root.right) + getCount(root.left) + 1;
    }

    private boolean isBST(TreeNode root) {
        if (root == null) return true;
        boolean leftFlag = isBST(root.left);
        if (preVal >= root.val) return false;
        preVal = root.val;
        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;
    }

    public static int topK(int[] nums, int k) {
        int length = nums.length;
        if (length < k) return 0;

        int count = 0;
        while (count < k) {
            for (int i = 0; i < length - count - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                }
            }
            count++;
        }
        return nums[length - k];
    }

}
