package code.package0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 018 三数之和
 */
public class leetcode018 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        new leetcode018().fourSum(nums,0);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3 ; i++) {
            if(i!= 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 2行if 判断，从44% --》 75 %
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if(nums[i] + nums[length-1] + nums[length-2] + nums[length-3] < target) continue;
            for(int j = i + 1; j < length - 2 ; j++){
                if(j!= i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = length - 1 ;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r] ;
                    if (sum == target) {
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        res.add(item);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 2; i--) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> curRes = threeSum(nums, i - 1, target - nums[i]);
                for (int j = 0; j < curRes.size(); j++) {
                    curRes.get(j).add(nums[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum(int[] nums, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = end; i > 1; i--) {
            if (i == end || nums[i] != nums[i + 1]) {
                List<List<Integer>> curRes = twoSum(nums, i - 1, target - nums[i]);
                for (int j = 0; j < curRes.size(); j++) {
                    curRes.get(j).add(nums[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int end, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int l = 0;
        int r = end;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(nums[l]);
                item.add(nums[r]);
                res.add(item);
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
                while (l < r && nums[r] == nums[r + 1])
                    r--;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

}
