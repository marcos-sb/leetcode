class Solution {
    public ListNode swapPairs(ListNode head) {
        final var dummyHead = new ListNode(0, head);
        var prev = dummyHead;
        var curr = head;
        while (curr != null && curr.next != null) {
            final var next = curr.next.next;
            curr.next.next = curr;
            prev.next = curr.next;
            curr.next = next;
            prev = curr;
            curr = next;
        }
        return dummyHead.next;
    }
}
