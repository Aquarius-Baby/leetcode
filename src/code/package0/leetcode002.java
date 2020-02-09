package code.package0;

import util.ListNode;

/**
 * 002 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class leetcode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        int count = 0;
        int a = 0;
        int b = 0;
        while (l1 != null || l2 != null) {
            if (null == l1) {
                a = 0;
            } else {
                a = l1.val;
                l1 = l1.next;
            }
            if (null == l2) {
                b = 0;
            } else {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + count;
            count = sum / 10;
            start.next = new ListNode(sum % 10);
            start = start.next;
        }
        if (count > 0) {
            start.next = new ListNode(count);
            start = start.next;
        }
        //  有没有都是正确的
        // start.next = null;
        return dummy.next;
    }
}
