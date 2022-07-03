class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        
        final var dummyHead = new ListNode();
        dummyHead.next = head;
        var prev = dummyHead;
        while (prev != null) {
            final var res = revList(prev.next, k);
            prev.next = res[0];
            prev = res[1];
            if (prev != null) prev.next = res[2];
        }
        
        return dummyHead.next;
    }
    
    private static ListNode[] revList(ListNode node, int k) {
        if (node == null) return new ListNode[]{null, null, null};
        
        var aux = node;
        var _k = k;
        while (aux != null && 0 < _k--) {
            aux = aux.next;
        }
        if (0 < _k) return new ListNode[]{node, null, null};
        
        final var tail = node;
        var prev = node;
        node = node.next;
        prev.next = null;
        var next = node.next;
        while (node != null && 0 < --k) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return new ListNode[]{prev, tail, node};
    }
}
