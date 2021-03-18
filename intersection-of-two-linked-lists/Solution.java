public class Solution {
    private final Set<ListNode> set = new HashSet<>();
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        
        ListNode nextA = null;
        if (headA != null) {
            nextA = headA.next;
            if (set.contains(headA)) return headA;
            set.add(headA);
        }
        
        ListNode nextB = null;
        if (headB != null) {
            nextB = headB.next;
            if (set.contains(headB)) return headB;
            set.add(headB);
        }
        
        return getIntersectionNode(nextA, nextB);
    }
}
