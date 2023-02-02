class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return rev(head)[0];
    }
    
    private static ListNode[] rev(ListNode head) {
        if (head.next == null)
            return new ListNode[]{head, head};
        final var res = rev(head.next);
        res[1].next = head;
        res[1] = head;
        head.next = null;
        return res;
    }
}
