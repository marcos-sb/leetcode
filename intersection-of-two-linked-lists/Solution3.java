public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        final var seen = new HashSet<ListNode>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (seen.contains(headA)) return headA;
                seen.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (seen.contains(headB)) return headB;
                seen.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}