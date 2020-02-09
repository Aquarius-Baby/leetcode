package code.package2;

import java.util.Arrays;

/**
 * 287 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class leetcode287 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 2};
        int res = new leetcode287().findDuplicate3(nums);
        System.out.println(res);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 方法三：弗洛伊德的乌龟和兔子（循环检测）
     * 如果我们对 nums 进行这样的解释，即对于每对索引 i 和值 v_i 而言，
     * “下一个” v_j 位于索引 v_i 处，我们可以将此问题减少到循环检测。
     * <p>
     * 算法：
     * 首先，我们可以很容易地证明问题的约束意味着必须存在一个循环。
     * 因为 nums 中的每个数字都在 1 和 n 之间，所以它必须指向存在的索引。
     * 此外，由于 0 不能作为 nums 中的值出现，nums[0] 不能作为循环的一部分。
     */
    public int findDuplicate2(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    /**
     * 解法3：抽屉原理
     */
    public int findDuplicate3(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            int lessNum = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) {
                    lessNum++;
                }
            }
            if (lessNum <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
