class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final var dummy = new ListNode(); dummy.next = head;
        var first = dummy;
        while (first != null && n-- > 0) {
            first = first.next;
        }
        var second = dummy;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
