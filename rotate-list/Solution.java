/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;

        ListNode curr = head;
        ListNode init = null;
        int len = 1;
        while(curr.next != null && len <= k) {
            len++;
            curr = curr.next;
        }

        if(len <= k) {
            final int modK = k % len;
            return rotateRight(head, modK);
        }

        init = head;
        while(curr.next != null) {
            curr = curr.next;
            init = init.next;
        }

        final ListNode newHead = init.next;
        init.next = null;
        curr.next = head;
        return newHead;
    }
}
