class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            var pos = head.next;
            head.next = pre;
            pre = head;
            head = pos;
        }

        return pre;
    }
}
