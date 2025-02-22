/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final var lenA = len(headA);
        final var lenB = len(headB);
        if (lenA == 0 || lenB == 0) return null;
        var diff = lenA - lenB;
        var longer = diff <= 0 ? headB : headA;
        var shorter = longer == headB ? headA : headB;
        diff = Math.abs(diff);
        while (0 < diff--) longer = longer.next;
        while (longer != null && shorter != null) {
            if (longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    private static int len(ListNode head) {
        var res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
