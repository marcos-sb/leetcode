class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var dummyHead = new ListNode();
        return aux(l1, l2, 0, dummyHead, dummyHead);
    }
    
    private static ListNode aux(ListNode l1, ListNode l2, int carry, ListNode dummyHead, ListNode tail) {
        if (l1 == null && l2 == null) {
            if (0 < carry) tail.next = new ListNode(carry);
            return dummyHead.next;
        }
        final var l1n = l1 == null ? 0 : l1.val;
        final var l2n = l2 == null ? 0 : l2.val;
        final var val = l1n + l2n + carry;
        tail.next = new ListNode(val % 10);
        
        return aux(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10, dummyHead, tail.next);
    }
}
