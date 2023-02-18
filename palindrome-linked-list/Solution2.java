class Solution {
    public boolean isPalindrome(ListNode head) {
        final var dummy = new ListNode(); dummy.next = head;
        final var len = len(head);
        var cur = dummy;
        var _len = len/2;
        while (_len-- > 0) {
            cur = cur.next;
        }
        var revHead = reverse(cur);
        _len = len/2;
        while (_len-- > 0) {
            if (head.val != revHead.val) return false;
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }

    private static int len(ListNode head) {
        var len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private static ListNode reverse(ListNode head) {
        var prev = head;
        var cur = head.next;
        while (cur != null) {
            final var tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
