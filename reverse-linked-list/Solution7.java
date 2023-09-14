class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        var cur = head;
        while (cur != null) {
            final var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
