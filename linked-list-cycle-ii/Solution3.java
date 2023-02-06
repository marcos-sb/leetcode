public class Solution {
    public ListNode detectCycle(ListNode head) {
        final var seen = new HashSet<ListNode>(10000);
        while (head != null) {
            if (seen.contains(head)) return head;
            seen.add(head);
            head = head.next;
        }
        return null;
    }
}
