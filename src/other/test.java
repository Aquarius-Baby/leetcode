package other;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    public static void main(String[] args) {
        HashMap A = new HashMap();
        A.put(1,1);
        int[] nums = {1, 2, 3, 3, 3, 4};
        int res = test(nums);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }

        ConcurrentHashMap t = new ConcurrentHashMap();
        t.put(1,1);
    }

    private static int test(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                nums[index++] = nums[i];
            } else if (i == nums.length - 1 && nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            } else if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
