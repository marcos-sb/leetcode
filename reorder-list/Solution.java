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
    public static void reorderList(ListNode head) {
        if (head == null) return;

        int len = 1;
        var curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        if (len <= 2) return;

        int halfLen = (len-1) / 2;
        int fstIdxToRev = halfLen + 1;
        int idx = 1;
        var prev = head;
        curr = head.next;
        while (curr.next != null && idx < fstIdxToRev) {
            curr = curr.next;
            prev = prev.next;
            idx++;
        }

        prev.next = null;
        final var revHead = reverseList(curr);

        curr = head;
        var currRev = revHead;
        while (curr != null && currRev != null) {
            var next = curr.next;
            var revNext = currRev.next;
            curr.next = currRev;
            curr = next;
            currRev.next = next;
            currRev = revNext;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) throw new IllegalArgumentException("");
        if (head.next == null) return head;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            stack.offerLast(curr);
            curr = curr.next;
        }

        ListNode newHead = stack.pollLast();
        ListNode prev = newHead;
        while (!stack.isEmpty()) {
            curr = stack.pollLast();
            prev.next = curr;
            prev = curr;
        }
        curr.next = null;

        return newHead;
    }
}
