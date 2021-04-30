package code.package0;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 098 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class leetcode098 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        read(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void read(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        read(root.left, list);
        list.add(root.val);
        read(root.right, list);
    }

    /**
     * 解法2
     *
     * @param root
     * @return
     */
    static int pre;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (pre < root.val) {
                pre = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }


}
