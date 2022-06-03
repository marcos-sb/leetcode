public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final var la = len(headA);
        final var lb = len(headB);
        var dab = la - lb;
        
        if (0 < dab) while (0 < dab--) headA = headA.next;
        else while (dab++ < 0) headB = headB.next;
        
        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private static int len(ListNode node) {
        var res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }
}