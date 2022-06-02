public class Solution {
    public ListNode detectCycle(ListNode head) {
        var p = head;
        var pfast = head;
        while (pfast != null && pfast.next != null) {
            pfast = pfast.next.next;
            p = p.next;
            if (pfast == p) break;
        }
        if (pfast == null || pfast.next == null)
            return null;
        
        p = head;
        while (p != pfast) {
            p = p.next;
            pfast = pfast.next;
        }
        
        return pfast;
    }
}
