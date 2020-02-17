package code.package0;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 098 二叉搜索树
 */
public class leetcode098 {
    List<Integer> list = new ArrayList<Integer>();


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        read(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    public void read(TreeNode root) {
        if (root == null) {
            return;
        }
        read(root.left);
        list.add(root.val);
        read(root.right);
    }

}
