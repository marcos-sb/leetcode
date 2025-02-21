class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            final var next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
