class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final var len = len(head);
        final var dummy = new ListNode(); dummy.next = head;
        var kth = len-n;
        var cur = dummy;
        while (kth-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private static int len(ListNode node) {
        var len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
