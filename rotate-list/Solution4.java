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

    public ListNode rotateRight(ListNode head, int k) {
        final var len = length(head);
        if (len == 0) return null;

        var kModLen = k % len;
        if (kModLen == 0) return head;

        var fst = head;
        while (0 < kModLen--) {
            fst = fst.next;
        }

        var snd = head;
        while (fst.next != null) {
            fst = fst.next;
            snd = snd.next;
        }
        final var newHead = snd.next;
        fst.next = head;
        snd.next = null;

        return newHead;
    }

    private static int length(ListNode head) {
        var count = 0;
        while (head != null) {
            head = head.next;
            ++count;
        }
        return count;
    }
}
