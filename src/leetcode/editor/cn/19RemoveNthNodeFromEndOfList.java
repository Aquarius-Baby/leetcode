package leetcode.editor.cn;

// 19 删除链表的倒数第 N 个结点
// 2021-04-21 16:42:34

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1327 👎 0


import util.ListNode;

class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return head;
            }
            ListNode p = head;
            ListNode q = head;
            // 当q = 最后一个，p的下一个就是需要删除的
            while (n > 0 && q != null) {
                q = q.next;
                n--;
            }
            if (q == null) {
                head = head.next;
                return head;
            }
            while (q.next != null) {
                q = q.next;
                p = p.next;
            }
            p.next = p.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}