package code.package1;

import util.ListNode;

/**
 * 143 重排链表
 */
public class leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 1.找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = slow.next;
        slow.next = null;
        // 2.反转后半部分链表
        ListNode pre = null;
        while (reverse != null) {
            ListNode next = reverse.next;
            reverse.next = pre;
            pre = reverse;
            reverse = next;
        }

        // 3.合并2个链表
        ListNode cur = head;
        ListNode start1 = head.next;
        ListNode start2 = pre;
        while (start1 != null && start2 != null) {
            cur.next = start2;
            cur = cur.next;
            start2 = start2.next;

            cur.next = start1;
            cur = cur.next;
            start1 = start1.next;
        }
        if (start2 != null) {
            cur.next = start2;
        }
    }
}

