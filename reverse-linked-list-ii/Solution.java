class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        final var dummyHead = new ListNode();
        dummyHead.next = head;
        var prev = dummyHead;
        var curr = head;
        for (var i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = rev(curr, right-left+1);

        return dummyHead.next;
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
        head.next = curr;
        
        return prev;
    }
}
