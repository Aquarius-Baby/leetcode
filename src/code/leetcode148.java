package code;

import util.ListNode;


/**
 * 148 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //统计链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        head = dummy.next;
        //共循环logn次，每次循环都将进行一次全链表的遍历并逐步恢复次序
        for (int i = 1; i < length; i += i) {
            //将链表分为四段，第一段为已排序的部分,第二段为待排序的第一部分(由first表示头节点),
            //第三段为待排序的第二部分(由second表示头节点),第四段为未排序的部分(由head节点表示头节点)
            ListNode succ = dummy;
            ListNode first = null;
            ListNode second = null;
            while (head != null) {
                first = head;
                head = cutFromHead(head, i);
                second = head;
                head = cutFromHead(head, i);
                //将两段链接到succ尾部,并移动succ
                succ.next = mergeLists(first, second);
                while (succ.next != null) succ = succ.next;
            }
            head = dummy.next;
        }
        return dummy.next;

    }

    //将链表从head节点开始的n个节点切断，并返回第n+1个节点
    public ListNode cutFromHead(ListNode head, int n) {
        while (head != null && --n > 0) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    //将两个链表合并
    public ListNode mergeLists(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        ListNode dummy = new ListNode(-1);
        ListNode succ = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                succ.next = first;
                first = first.next;
            } else {
                succ.next = second;
                second = second.next;
            }
            succ = succ.next;
        }
        succ.next = first != null ? first : second;
        return dummy.next;
    }

}
