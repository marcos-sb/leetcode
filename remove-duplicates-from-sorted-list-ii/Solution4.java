class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        final var dummyHead = new ListNode();
        dummyHead.next = head;
        var prev = dummyHead;
        var curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next != curr) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
