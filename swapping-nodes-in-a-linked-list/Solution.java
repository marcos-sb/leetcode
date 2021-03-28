class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        final var stack = new ArrayDeque<ListNode>();
        
        ListNode kth = null;
        var curr = head;
        int i = 1;
        while (curr != null) {
            if (i == k) kth = curr;
            stack.offerLast(curr);
            curr = curr.next;
            i++;
        }
        
        i = 1;
        while (i++ < k) stack.pollLast();
        final var last = stack.peekLast();
        final var tmp = last.val;
        last.val = kth.val;
        kth.val = tmp;
        
        return head;
    }
}
