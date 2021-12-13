class Solution {
    public ListNode middleNode(ListNode head) {
        final var mid = len(head) / 2;
        
        var cur = head;
        for (int i = 0; i < mid; i++) cur = cur.next;
        
        return cur;
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
