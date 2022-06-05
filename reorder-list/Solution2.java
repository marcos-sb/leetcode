class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        final var q = new ArrayDeque<ListNode>();
        var curr = head.next;
        while (curr != null) {
            q.offerLast(curr);
            curr = curr.next;
        }
        
        var tail = head;
        var i = 0;
        while (!q.isEmpty()) {
            final var next = i % 2 == 0 ? q.pollLast() : q.pollFirst();
            tail.next = next;
            tail = next;
            i++;
        }
        tail.next = null;
    }
}
