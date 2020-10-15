class Solution {
    private int length = 0;
    private int kmod = 0;
    
    public ListNode rotateRight(ListNode head, int k) {
        return rotateRight(head, head, k);
    }
    
    private ListNode rotateRight(ListNode head, ListNode curr, int k) {
        if (k == 0) return head;
        if (curr == null) return null;
        length++;
        
        final var next = rotateRight(head, curr.next, k);
        if (next == null) { // curr is the last node
            kmod = k % length;
            curr.next = head;
        }
        if (kmod-- == 0) {
            final var ret = curr.next;
            curr.next = null;
            return ret;
        } else if (kmod < 0) return next;
        
        return curr;
    }
}
