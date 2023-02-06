public class Solution {
    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        
        if (fast == null || fast.next == null)
            return null;
        
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
