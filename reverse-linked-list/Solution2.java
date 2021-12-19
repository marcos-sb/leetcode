class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode prev = null;
        var cur = head;
        while (cur != null) {
            final var oldNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = oldNext;
        }
        
        return prev;
    }
}
