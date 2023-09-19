class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        final var dummyHead = new ListNode();
        dummyHead.next = head;
        var curr = dummyHead;
        var kthLast = dummyHead;
        for (var i = 0; i < k; i++) curr = curr.next;
        
        final var kth = curr;
        
        while (curr != null) {
            curr = curr.next;
            kthLast = kthLast.next;
        }

        final var tmp = kth.val;
        kth.val = kthLast.val;
        kthLast.val = tmp;

        return dummyHead.next;
    }
}
