package code;

import java.util.PriorityQueue;

/**
 * 295 数据流的中位数
 * <p>
 * tip 堆
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
class MedianFinder {
    // min 的栈顶是该队列中最小的数
    PriorityQueue<Integer> min;
    // max 的栈顶是该队列中最大的数

    // max 的栈顶 比 min 的栈顶小 ！！！
    PriorityQueue<Integer> max;
    int minSize = 0;
    int maxSize = 0;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        min = new PriorityQueue<>((n1, n2) -> n1 - n2);
        max = new PriorityQueue<>((n1, n2) -> n2 - n1);
    }

    public void addNum(int num) {
        if (maxSize == 0) {
            max.add(num);
            maxSize++;
            return;
        }
        int maxTop = max.peek();

        if (num > maxTop) {
            if (minSize == maxSize + 1) {
                // 小堆数据多，num 和min[top] 中较小的数 需要放入 大堆。
                if (num < min.peek()) {
                    max.add(num);
                } else {
                    max.add(min.poll());
                    min.add(num);
                }
                maxSize++;
            } else {
                min.add(num);
                minSize++;
            }
        } else {
            // max的top放入min， num 放入 max，
            if (maxSize == minSize + 1) {
                // 大堆数据多，num max[top] 中较大的数 需要放入 小堆。
                if (num > max.peek()) {
                    min.add(num);
                } else {
                    min.add(max.poll());
                    max.add(num);
                }
                minSize++;
            } else {
                max.add(num);
                maxSize++;
            }
        }
    }

    public double findMedian() {
        if (maxSize > minSize) {
            return max.peek();
        }
        if (maxSize < minSize) {
            return min.peek();
        }
        double sum = max.peek() + min.peek();
        return sum / 2;
    }
}

public class leetcode295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(12);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(13);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(15);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(11);
        System.out.println(medianFinder.findMedian());
    }
}

