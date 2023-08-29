class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        final var dummyHead = new ListNode();
        dummyHead.next = head;;
        var slow = dummyHead;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) return true;
        
        var revHead = fast == null ? reverse(slow.next) : reverse(slow.next.next);
        slow.next = null;
        while (head != null && revHead != null) {
            if (head.val != revHead.val) return false;
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
    
    private static ListNode reverse(ListNode head) {
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
