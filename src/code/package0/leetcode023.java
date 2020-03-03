package code.package0;

import util.ListNode;

import java.util.PriorityQueue;

/**
 * 023 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class leetcode023 {


    /**
     * 解法1：使用优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode dummy =res;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((n1,n2)->n1.val - n2.val);
        for(int i = 0 ; i < lists.length;i++){
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()){
            ListNode t = queue.poll();
            if(t.next!=null){
                queue.add(t.next);
            }
            dummy.next = t;
            dummy = dummy.next;
        }
        return res;
    }

    /**
     * 解法2：归并排序的思路
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int size = lists.length;
        ListNode res = spilt(lists, 0, size - 1);
        return res;
    }

    public ListNode spilt(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode a = spilt(lists, left, mid);
        ListNode b = spilt(lists, mid + 1, right);
        ListNode res = mergeTwoLists(a, b);
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode newHead = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }

        if (l1 != null) {
            newHead.next = l1;
        }
        if (l2 != null) {
            newHead.next = l2;
        }
        return res.next;
    }
}
