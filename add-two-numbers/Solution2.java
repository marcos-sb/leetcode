class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var dummyHead = new ListNode();
        var tail = dummyHead;
        var carry = 0;
        while (l1 != null || l2 != null) {
            final var l1n = l1 == null ? 0 : l1.val;
            final var l2n = l2 == null ? 0 : l2.val;
            final var val = carry + l1n + l2n;
            tail.next = new ListNode(val % 10);
            tail = tail.next;
            carry = val / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (0 < carry) tail.next = new ListNode(carry);
        
        return dummyHead.next;
    }
}
