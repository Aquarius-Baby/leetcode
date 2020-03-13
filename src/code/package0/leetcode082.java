package code.package0;

import util.ListNode;

/**
 * 082 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class leetcode082 {
    /**
     * 解法1：
     *
     *
     * 通过统计相同值的个数，来判断是否存在重复
     * 如果count == 1，表示不存在重复，则将节点放入新的链表中。
     *
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        start.next = head;
        int count = 1;
        while (head != null) {
            // 统计head值相同的个数，并向后移动
            while (head.next != null && head.val == head.next.val) {
                count++;
                head = head.next;
            }
            // 如果只有一个重复值，则head节点应该放入新链表
            if (count == 1) {
                start.next = head;
                start = start.next;
            }
            // head往后移动，成为新的需要判断的节点
            head = head.next;
            // 删除会导致错误
            // 输入[1,1] 期望输出[ ] 实际输出[1,1]
            start.next = head;
            count = 1;
        }
        return dummy.next;
    }

    /**
     * 解法2：
     *
     * 如果cur.next.val == cur.next.next.val说明此时有重复元素，
     * 此时创建一个临时指针temp，指向cur的下一个节点。
     * 即temp指向的第一个重复元素所在的位置。
     * 通过while循环去重，去重后，temp指向的是重复元素中的最后一个位置。
     * 最后cur.next = temp.next就实现了消除重复元素。
     * 当然，如果为发现重复元素，则直接向后迭代即可。
     * 迭代完成后，返回dummy的next。
     *
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else
                cur = cur.next;
        }
        return dummy.next;
    }
}
