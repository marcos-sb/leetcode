public class CycleDetection{
    public static boolean detectCycle(LinkedListNode head) {
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}
