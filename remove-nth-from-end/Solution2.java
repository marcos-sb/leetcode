class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final var dummy = new ListNode(-1);
        dummy.next = head;
        var l = dummy;
        var r = dummy;
        while (n-- >= 0) r = r.next;
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
