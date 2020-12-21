package leetcode.editor.cn;

// 134 加油站
// 2020-11-18 10:34:09

//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。 
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。 
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。 
//
// 说明: 
//
// 
// 如果题目有解，该答案即为唯一答案。 
// 输入数组均为非空数组，且长度相同。 
// 输入数组中的元素均为非负数。 
// 
//
// 示例 1: 
//
// 输入: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。 
//
// 示例 2: 
//
// 输入: 
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。 
// Related Topics 贪心算法 
// 👍 468 👎 0


class GasStation {
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};

        System.out.println(solution.canCompleteCircuit(gas, cost));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalGas = 0;
            int totalCost = 0;
            for (int i = 0; i < gas.length; i++) {
                totalGas += gas[i];
                totalCost += cost[i];
            }
            if (totalGas < totalCost) {
                return -1;
            }
            int i = 0;
            while (gas[i] < cost[i]) {
                i++;
            }

            int index = i;
            // 从第一个（index） gas > cost的加油站开始尝试
            while (index < gas.length) {
                int leftGas = 0;
                while (leftGas >= 0) {
                    // i 点 剩余gas left，到下一个点需要cost[i]
                    leftGas = leftGas + gas[i] - cost[i];
                    i = i++ % gas.length;
                    if (i == index) {
                        return index;
                    }
                }
                index++;
                i = index;
            }
            return -1;
        }

        public int canCompleteCircuit2(int[] gas, int[] cost) {
            int len = gas.length;
            int spare = 0;
            int minSpare = Integer.MAX_VALUE;
            int minIndex = 0;
            // spare = 累计剩余油量
            for (int i = 0; i < len; i++) {
                spare += gas[i] - cost[i];
                if (spare < minSpare) {
                    minSpare = spare;
                    minIndex = i;
                }
            }
            return spare < 0 ? -1 : (minIndex + 1) % len;
        }

        public int canCompleteCircuit3(int[] gas, int[] cost) {
            int n = gas.length;
            int i = 0;
            // 从第i个出发
            while (i < n) {
                int sumOfGas = 0, sumOfCost = 0;
                // 这一轮的第cnt个点
                int cnt = 0;
                while (cnt < n) {
                    // 当前是第j个点
                    int j = (i + cnt) % n;
                    sumOfGas += gas[j];
                    sumOfCost += cost[j];
                    // 油不够了
                    if (sumOfCost > sumOfGas) {
                        break;
                    }
                    cnt++;
                }
                // 走过了cnt个油站，即走了一圈
                if (cnt == n) {
                    return i;
                } else {
                    // 第cnt个点油不够
                    i = i + cnt + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}