public class Solution {
    public boolean hasCycle(ListNode head) {
        var curr = head;
        var fast = head;
        do {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            curr = curr.next;
        } while (curr != fast);
        return true;
    }
}
