class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        var fast = head;
        var slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        prev = null;
        if (fast != null) slow = slow.next; // Odd length
        while (slow != null) {
            final var next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (head != null && prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }

        return head == null && prev == null;
    }
}
