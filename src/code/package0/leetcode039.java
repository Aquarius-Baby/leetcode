package code.package0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode039 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new leetcode039().combinationSum(nums, target);
        for (List<Integer> t : result) {
            System.out.println(Arrays.toString(t.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findSum(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void findSum(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            temp.add(nums[i]);
            findSum(result, temp, nums, i, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }


//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Arrays.sort(candidates);
//        findSum(result, new ArrayList<>(), candidates, 0, target);
//        return result;
//    }
//
//    public void findSum(List<List<Integer>> result, List<Integer> temp, int[] number, int from, int target) {
//        if (target == 0) {
//            List<Integer> list = new ArrayList<Integer>(temp);
//            result.add(list);
//        } else {
//            for (int i = from; i < number.length && number[i] <= target; i++) {
//                temp.add(number[i]);
//                findSum(result, temp, number, i, target - number[i]);
//                temp.remove(new Integer(number[i]));
//            }
//        }
//    }
}
