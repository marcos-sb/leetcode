class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final var len = len(head);
        
        final var i = len - n;
        var cur = head;
        ListNode prev = null;
        for (int j = 0; j < i; j++) {
            prev = cur;
            cur = cur.next;
        }
        
        if (prev == null) return head.next;
        
        prev.next = cur.next;
        return head;
    }
    
    public int len(ListNode node) {
        var len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
