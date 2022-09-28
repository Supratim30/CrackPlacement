/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, nth = dummy;
        for (int i = 1; i <= n + 1; i++) cur = cur.next;

        while (cur != null) {
            cur = cur.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return dummy.next;
    }
}
