class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        final var dummy = new ListNode(-1, head);
        var pred = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) head = head.next;
                pred.next = head.next;
            } else pred = pred.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}
