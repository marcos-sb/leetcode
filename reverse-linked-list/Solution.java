public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        final Deque<ListNode> stack = new LinkedList<>();
        while (curr.next != null) {
            stack.offerLast(curr);
            curr = curr.next;
        }
        ListNode newHead = curr;

        while (!stack.isEmpty()) {
            curr.next = stack.peekLast();
            curr = stack.pollLast();
        }
        curr.next = null;

        return newHead;
    }
}
