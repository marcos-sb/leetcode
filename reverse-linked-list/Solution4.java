class Solution {
    public ListNode reverseList(ListNode head) {
        final var stack = new LinkedList<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        final var dummyHead = new ListNode();
        var tail = dummyHead;
        while (!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        
        return dummyHead.next;
    }
}
