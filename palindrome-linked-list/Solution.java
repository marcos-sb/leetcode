class Solution {
    public boolean isPalindrome(ListNode head) {
        final var len = length(head);
        if (len == 1) return true;
        
        final var reversed = rev(head, len);
        return equals(reversed[0], reversed[1]);
    }
    
    private static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    private static ListNode[] rev(ListNode node, int len) {
        if (node == null) return new ListNode[0];
        
        final var revLen = len/2;
        if (revLen == 1) {
            final var head1 = node;
            final var head2 = len == 2 ? node.next : node.next.next;
            head1.next = null;
            return new ListNode[]{head1, head2};
        }
        
        var head1 = node;
        var curr = node.next;
        head1.next = null;
        int currlen = 1;
        while (curr != null && currlen < revLen) {
            final var tmp = curr.next;
            curr.next = head1;
            head1 = curr;
            curr = tmp;
            currlen++;
        }
        
        final var head2 = len % 2 == 0 || curr == null ? curr : curr.next;
        return new ListNode[]{head1, head2};
    }
    
    private static boolean equals(ListNode n1, ListNode n2) {
        var currN1 = n1;
        var currN2 = n2;
        while (true) {
            if (currN1 == null && currN2 == null) return true;
            if (currN1 == null || currN2 == null) return false;
            if (currN1.val != currN2.val) return false;
            currN1 = currN1.next;
            currN2 = currN2.next;
        }
    }
}
