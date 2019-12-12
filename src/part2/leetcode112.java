package part2;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode112 {

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

//        int[] nums = {5,4,8,11,13,4,7,2,Integer.MIN_VALUE,1};
        int[] nums = {5,4,8,11,Integer.MIN_VALUE,13,4,7,2,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,1};
//        int[] nums = {1, 2};
        TreeNode root = TreeNode.getTreeNode(nums);
//        boolean res = hasPathSum(root, 22);
        pathSum(root, 22);
        for (List<Integer> list : res){
            for(Integer t : list){
                System.out.print(t +" ");
            }
            System.out.println();
        }

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

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        help2(root,sum,new ArrayList<>());
        return res;
    }


    public static void help2(TreeNode root, int sum, ArrayList<Integer> result) {
        if (root.left == null && root.right == null) {
            if(sum == root.val ){
                res.add(new ArrayList<>(result) );
            }
            return ;
        }
        result.add(root.val);
        sum = sum - root.val;
        if (root.left != null) {
            help2(root.left, sum ,result);
            result.remove(result.size()-1);
        }
        if (root.right != null) {
            help2(root.right, sum ,result);
            result.remove(result.size()-1);
        }
     }
}
