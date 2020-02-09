package code.package3;

import java.util.*;

/**
 * 347 前 K 个高频元素
 */
public class leetcode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : nums) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((n1, n2) -> map.get(n1) - map.get(n2)));
        for (int t : map.keySet()) {
            priorityQueue.add(t);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
