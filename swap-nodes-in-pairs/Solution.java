class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        final var dummyHead = new ListNode();
        dummyHead.next = head;
        var prev = dummyHead;
        var curr = head;

        while (curr != null && curr.next != null) {
            final var next = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = null;
            prev = curr;
            curr = next;
        }
        prev.next = curr;

        return dummyHead.next;
    }
}
