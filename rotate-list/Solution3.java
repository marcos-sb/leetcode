class Solution3 {
    public ListNode rotateRight(ListNode head, int k) {
        final var len = len(head);
        if (len < 2) return head;

        final var kmod = k % len;
        if (kmod == 0 || kmod == len) return head;

        var kptr = head;
        var n = kmod;
        while (kptr != null && n-- > 0)
            kptr = kptr.next;

        ListNode prev = null;
        var curr = head;
        while (kptr != null) {
            prev = curr;
            curr = curr.next;
            kptr = kptr.next;
        }
        prev.next = null;
        final var newHead = curr;

        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = head;

        return newHead;
    }

    private static int len(ListNode node) {
        var count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
