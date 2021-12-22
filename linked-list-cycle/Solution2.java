public class Solution2 {
    public boolean hasCycle(ListNode head) {
        var fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
            if (fast == head) return true;
        }
        return false;
    }
}
