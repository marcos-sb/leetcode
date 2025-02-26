class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = new ListNode();
        dummy.next = head;
        var marker = dummy;
        while (0 < n--) {
            marker = marker.next;
        }
        var curr = dummy;
        while (marker.next != null) {
            marker = marker.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
