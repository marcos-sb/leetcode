class Solution {
    public void reorderList(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        final var mid = slow;
        var revCurr = rev(slow);
        var curr = head;
        while (curr != mid) {
            final var currNext = curr.next;
            final var revCurrNext = revCurr.next;
            curr.next = revCurr;
            revCurr.next = currNext;
            curr = currNext;
            revCurr = revCurrNext;
        }
        mid.next = null;
    }
    
    private static ListNode rev(ListNode head) {
        ListNode prev = null;
        var curr = head;
        while (curr != null) {
            final var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
