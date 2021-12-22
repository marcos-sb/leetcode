class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        var prev = head;
        var cur = head.next;
        while (cur != null) {
            if (prev.val == cur.val) prev.next = cur.next;
            else prev = prev.next;
            cur = cur.next;
        }
        return head;
    }
}
