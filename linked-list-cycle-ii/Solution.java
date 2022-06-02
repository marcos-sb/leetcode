public class Solution {
    public ListNode detectCycle(ListNode head) {
        final var seen = new HashSet<ListNode>();
        while (head != null && !seen.contains(head)) {
            seen.add(head);
            head = head.next;
        }
        return head;
    }
}
