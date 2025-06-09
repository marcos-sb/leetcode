class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right-left == 0) {
            return head;
        }

        final var dummyHead = new ListNode(-1, head);
        var prev = dummyHead;
        for (var i = 1; i < left; ++i) {
            prev = prev.next;
        }

        final var start = prev.next;
        final var revHead = rev(start, right-left+1);
        prev.next = revHead;

        return dummyHead.next;
    }

    private static ListNode rev(ListNode head, int length) {
        if (length == 1) {
            return head;
        }

        ListNode prev = null;
        var curr = head;

        while (0 < length--) {
            final var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;

        return prev;
    }
}
