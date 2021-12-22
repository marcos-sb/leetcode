class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        final var dummy = new ListNode();
        dummy.next = head;
        var prev = dummy;
        while (head != null) {
            if (head.val == val) prev.next = head.next;
            else prev = prev.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}
