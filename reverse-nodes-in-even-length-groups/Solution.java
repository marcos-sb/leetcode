class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        var pHead = head;
        var gHead = head;
        var curr = head;
        for (var glen = 1; curr != null; glen++) {
            gHead = curr;
            var gcount = 0;
            while (curr != null && gcount < glen) {
                curr = curr.next;
                gcount++;
            }
            if (gcount % 2 == 0) {
                pHead.next = rev(gHead, gcount);
                gHead.next = curr;
                pHead = gHead;
            } else while (pHead.next != curr) {
                pHead = pHead.next;
            }
        }

        return head;
    }

    private static ListNode rev(ListNode head, int k) {
        ListNode prev = null;
        var curr = head;
        while (0 < k--) {
            final var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
