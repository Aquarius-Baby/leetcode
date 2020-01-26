package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 957 N天后的牢房
 * <p>
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 * <p>
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 * <p>
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 * <p>
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 * <p>
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 * <p>
 *  
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 */
public class leetcode957 {

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 300;
        int[] res = new leetcode957().prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(res));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap<>();
        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }
        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }
        return ans;
    }
}
