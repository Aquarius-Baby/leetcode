package util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTreeNode(int[] temp) {
        if (temp == null) {
            return null;
        }
        TreeNode root = new TreeNode(temp[0]);
        help(temp, 0, root);
        return root;
    }

    private static void help(int[] temp, int index, TreeNode root) {
        if (index >= temp.length) {
            return;
        }
        int length = temp.length;
        if (2 * index + 1 < length) {
            int leftIndex = 2 * index + 1;
            if (temp[leftIndex] == Integer.MIN_VALUE) {
                return;
            }
            root.left = new TreeNode(temp[leftIndex]);
            help(temp, leftIndex, root.left);
        }
        if (2 * index + 2 < length) {
            int rightIndex = 2 * index + 2;
            if (temp[rightIndex] == Integer.MIN_VALUE) {
                return;
            }
            root.right = new TreeNode(temp[rightIndex]);
            help(temp, rightIndex, root.right);
        }
    }

    /**
     * 中序遍历
     */

    private  static void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        mid(root.left);
        mid(root.right);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, Integer.MIN_VALUE, 4, 5, 6};
        TreeNode root = TreeNode.getTreeNode(a);
        TreeNode.mid(root);
    }
}
