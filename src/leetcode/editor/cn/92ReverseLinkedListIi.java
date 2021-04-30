package leetcode.editor.cn;

// 92 反转链表 II
// 2021-04-22 11:52:40

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 872 👎 0


import util.ListNode;

class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            dummy.next = head;
            int i = 0;
            while (i < left - 1) {
                i++;
                pre = pre.next;
            }
            // pre.next 是需要处理的节点
            ListNode cur = pre.next;
            ListNode next = null;
            ListNode temp = null;

            while (i < right) {
                next = cur.next;
                cur.next = temp;
                temp = cur;
                cur = next;
                i++;
            }
            pre.next.next = next;
            pre.next = temp;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}